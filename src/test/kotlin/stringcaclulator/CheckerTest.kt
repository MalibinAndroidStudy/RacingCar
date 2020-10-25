package stringcaclulator

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

internal class CheckerTest {
    @ParameterizedTest
    @MethodSource("generateMathExpression")
    fun checkMathExpressionSize(mathExpressionList: List<String>) {
        assertThatCode {
            Checker.checkMathExpressionSize(mathExpressionList)
        }.doesNotThrowAnyException()
    }

    @ParameterizedTest
    @MethodSource("generateWrongMathExpression")
    fun `사용자가 3개 이하의 문자를 가지는 문자열 수학식을 입력했을 때 이것을 구별해내는지 테스트`(wrongMathExpression: List<String>) {
        assertThatThrownBy {
            Checker.checkMathExpressionSize(wrongMathExpression)
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @ParameterizedTest
    @CsvSource("2", "1.0", "0", "0.0", "7.8")
    fun checkNumber(number: String) {
        assertThatCode { Checker.checkNumber(number) }
            .doesNotThrowAnyException()
    }

    @ParameterizedTest
    @CsvSource("+", ".", "*", "-", "*", "/")
    fun `숫자가 아닌 것을 구별해내는지 테스트`(nonNumber: String) {
        assertThatThrownBy { Checker.checkNumber(nonNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("연산자 유효성 테스트")
    @ParameterizedTest
    @CsvSource("+", "-", "*", "/")
    fun checkOperator(operator: String) {
        assertThatCode { Checker.checkOperator(operator) }
            .doesNotThrowAnyException()
    }

    @ParameterizedTest
    @CsvSource("2", ".", "&", "3.0", "0", "0.0", "$", "@")
    fun `연산자가 아닌 것을 구분해내는지 테스트`(operator: String) {
        assertThatThrownBy { Checker.checkOperator(operator) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    companion object {
        @JvmStatic
        fun generateMathExpression() = listOf(
            Arguments.of(listOf("2", "+", "3")),
            Arguments.of(listOf("2", "+", "3", "-", "5"))
        )

        @JvmStatic
        fun generateWrongMathExpression() = listOf(
            Arguments.of(listOf("2", " ")),
            Arguments.of(listOf("6", "3")),
            Arguments.of(listOf("5", "*")),
            Arguments.of(listOf("5")),
            Arguments.of(listOf("")),
            Arguments.of(listOf("-")),
            Arguments.of(listOf(" "))
        )
    }
}
