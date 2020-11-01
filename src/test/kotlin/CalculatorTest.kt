import calculator.Calculator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {
    @DisplayName("식의 계산 결과가 맞는지 테스트")
    @ParameterizedTest
    @CsvSource("2 * 3 + 2 / 4,2.0", "3 + 5 / 4 - 1 * 3 ,3.0")
    fun calculateTest(expression: String, result: Double) {
        assertThat(Calculator.calculateExpression(expression)).isEqualTo(result)
    }
}
