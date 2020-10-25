package stringcalculator

enum class Operator(
    private val symbol: String,
) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLE("*"),
    DIVIDE("/");

    fun hasSymbol(otherSymbol: String): Boolean {
        return this.symbol == otherSymbol
    }

    companion object {
        fun findBySymbol(symbol: String): Operator {
            return values().find { it.hasSymbol(symbol) } ?: throw IllegalArgumentException("$symbol 이 이상해요")
        }
    }
}
