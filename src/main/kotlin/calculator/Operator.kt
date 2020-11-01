package calculator

enum class Operator(
    private val symbol: String,
    val calculateStrategy: (Double, Double) -> Double
) {
    PLUS("+", { leftOperand, rightOperand -> leftOperand + rightOperand }),
    MINUS("-", { leftOperand, rightOperand -> leftOperand - rightOperand }),
    MULTIPLY("*", { leftOperand, rightOperand -> leftOperand * rightOperand }),
    DIVIDE("/", { leftOperand, rightOperand -> leftOperand / rightOperand });

    fun calculate(leftOperand: Double, rightOperand: Double): Double {
        return this.calculateStrategy(leftOperand, rightOperand)
    }

    fun isEqualSymbol(otherSymbol: String): Boolean {
        return this.symbol == otherSymbol
    }

    companion object {
        fun findBySymbol(symbol: String): Operator {
            return values().find { it.isEqualSymbol(symbol) }
                ?: throw IllegalArgumentException("${symbol}은 사칙연산 기호가 아닙니다.")
        }
    }
}
