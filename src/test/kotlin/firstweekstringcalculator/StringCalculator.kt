package firstweekstringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculator {

    @Test
    fun stringCalculatorTestFunction() {
        // given
        val calculationString: String = "2 + 3 * 4 / 2"
        val stringCalculation = StringCalculation()
        // when
        val calculateList = InputCalculationString().toCalculationList(calculationString)

        assertThat(stringCalculation.calculate(calculateList)).isEqualTo(10.0)
    }

    @Test
    fun ariseStringCalculatorIndexOutOfBoundsExceptionContinuousOperand() {
        val calculationString: String = "2 3"
        val stringCalculation = StringCalculation()
        val calculateList = InputCalculationString().toCalculationList(calculationString)

        assertThatThrownBy { stringCalculation.calculate(calculateList) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력받은 값은 수식이 아닙니다!")
    }
}
