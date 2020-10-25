package firstweekstringcalculator

class ValidateStringCalculation {

    fun validateCalculateString(calculateString: String?): String {
        if (calculateString.isNullOrBlank()) throw IllegalArgumentException("입력값이 Null 이거나 공백일 수 없습니다")
        return calculateString
    }

    fun validateOperand(operand: String) {
        require(operand.toIntOrNull() is Int) { throw IllegalArgumentException("$operand 은 피연산자로 사용될 수 없습니다.") }
    }

    fun validateCalculateList(list: List<String>) {
        require(list.size >= 3) { throw IllegalArgumentException("입력 받은 값이 수식이 아닙니다!") }
    }
}
