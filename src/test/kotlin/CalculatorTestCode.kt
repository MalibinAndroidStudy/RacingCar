import calculator.OperatorChecker
import calculator.StringCalculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTestCode {

    @Test
    fun calculateTest() {
        val listString = listOf("4", "+", "2", "/", "3")
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate(listString)).isEqualTo(2)
    }

    @Test
    fun failCalculateTest() {
        val listString = listOf("4", "+", "2", "/", "3")
        val stringCalculator = StringCalculator()
        assertThat(stringCalculator.calculate(listString)).isNotEqualTo(5)
    }

    @Test
    fun checkOperator() {
        val splitString = listOf("4", "*", "2")
        OperatorChecker.checkOperator(splitString)
    }

    @Test
    fun splitEquation() {
        val input: String = "1 + 3"
        val splitString: List<String> = listOf("1", "+", "3")
        assertThat(OperatorChecker.splitEquation(input)).isEqualTo(splitString)
    }

    @Test
    fun failSplitEquation() {
        val input: String = "1 + 3"
        val splitString: List<String> = listOf("1", "+", " 3")
        assertThat(OperatorChecker.splitEquation(input)).isNotEqualTo(splitString)
    }
}
