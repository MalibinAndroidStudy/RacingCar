package calculator

import java.lang.NumberFormatException

object SplitString {
    private const val SPACE = " "

    fun getSplitExpression(expression: String?): List<String> {
        checkExpression(expression)
        return expression!!.split(" ")
    }

    private fun checkExpression(expression: String?) {
        checkNullOrBlankString(expression)
        val splitExpression = expression!!.split(SPACE)
        for (i in splitExpression.indices) {
            when (i % 2) {
                0 -> checkOperand(splitExpression[i])
                1 -> checkArithmeticOperator(splitExpression[i])
            }
        }
        checkOperand(splitExpression[splitExpression.lastIndex])
    }

    private fun checkNullOrBlankString(expression: String?) {
        require(!expression.isNullOrBlank()) { "입력 값이 null 이거나 공백 문자열 입니다." }
    }

    private fun checkArithmeticOperator(operator: String) {
        Operator.findBySymbol(operator)
    }

    private fun checkOperand(operand: String) {
        try {
            operand.toDouble()
        } catch (e: NumberFormatException) {
            throw NumberFormatException("${operand}는 숫자가 아닙니다.")
        }
    }
}
