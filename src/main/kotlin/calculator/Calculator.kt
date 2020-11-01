package calculator

object Calculator {
    private val splitString = SplitString

    fun calculateExpression(expression: String?): Double {
        val splitExpression = splitString.getSplitExpression(expression)
        return calculate(splitExpression)
    }

    private fun calculate(splitExpression: List<String>): Double {
        var accumulation = splitExpression[0].toDouble()
        for (i in 1 until splitExpression.size step 2) {
            val operator = Operator.findBySymbol(splitExpression[i])
            val operand = splitExpression[i + 1].toDouble()
            accumulation = operator.calculate(accumulation, operand)
        }
        return accumulation
    }
}
