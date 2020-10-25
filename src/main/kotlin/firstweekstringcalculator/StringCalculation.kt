package firstweekstringcalculator

class StringCalculation {

    private val validateCalculateString = ValidateStringCalculation()

    private fun splitCalculateString(calculateString: String): List<String> {
        return calculateString.split(" ")
    }

    private fun operation(result: Double, operand: Int, operator: String): Double {
        return when (operator) {
            "+" -> result + operand
            "-" -> result - operand
            "*" -> result * operand
            "/" -> result / operand
            else -> throw IllegalArgumentException(
                "$operator 를 연산자로 사용하실 수 없습니다. +, -, *, / 의 연산을 사용해주세요."
            )
        }
    }

    private fun calculateAccumulator(calculateList: List<String>): Double {
        var accumulator = calculateList[0].also {
            validateCalculateString.validateOperand(it)
        }.toDouble()

        for (i in 1 until calculateList.size step 2) {
            val operator: String = calculateList[i]
            val operand: Int = calculateList[i + 1].also {
                validateCalculateString.validateOperand(it)
            }.toInt()
            accumulator = operation(accumulator, operand, operator)
        }
        return accumulator
    }

    fun calculate(calculateString: String?): Double {
        val validString = validateCalculateString.validateCalculateString(calculateString)
        val calculateStringList: List<String> = splitCalculateString(validString).also {
            validateCalculateString.validateCalculateList(it)
        }

        return calculateAccumulator(calculateStringList)
    }
}
