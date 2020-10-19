package stringcalculator

class NumberCharacterDistinguisher {

    private val regexIsNumber = Regex(pattern = """^[0-9]*${'$'}""")

    fun makeNumberList(parsedExpression: List<String>): MutableList<Double> {
        var numberList = mutableListOf<Double>()
        for (item in parsedExpression) {
            numberList = addNumberInList(item, numberList)
        }
        return numberList
    }

    fun makeOperatorList(parsedExpression: List<String>): MutableList<String> {
        var operatorList = mutableListOf<String>()
        for (item in parsedExpression) {
            operatorList = addOperatorInList(item, operatorList)
        }

        return operatorList
    }

    private fun addOperatorInList(inputString: String, operatorList: MutableList<String>): MutableList<String> {
        if (!regexIsNumber.matches(inputString)) {
            operatorList.add(inputString)
        }
        return operatorList
    }

    private fun addNumberInList(inputString: String, numberList: MutableList<Double>): MutableList<Double> {
        if (regexIsNumber.matches(inputString)) {
            numberList.add(inputString.toDouble())
        }
        return numberList
    }
}
