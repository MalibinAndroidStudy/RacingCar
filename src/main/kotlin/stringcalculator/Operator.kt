package stringcalculator

import java.lang.IllegalArgumentException

enum class Operator(
    private val symbol: String,
    val calculateStrategy: (Int, Int) -> Int
) {
    PLUS("+", { left, right -> left + right }),
    MINUS("-", { left, right -> left - right }),
    MULTIPLY("*", { left, right -> left * right }),
    DIVIDE("/", { left, right -> left / right });

    fun hasSymbol(otherSymbol: String): Boolean {
        return this.symbol == otherSymbol
    }

    companion object {
        fun findBySymbol(symbol: String): Operator {
            return values().find { it.hasSymbol(symbol) }
                ?: throw IllegalArgumentException("사칙연산 기호만 입력할 수 있습니다. \n 입력 값: $symbol")
        }
    }
}
