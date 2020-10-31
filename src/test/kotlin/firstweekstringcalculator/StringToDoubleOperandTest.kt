package firstweekstringcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class StringToDoubleOperandTest {

    @Test
    fun isValidOperandToDoubleTwoDecimalPlace() {
        // given
        val operand = "10"
        // then
        assertThat(StringToDoubleOperand().toDoubleTwoDecimalPlace(operand))
            .isEqualTo(10.0)
    }

    @Test
    fun isNotValidOperandToDoubleTwoDecimalPlace() {
        // given
        val operand = "2#"
        // than
        assertThatThrownBy { StringToDoubleOperand().toDoubleTwoDecimalPlace(operand) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("2# 은 피연산자로 사용될 수 없습니다.")
    }
}
