package firstweekstringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class OperatorTest {

    @ParameterizedTest
    @CsvSource("PLUS,12", "MINUS,4", "MULTIPLY,32", "DIVIDE,2")
    fun operatorEnumClassTest(operator: Operator, result: Double) {
        val leftValue = 8.0
        val rightValue = 4.0

        assertThat(operator.calculateStrategy(leftValue, rightValue))
            .isEqualTo(result)
    }
}
