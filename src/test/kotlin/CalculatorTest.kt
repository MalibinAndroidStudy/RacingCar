import calculator.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun calculateStringTest() {
        val input = "2 + 3 * 4 / 2"
        val result = Calculator.calculateString(input)
        assertThat(result).isEqualTo(((2 + 3) * 4 / 2.0))
    }
}
