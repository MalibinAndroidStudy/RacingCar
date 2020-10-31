package stringcalculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class OperatorTest {

    @ParameterizedTest
    @CsvSource("PLUS,4", "MINUS,2", "MULTIPLY,3", "DIVIDE,3")
    fun plusTest(operator: Operator, result: Int) {
        // given
        val left = 3
        val right = 1
        // then
        assertThat(operator.calculateStrategy(left, right)).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["^"])
    fun operatorTest(operator: String) {
        Assertions.assertThatThrownBy { Operator.findBySymbol(operator) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("사칙연산 기호만 입력할 수 있습니다.")
    }
}
