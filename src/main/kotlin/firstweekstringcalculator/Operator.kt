package firstweekstringcalculator

enum class Operator(
    private val operatorSymbol: String,
    val calculateStrategy: (Double, Double) -> Double
) {
    PLUS("+", { leftValue, rightValue -> leftValue + rightValue }),
    MINUS("-", { leftValue, rightValue -> leftValue - rightValue }),
    MULTIPLY("*", { leftValue, rightValue -> leftValue * rightValue }),
    DIVIDE(
        "/",
        { leftValue, rightValue ->
            if (rightValue != 0.0) leftValue / rightValue else throw IllegalArgumentException("0으로는 나눌 수 없습니다.")
        }
    );

    fun hasOperatorSymbol(otherOperatorSymbol: String): Boolean {
        return this.operatorSymbol == otherOperatorSymbol
    }

    fun calculate(leftValue: Double, rightValue: Double): Double = this.calculateStrategy(leftValue, rightValue)

    companion object {
        fun findByOperatorSymbol(operatorSymbol: String): Operator {
            return values().find { it.hasOperatorSymbol(operatorSymbol) }
                ?: throw IllegalArgumentException("$operatorSymbol 를 연산자로 사용하실 수 없습니다. +, -, *, / 의 연산을 사용해주세요.")
        }
    }
}
