import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalculatorTestCode {

    @Test
    fun calculateTest() {
        val listString = listOf("4", "+", "2", "/", "3")
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate(listString)).isEqualTo(2)
    }

    @Test
    fun checkOperator() {
        val inspectInput = InspectInput()
        val splitString = listOf("4", "*", "2")
        inspectInput.checkOperator(splitString)
    }

    @Test
    fun checkBlank() {
        val inspectInput = InspectInput()
        val calculateString = " "
        assertThatThrownBy { inspectInput.checkBlank(calculateString) }
    }

    @Test
    fun splitEquationTest() {
        val inspectInput = InspectInput()
        val listString = listOf("1", "+", "3")
        assertThat(listString).isEqualTo(inspectInput.splitEquation("1 + 3"))
    }
}
