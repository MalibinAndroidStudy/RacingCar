package firstweekstringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class OperatorTest {

    @ParameterizedTest
    @CsvSource("PLUS,12", "MINUS,4", "MULTIPLY,32", "DIVIDE,2")
    fun operatorEnumClassTest(operator: Operator, result: Double) {
        val leftValue = 8.0
        val rightValue = 4.0

        assertThat(operator.calculate(leftValue, rightValue))
            .isEqualTo(result)
    }

    @ParameterizedTest
    @CsvSource("+,PLUS", "-,MINUS", "*,MULTIPLY", "/,DIVIDE")
    fun findValidOperator(operatorSymbol: String, operator: Operator) {
        // than
        assertThat(Operator.findByOperatorSymbol(operatorSymbol)).isEqualTo(operator)
    }

    @Test
    fun findNotValidOperator() {
        // than
        assertThatThrownBy { Operator.findByOperatorSymbol("$") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("$ 를 연산자로 사용하실 수 없습니다. +, -, *, / 의 연산을 사용해주세요.")
    }

    @Test
    fun divideStrategyTest() {
        // given
        val leftValue = 8.0
        val rightValue = 0.0
        val operator: Operator = Operator.DIVIDE
        // than
        assertThatThrownBy { operator.calculate(leftValue, rightValue) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("0으로는 나눌 수 없습니다.")
    }
}
