import calculator.Operator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class OperatorTest {
    @DisplayName("연산기호에 따른 계산 결과가 맞는지 테스트")
    @ParameterizedTest
    @CsvSource("PLUS,9.0", "MINUS,3.0", "MULTIPLY,18.0", "DIVIDE,2.0")
    fun calculateTest(operator: Operator, result: Double) {
        // given
        val left = 6.0
        val right = 3.0

        // then
        assertThat(operator.calculate(left, right)).isEqualTo(result)
    }
}
