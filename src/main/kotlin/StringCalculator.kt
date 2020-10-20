

class StringCalculator {

    fun splitEquation(input: String) {
        val splitString: List<String> = input.split(" ")
        activateCheckBadOperator(splitString)
    }

    fun activateCheckBadOperator(splitString: List<String>) {
        BadCalculateStringCheck.checkOperator(splitString)
        calculate(splitString)
    }

    fun calculate(splitString: List<String>) {
        var resultValue = splitString[0].toInt()

        for (i in 1 until splitString.indices.count() step 2) {
            val operator = splitString[i]
            val rightOperand = splitString[i + 1].toInt()
            when (operator) {
                "+" -> {
                    resultValue = add(resultValue, rightOperand)
                }
                "-" -> {
                    resultValue = subtract(resultValue, rightOperand)
                }
                "*" -> {
                    resultValue = multiply(resultValue, rightOperand)
                }
                "/" -> {
                    resultValue = divide(resultValue, rightOperand)
                }
            }
        }
        println("계산한 값은 $resultValue 입니다.")
    }

    fun add(i: Int, j: Int): Int {
        return i + j
    }

    fun subtract(i: Int, j: Int): Int {
        return i - j
    }

    fun multiply(i: Int, j: Int): Int {
        return i * j
    }

    fun divide(i: Int, j: Int): Int {
        return i / j
    }
}
