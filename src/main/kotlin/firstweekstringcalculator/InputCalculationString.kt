package firstweekstringcalculator

import java.lang.IllegalArgumentException

class InputCalculationString {

    fun toCalculationList(input: String): List<String> {
        return input.also {
            validateNotBlank(it)
        }.split(" ")
    }

    private fun validateNotBlank(input: String) {
        if (input.isBlank()) throw IllegalArgumentException("입력 받은 값이 공백일 수 없습니다.")
    }
}
