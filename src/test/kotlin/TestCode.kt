import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import stringcalculator.Calculator

class TestCode {

    @Test
    fun simpleTest() {
        assertThat(3 + 5).isEqualTo(8)
    }

    @Test
    fun addBinomialOperation() {
        val calculator = Calculator("3 + 5")
        assertThat(calculator.calculate()).isEqualTo(8.0)
    }

    @Test
    fun minusBinomialOperation() {
        val calculator = Calculator("5 - 3")
        assertThat(calculator.calculate()).isEqualTo(2.0)
    }

    @Test
    fun multipleBinomialOperation() {
        val calculator = Calculator("15 * 3")
        assertThat(calculator.calculate()).isEqualTo(45.0)
    }

    @Test
    fun divideBinomialOperation() {
        val calculator = Calculator("15 / 3")
        assertThat(calculator.calculate()).isEqualTo(5.0)
    }

    @Test
    fun divideZeroIllegalArgumentException() {
        val calculator = Calculator("3 / 0")
        val throwTest: () -> Unit = {
            calculator.calculate()
        }

        assertThatThrownBy(throwTest)
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun multiOperatorOperation() {
        val calculator = Calculator("3 + 5 / 2")
        assertThat(calculator.calculate()).isEqualTo(4.0)
    }

    @Test
    fun noGapWithNumberAndOperation() {
        val calculator = Calculator("3+5/2")
        val throwTest: () -> Unit = {
            calculator.calculate()
        }

        assertThatThrownBy(throwTest)
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun oneOperatorLeak() {
        val calculator = Calculator("3 + 5 -")
        val throwTest: () -> Unit = {
            calculator.calculate()
        }

        assertThatThrownBy(throwTest)
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun lastGapExist() {
        val calculator = Calculator("3 + 5 ")
        val throwTest: () -> Unit = {
            calculator.calculate()
        }

        assertThatThrownBy(throwTest)
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    fun noInput() {
        val calculator = Calculator("")
        val throwTest: () -> Unit = {
            calculator.calculate()
        }

        assertThatThrownBy(throwTest)
            .isInstanceOf(IllegalArgumentException::class.java)
    }



}
