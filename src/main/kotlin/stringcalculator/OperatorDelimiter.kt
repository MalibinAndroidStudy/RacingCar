package stringcalculator

class OperatorDelimiter {

    fun makeNumberListFirstAndOperatorListSecond(parsedExpression: List<String>): Pair<MutableList<Double>, MutableList<String>> {
        val numberList = mutableListOf<Double>()
        val operatorList = mutableListOf<String>()
        for (item in parsedExpression) {
            addNumberInList(item, numberList)
            addOperatorInList(item, operatorList)
        }

        return Pair(numberList, operatorList)
    }

    private fun addOperatorInList(inputString: String, operatorList: MutableList<String>) {
        if (!REGEX_IS_NUMBER.matches(inputString)) {
            operatorList.add(inputString)
        }
    }

    private fun addNumberInList(inputString: String, numberList: MutableList<Double>) {
        if (REGEX_IS_NUMBER.matches(inputString)) {
            numberList.add(inputString.toDouble())
        }
    }

    companion object {
        private val REGEX_IS_NUMBER = Regex(
            pattern =
                """^[0-9]*${'$'}"""
        )
    }
}
