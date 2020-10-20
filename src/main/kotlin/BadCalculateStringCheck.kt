object BadCalculateStringCheck {
    fun checkBlank(input: String) {
        require(!input.isBlank()) {
            "공백은 입력할 수 없습니다."
        }
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
