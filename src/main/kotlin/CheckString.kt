object CheckString {
    fun checkBlank(input: String) {
        if (input.equals(" ") || input.isNullOrEmpty()) {
            throw IllegalArgumentException("공백은 입력할 수 없습니다.")
        }
    }

    fun checkOperator(splitString: List<String>): Boolean {
        val operator = listOf("+", "-", "*", "/")
        val eachSplitString = splitString.indices
        for (i in eachSplitString) {
            if (i % 2 == 1) {
                if (!(splitString[i] in operator)) {
                    throw IllegalArgumentException("연산자가 잘못되었습니다.")
                }
            }
        }
        return true
    }
}
