package firstweekstringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class InputCalculationStringTest {

    @Test
    fun whenChangeInputStringToListCaseInputStringIsBlank() {
        // given
        val inputValue: String = " "
        val inputCalculationString = InputCalculationString()
        // than
        assertThatThrownBy { inputCalculationString.toCalculationList(inputValue) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력 받은 값이 공백일 수 없습니다.")
    }

    @Test
    fun changeInputStringToList() {
        // given
        val inputValue = "2 + 3"
        val resultList = listOf<String>("2", "+", "3")
        // than
        assertThat(InputCalculationString().toCalculationList(inputValue))
            .isEqualTo(resultList)
    }
}
