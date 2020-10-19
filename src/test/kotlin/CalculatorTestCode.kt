import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CalculatorTestCode {
    @Test
    fun addTest() {
        val stringCalculator = StringCalculator()
        val result = stringCalculator.add(10, 3)
        assertThat(result).isEqualTo(13)
    }

    @Test
    fun subtractTest() {
        val stringCalculator = StringCalculator()
        val result = stringCalculator.subtract(7, 2)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun multiplyTest() {
        val stringCalculator = StringCalculator()
        val result = stringCalculator.multiply(2, 8)
        assertThat(result).isEqualTo(16)
    }

    @Test
    fun divideTest() {
        val stringCalculator = StringCalculator()
        val result = stringCalculator.divide(20, 4)
        assertThat(result).isEqualTo(5)
    }

    @Test
    fun splitEquationTest() {
        val stringCalculator = StringCalculator()
        val splitEquation = stringCalculator.splitEquation("1 + 3")
        val listString = listOf("1", "+", "3")
        assertThat(splitEquation).isEqualTo(stringCalculator.calculate(listString))
    }

    @Test
    fun setUpCalculateTest() {
        val stringCalculator = StringCalculator()
        val listString = listOf("4", "+", "2")
        val result = stringCalculator.setUpCalculate(listString)
        assertThat(result).isEqualTo(6)
    }

    @Test
    fun calculateTest() {
        val listString = listOf("4", "+", "2")
        val stringCalculator = StringCalculator()
        val result = stringCalculator.calculate(listString)
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun checkOperator() {
        val splitString = listOf("4", "*", "2")
        val result = CheckString.checkOperator(splitString)
        assertThat(result).isEqualTo(true)
    }
}
