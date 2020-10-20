package stringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import stringcaclulator.Calculator
import stringcaclulator.Checker
import java.lang.IllegalArgumentException

class TestCalculator {
    @Test
    fun calculateTest() {
        val calculator = Calculator()
        val result = calculator.calculate("3.0 - 4.5 * 2.7 + 11.05")
        assertThat(result).isEqualTo(((3.0 - 4.5) * 2.7) + 11.05)
    }

    @Test
    fun mathExpressionTest() {
        val checker = Checker()
        assertThatThrownBy {
            checker.checkMathExpressionSize(
                listOf("2", "*")
            )
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun calculateProgressivelyTest() {
        val calculator = Calculator()
        val result = calculator.calculateProgressively(
            listOf("2", "+", "3", "/", "4", "*", "5")
        )
        assertThat(result).isEqualTo(6.25)
    }

    @Test
    fun checkNumberTest() {
        val checker = Checker()
        assertThatThrownBy { checker.checkNumber("*") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun checkOperatorTest() {
        val checker = Checker()
        assertThatThrownBy { checker.checkOperator(".") }
            .isInstanceOf(IllegalArgumentException::class.java)
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
