package calculator

import java.lang.NumberFormatException

object ExpressionSplit {
    private val ARITHMETIC_OPERATION = listOf("+", "-", "*", "/")

    private fun checkNullOrBlankString(expression: String?) {
        require(!expression.isNullOrBlank()) { "입력 값이 null 이거나 공백 문자열 입니다." }
    }

    private fun checkArithmeticOperation(operator: String) {
        require(ARITHMETIC_OPERATION.contains(operator)) { "${operator}는 사칙연산 기호가 아닙니다." }
    }

    private fun checkOperand(operand: String) {
        try {
            operand.toInt()
        } catch (e: NumberFormatException) {
            throw NumberFormatException("${operand}는 숫자가 아닙니다.")
        }
    }

    private fun checkExpression(expression: String?) {
        checkNullOrBlankString(expression)
        val splitExpression = expression!!.split(" ")
        for (i in splitExpression.indices) {
            when (i % 2) {
                0 -> checkOperand(splitExpression[i])
                1 -> checkArithmeticOperation(splitExpression[i])
            }
        }
        checkOperand(splitExpression[splitExpression.lastIndex])
    }

    fun getSplitExpression(expression: String?): List<String> {
        checkExpression(expression)
        return expression!!.split(" ")
    }
}
