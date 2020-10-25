package stringcaclulator

import java.lang.IllegalArgumentException

object Checker {
    private val NUMBER_REGEX = "[0-9]+|[0-9]+[.][0-9]+".toRegex()
    private val OPERATOR_REGEX = "[+]|[-]|[*]|[/]".toRegex()

    fun checkMathExpressionSize(mathExpression: List<String>) {
        require(mathExpression.size >= 3) { throw IllegalArgumentException("연산식의 구성요소는 최소 3개여야 합니다.") }
    }

    fun checkNumber(number: String) {
        val isNumber = NUMBER_REGEX.matches(number)
        if (!isNumber) {
            throw IllegalArgumentException("숫자 위치에 잘못된 값이 들어있습니다. 잘못된 숫자: $number")
        }
    }

    fun checkOperator(operator: String) {
        val isResult = OPERATOR_REGEX.matches(operator)
        if (!isResult) {
            throw IllegalArgumentException("연산자 위치에 잘못된 값이 들어있습니다. 잘못된 연산자: $operator")
        }
    }
}
