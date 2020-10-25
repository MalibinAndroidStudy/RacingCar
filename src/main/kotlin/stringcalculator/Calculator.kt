package stringcalculator

class Calculator(inputExpression: String) {

    private var numberList = mutableListOf<Double>()
    private var operatorList = mutableListOf<String>()
    private val operateNumberCharacterDistinguisher = NumberCharacterDistinguisher()

    init {
        val parsedExpressionByDelimiter = inputExpression.split(DELIMITER)

        expressionValidation(parsedExpressionByDelimiter)

        val parsedPairList = operateNumberCharacterDistinguisher
            .makeNumberListFirstAndOperatorListSecond(parsedExpressionByDelimiter)

        numberList = parsedPairList.first
        operatorList = parsedPairList.second
    }

    private fun findEmptyString(parsedExpressionByDelimiter: List<String>): Boolean {
        return parsedExpressionByDelimiter.contains(BLANK)
    }

    private fun add(firstNumber: Double, secondNumber: Double) = firstNumber + secondNumber

    private fun minus(firstNumber: Double, secondNumber: Double) = firstNumber - secondNumber

    private fun multiple(firstNumber: Double, secondNumber: Double) = firstNumber * secondNumber

    private fun divide(firstNumber: Double, secondNumber: Double): Double {
        if (secondNumber == 0.0) {
            throw IllegalArgumentException("0으로 나눌 수 없습니다.")
        }
        return firstNumber / secondNumber
    }

    fun calculate(): Double {
        var returnOperation = if (numberList.isEmpty()) null else numberList.removeAt(0)

        if (numberList.size != operatorList.size) {
            throw IllegalArgumentException("유효한 수식이 아닙니다.")
        }

        if (returnOperation !is Double) {
            throw IllegalArgumentException("숫자가 없는 수식을 입력하셨습니다.")
        }

        for (index in 0 until numberList.size) {
            val operand = Pair(returnOperation, numberList[index])
            returnOperation = calculateBinomial(operand, operatorList[index])
        }

        return returnOperation!!
    }

    private fun calculateBinomial(operand: Pair<Double?, Double>, symbol: String): Double? {
        return when (Operator.findBySymbol(symbol)) {
            Operator.PLUS -> operand.first?.let { add(it, operand.second) }
            Operator.MINUS -> operand.first?.let { minus(it, operand.second) }
            Operator.MULTIPLE -> operand.first?.let { multiple(it, operand.second) }
            Operator.DIVIDE -> operand.first?.let { divide(it, operand.second) }
        }
    }

    private fun expressionValidation(parsedExpression: List<String>) {
        if (parsedExpression[0] == BLANK) {
            throw IllegalArgumentException("빈 수식은 연산이 안됩니다.")
        }

        if (findEmptyString(parsedExpression)) {
            throw IllegalArgumentException("마지막 식에 빈 문자열을 입력하지 마십쇼")
        }
    }

    companion object {
        private const val BLANK = ""
        private const val DELIMITER = " "
    }
}
