package calculator

object Calculator {
    private val expressionSplit = ExpressionSplit

    private fun calculate(splitExpression: List<String>): Double {
        var result = splitExpression[0].toDouble()
        for (i in 1 until splitExpression.size step 2) {
            val operand = splitExpression[i + 1].toDouble()
            when (splitExpression[i]) {
                "+" -> result += operand
                "-" -> result -= operand
                "*" -> result *= operand
                "/" -> result /= operand
            }
        }
        return result
    }

    fun calculateString(expression: String?): Double {
        val splitExpression = expressionSplit.getSplitExpression(expression)
        return calculate(splitExpression)
    }
}
