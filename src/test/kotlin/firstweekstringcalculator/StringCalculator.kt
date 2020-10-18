package firstweekstringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class StringCalculator {

    @Test
    fun stringCalculatorTestFunction() {
        val calculationString: String = "2 + 3 * 4 / 2"
        val stringCalculation = StringCalculation(calculationString)

        val resultCalculationString: Int = stringCalculation.calculateResult()

        assertThat(resultCalculationString).isEqualTo(10)
    }

    @Test
    fun ariseStringCalculatorIllegalArgumentExceptionCaseNull() {
        val calculationString: String? = null
        val stringCalculation = StringCalculation(calculationString)

        val thrownTestFunction: () -> Unit = {
            stringCalculation.calculateResult()
        }

        assertThatThrownBy(thrownTestFunction)
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 Null 이거나 공백일 수 없습니다")
    }

    @Test
    fun ariseStringCalculatorIllegalArgumentExceptionCaseBlank() {
        val calculationString: String = "  "
        val stringCalculation = StringCalculation(calculationString)

        val thrownTestFunction: () -> Unit = {
            stringCalculation.calculateResult()
        }

        assertThatThrownBy(thrownTestFunction)
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력값이 Null 이거나 공백일 수 없습니다")
    }

    @Test
    fun ariseStringCalculatorIllegalArgumentExceptionCaseWrongOperator() {
        val calculationString: String = "2 $ 3 * 4 / 2"
        val stringCalculation = StringCalculation(calculationString)

        val thrownTestFunction: () -> Unit = {
            stringCalculation.calculateResult()
        }

        assertThatThrownBy(thrownTestFunction)
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("연산자로 사용하실 수 없습니다. +, -, *, / 의 연산을 사용해주세요.")
    }

    @Test
    fun ariseStringCalculatorIllegalArgumentExceptionCaseWrongOperand() {
        val calculationString: String = "2 + 3# * 4 / 2"
        val stringCalculation = StringCalculation(calculationString)

        val thrownTestFunction: () -> Unit = {
            stringCalculation.calculateResult()
        }

        assertThatThrownBy(thrownTestFunction)
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("피연산자로 사용될 수 없습니다.")
    }
}
