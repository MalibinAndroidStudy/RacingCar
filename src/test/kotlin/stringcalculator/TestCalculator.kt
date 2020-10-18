package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import stringcaclulator.Calculator

class TestCalculator {
    @Test
    fun calculateTest() {
        val calculator = Calculator()
        val result = calculator.calculate("3.0 - 4.5 * 2.7 + 11.05")
        assertThat(result).isEqualTo(((3.0 - 4.5) * 2.7) + 11.05)
    }

    @Test
    fun splitTextTest() {
        val calculator = Calculator()
        val result = calculator.splitInput("2 3")
        assertThat(result).isEqualTo(listOf("2", "3"))
    }

    @Test
    fun calculateWithSplitListTest() {
        val calculator = Calculator()
        val result = calculator.calculateWithSplitList(
            listOf("2", "+", "3", "/", "4", "*", "5")
        )
        assertThat(result).isEqualTo(6.25)
    }

    @Test
    fun checkThenCalculateTest() {
        val calculator = Calculator()
        val result = calculator.checkThenCalculate("/", 3.0, "2")
        assertThat(result).isEqualTo(1.5)
    }

    @Test
    fun checkNumberTest() {
        val calculator = Calculator()
        val result = calculator.checkNumber("134")
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun checkOperatorTest() {
        val calculator = Calculator()
        val result = calculator.checkOperator("-")
        assertThat(result).isEqualTo(true)
    }

    @Test
    fun addTest() {
        val calculator = Calculator()
        val result = calculator.add(0.57, 0.48)
        assertThat(result).isEqualTo(0.57 + 0.48)
    }

    @Test
    fun subtractTest() {
        val calculator = Calculator()
        val result = calculator.subtract(10.1, 11.44)
        assertThat(result).isEqualTo(-1.34)
    }

    @Test
    fun divisionTest() {
        val calculator = Calculator()
        val result = calculator.divide(5.3, 10.7)
        assertThat(result).isEqualTo(5.3 / 10.7)
    }

    @Test
    fun multiplyTest() {
        val calculator = Calculator()
        val result = calculator.multiply(5.0, 2.0)
        assertThat(result).isEqualTo(5.0 * 2.0)
    }
}
