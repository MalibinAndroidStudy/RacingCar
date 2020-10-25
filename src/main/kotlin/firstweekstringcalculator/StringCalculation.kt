package firstweekstringcalculator

class StringCalculation {

    private val validateCalculateString = ValidateStringCalculation()

    private fun splitCalculateString(calculateString: String): List<String> {
        return calculateString.split(" ")
    }

    private fun operation(result: Double, operand: Double, operatorSymbol: String): Double {
        val operator = Operator.findByOperatorSymbol(operatorSymbol)
        return operator.calculateStrategy(result, operand)
    }

    private fun calculateAccumulator(calculateList: List<String>): Double {
        var accumulator = calculateList[0].also {
            validateCalculateString.validateOperand(it)
        }.toDouble()

        for (i in 1 until calculateList.size step 2) {
            val operator: String = calculateList[i]
            val operand: Double = calculateList[i + 1].also {
                validateCalculateString.validateOperand(it)
            }.toDouble()
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
