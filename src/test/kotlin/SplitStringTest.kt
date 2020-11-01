import calculator.SplitString
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.lang.NumberFormatException

class SplitStringTest {
    @DisplayName("올바른 식을 입력했을 때 문자가 잘 쪼개지는지 테스트")
    @Test
    fun getSplitExpressionTest() {
        val expression = "2 * 3 + 2"
        assertThat(SplitString.getSplitExpression(expression)).isEqualTo(listOf("2", "*", "3", "+", "2"))
    }

    @DisplayName("올바르지 않은 식을 넣었을 때 오류가 뜨는지 테스트")
    @ParameterizedTest
    @CsvSource("2 3", "2 + 3 /")
    fun checkExpressionTest(expression: String) {
        assertThatThrownBy { SplitString.getSplitExpression(expression) }
    }

    @DisplayName("공백 문자열을 넣었을 때 오류가 뜨는지 테스트")
    @Test
    fun checkNullOrBlankStringTest() {
        val expression = " "
        assertThatThrownBy { SplitString.getSplitExpression(expression) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("입력 값이 null 이거나 공백 문자열 입니다.")
    }

    @DisplayName("연산기호 자리에 올바르지 않은 연산기호를 넣었을 때 오류가 뜨는지 테스트")
    @Test
    fun checkArithmeticOperatorTest() {
        val expression = "2 / 4 $ 3 + 4"
        assertThatThrownBy { SplitString.getSplitExpression(expression) }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

    @DisplayName("피연산자 자리에 숫자로 변환할 수 없는 값을 넣었을 때 오류가 뜨는지 테스트")
    @Test
    fun checkOperandTest() {
        val expression = "1 + a / 4 - 3 * 1 "
        assertThatThrownBy { SplitString.getSplitExpression(expression) }
            .isInstanceOf(NumberFormatException::class.java)
    }
}
