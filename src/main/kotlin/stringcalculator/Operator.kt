package stringcalculator

enum class Operator(
    private val symbol: String,
    private val calculateStrategy: (Double, Double) -> Double
) {
    PLUS("+", { leftValue, rightValue -> leftValue + rightValue }),
    MINUS("-", { leftValue, rightValue -> leftValue - rightValue }),
    MULTIPLE("*", { leftValue, rightValue -> leftValue * rightValue }),
    DIVIDE(
        "/",
        { leftValue, rightValue ->
            require(rightValue != 0.0) { "0으로 나눌 수 없습니다." }
            leftValue / rightValue
        }
    );

    private fun hasSymbol(otherSymbol: String): Boolean {
        return this.symbol == otherSymbol
    }

    fun calculateStrategical(leftValue: Double, rightValue: Double): Double {
        return this.calculateStrategy(leftValue, rightValue)
    }

    companion object {
        fun findBySymbol(symbol: String): Operator {
            return values().find { it.hasSymbol(symbol) } ?: throw IllegalArgumentException("$symbol 이 이상해요")
        }
    }
}
