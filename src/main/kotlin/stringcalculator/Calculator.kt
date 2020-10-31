package stringcalculator

class Calculator(inputExpression: String) {

    private val parsedPairList: Pair<MutableList<Double>, MutableList<String>>

    init {
        val parsedExpressionByDelimiter = inputExpression.split(DELIMITER)
        expressionValidation(parsedExpressionByDelimiter)
        parsedPairList = OperatorDelimiter()
            .makeNumberListFirstAndOperatorListSecond(parsedExpressionByDelimiter)
    }

    private fun findEmptyString(parsedExpressionByDelimiter: List<String>): Boolean {
        return parsedExpressionByDelimiter.contains(BLANK)
    }

    fun calculate(): Double {
        val numberList = parsedPairList.first
        val operatorList = parsedPairList.second

        var returnOperation = if (numberList.isEmpty()) null else numberList.removeAt(0)

        require(numberList.size == operatorList.size) { "유효한 수식이 아닙니다." }
        require(returnOperation is Double) { "숫자가 없는 수식을 입력하셨습니다." }

        for (index in 0 until numberList.size) {
            val operand = Pair(returnOperation, numberList[index])
            returnOperation = calculateBinomial(operand, operatorList[index])
        }

        return returnOperation!!
    }

    private fun calculateBinomial(operand: Pair<Double?, Double>, symbol: String): Double? =
        operand.first?.let { Operator.findBySymbol(symbol).calculateStrategical(it, operand.second) }

    private fun expressionValidation(parsedExpression: List<String>) {
        require(parsedExpression[0] != BLANK) { "빈 수식은 연산이 안됩니다." }
        require(!findEmptyString(parsedExpression)) { "마지막 식에 빈 문자열을 입력하지 마십쇼" }
    }

    companion object {
        private const val BLANK = ""
        private const val DELIMITER = " "
    }
}
