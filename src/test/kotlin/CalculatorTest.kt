import calculator.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class CalculatorTest {
    @Test
    fun addTest() {
        val arg1 = 3
        val arg2 = 4
        val sum = Calculator.add(arg1, arg2)
        assertThat(sum).isEqualTo(7)
    }

    @Test
    fun subtractTest() {
        val arg1 = 3
        val arg2 = 4
        val sub = Calculator.subtract(arg1, arg2)
        assertThat(sub).isEqualTo(-1)
    }

    @Test
    fun multiplyTest() {
        val arg1 = 3
        val arg2 = 4
        val multi = Calculator.multiply(arg1, arg2)
        assertThat(multi).isEqualTo(12)
    }

    @Test
    fun divideTest() {
        val arg1 = 5
        val arg2 = 4
        val divide = Calculator.divide(arg1, arg2)
        assertThat(divide).isEqualTo(1)
    }

    @Test
    fun checkNullOrBlankTest() {
        var inputValue: String? = " "
        assertThatThrownBy { Calculator.checkNullOrBlank(inputValue) }
    }

    @Test
    fun checkArithmeticOperationsTest() {
        var inputValue = "&"
        assertThatThrownBy { Calculator.checkArithmeticOperations(inputValue) }
    }

    @Test
    fun calculateTest() {
        val operator = "*"
        val operand1 = 3
        val operand2 = 4
        val result = Calculator.calculate(operator, operand1, operand2)
        assertThat(result).isEqualTo(12)
    }

    @Test
    fun calculateStringTest() {
        val input = "2 + 3 * 4 / 2"
        val result = Calculator.calculateString(input)
        assertThat(result).isEqualTo(10)
    }
}
