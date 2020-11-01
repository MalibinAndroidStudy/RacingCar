package stringcaclulator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class CalculatorTest {
    @ParameterizedTest
    @MethodSource("generateCalculateParameter")
    fun calculateTest(mathExpression: String, expectedResult: Double) {
        // given
        val calculator = Calculator()
        // when
        val result = calculator.calculate(mathExpression.split(" "))
        // then
        assertThat(result).isEqualTo(expectedResult)
    }

    @DisplayName("더하기 연산 테스트")
    @ParameterizedTest
    @CsvSource(
        "0.57 + 0.48, 1.05",
        "3 + 4, 7",
        "1.00 + 5, 6.0",
    )
    fun addTest(mathExpression: String, expectedResult: Double) {
        // given
        val calculator = Calculator()
        // when
        val result = calculator.calculate(mathExpression.split(" "))
        assertThat(result).isEqualTo(expectedResult)
    }

    @DisplayName("빼기 연산 테스트")
    @ParameterizedTest
    @CsvSource(
        "10.1 - 11.44, -1.34",
        "5 - 2, 3.0",
        "1.0 - 5, -4.00"
    )
    fun subtractTest(mathExpression: String, expectedResult: Double) {
        // given
        val calculator = Calculator()
        // when
        val result = calculator.calculate(mathExpression.split(" "))
        assertThat(result).isEqualTo(expectedResult)
    }

    @DisplayName("나누기 연산 테스트")
    @ParameterizedTest
    @CsvSource(
        "10 / 2, 5.0",
        "2 / 0.1, 20.0"
    )
    fun divisionTest(mathExpression: String, expectedResult: Double) {
        // given
        val calculator = Calculator()
        // when
        val result = calculator.calculate(mathExpression.split(" "))
        // then
        assertThat(result).isEqualTo(expectedResult)
    }

    @DisplayName("곱하기 연산 테스트")
    @ParameterizedTest
    @CsvSource(
        "10 * 2, 20.0",
        "2 * 0.1, 0.2",
        "0.3 * 0.6, 0.18"
    )
    fun multiplyTest(mathExpression: String, expectedResult: Double) {
        // given
        val calculator = Calculator()
        // when
        val result = calculator.calculate(mathExpression.split((" ")))
        // then
        assertThat(result).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun generateCalculateParameter() = listOf(
            Arguments.of("3.0 - 4.5 * 2.7 + 11.05", ((3.0 - 4.5) * 2.7) + 11.05),
            Arguments.of("2 - 3 * 4 + 5", ((2 - 3) * 4) + 5),
            Arguments.of("4.0 / 1.9 + 2 * 5", ((4.0 / 1.9) + 2) * 5)
        )
    }
}
