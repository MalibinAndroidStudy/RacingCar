package firstweekstringcalculator

import java.lang.IllegalArgumentException

enum class Operator(
    private val operatorSymbol: String,
    val calculateStrategy: (Double, Double) -> Double
) {
    PLUS("+", { leftValue, rightValue -> leftValue + rightValue }),
    MINUS("-", { leftValue, rightValue -> leftValue - rightValue }),
    MULTIPLY("*", { leftValue, rightValue -> leftValue * rightValue }),
    DIVIDE("/", { leftValue, rightValue -> leftValue / rightValue });

    fun hasOperatorSymbol(otherOperatorSymbol: String): Boolean {
        return this.operatorSymbol == otherOperatorSymbol
    }

    companion object {
        fun findByOperatorSymbol(operatorSymbol: String): Operator {
            return values().find { it.hasOperatorSymbol(operatorSymbol) }
                ?: throw IllegalArgumentException("$operatorSymbol 를 연산자로 사용하실 수 없습니다. +, -, *, / 의 연산을 사용해주세요.")
        }
    }
}
