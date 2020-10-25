class StringCalculator {
    fun calculate(splitString: List<String>): Int {
        var accumulateValue = splitString[0].toInt()

        for (i in 1 until splitString.indices.count() step 2) {
            val rightValue = splitString[i + 1].toInt()
            val inputOperator = splitString[i]

            val operator = Operator.findBySymbol(inputOperator)
            operator.calculateMethod(accumulateValue, rightValue)
        }
        return accumulateValue
    }
}
