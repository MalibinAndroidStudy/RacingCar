package stringcalculator

class Calculator(val inputExpression: String) {

    private var numberList = mutableListOf<Double>()
    private var operatorList = mutableListOf<String>()
    private val operateNumberCharacterDistinguisher = NumberCharacterDistinguisher()

    fun preprocessingNumberListAndOperatorList(inputExpression: String) {
        val parsedExpressionByDelimiter = inputExpression.split(" ")

        if (parsedExpressionByDelimiter[0] == "") {
            throw IllegalArgumentException("빈 수식은 연산이 안됩니다.")
        }

        if (findEmptyString(parsedExpressionByDelimiter)) {
            throw IllegalArgumentException("마지막 식에 빈 문자열을 입력하지 마십쇼")
        }

        numberList = operateNumberCharacterDistinguisher
            .makeNumberList(parsedExpressionByDelimiter)
        operatorList = operateNumberCharacterDistinguisher
            .makeOperatorList(parsedExpressionByDelimiter)
    }

    private fun findEmptyString(parsedExpressionByDelimiter: List<String>): Boolean {
        return parsedExpressionByDelimiter.contains("")
    }

    private fun returnSum(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber + secondNumber
    }

    private fun returnMinus(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber - secondNumber
    }

    private fun returnMultiple(firstNumber: Double, secondNumber: Double): Double {
        return firstNumber * secondNumber
    }

    private fun returnDivide(firstNumber: Double, secondNumber: Double): Double {
        if (secondNumber == 0.0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        return firstNumber / secondNumber
    }

    fun calculate(): Double {
        preprocessingNumberListAndOperatorList(inputExpression)
        var returnOperation = dequeueNumberList(numberList)

        if (returnOperation !is Double) {
            throw IllegalArgumentException("숫자가 없는 수식을 입력하셨습니다.")
        }

        if (numberList.size != operatorList.size) {
            throw IllegalArgumentException("숫자의 갯수와 연산자의 개수가 일치하지 않습니다.")
        }

        for (index in 0..(numberList.size - 1)) {
            returnOperation = returnOperation?.let { calculateBinomial(it, numberList[index], operatorList[index]) }
        }

        return returnOperation!!
    }

    private fun dequeueNumberList(numberList: MutableList<Double>): Double? {
        if (numberList.isEmpty()) {
            return null
        } else {
            return numberList.removeAt(0)
        }
    }

    private fun calculateBinomial(firstNumber: Double, secondNumber: Double, operator: String): Double {
        return when (operator) {
            "+" -> returnSum(firstNumber, secondNumber)
            "-" -> returnMinus(firstNumber, secondNumber)
            "*" -> returnMultiple(firstNumber, secondNumber)
            "/" -> returnDivide(firstNumber, secondNumber)
            else -> throw IllegalArgumentException("지정한 연산자 이외에는 다른 문자를 삽입할 수 없습니다.")
        }
    }
}
