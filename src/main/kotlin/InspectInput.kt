object InspectInput {
    fun checkBlank(input: String) {
        require(input.isNotBlank()) {
            "공백은 입력할 수 없습니다."
        }
    }

    fun splitEquation(input: String): List<String> {
        val splitString: List<String> = input.split(" ")
        checkOperator(splitString)

        return splitString
    }

    fun checkOperator(splitString: List<String>) {
        val operator = listOf("+", "-", "*", "/")
        for (i in 1 until splitString.indices.count() step 2) {
            require(splitString[i] in operator) {
                "연산자가 잘못되었습니다."
            }
        }
    }
}
