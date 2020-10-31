package racingcar

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

internal class ChangeAndCheckNumTest {
    private val changeAndCheckNum = ChangeAndCheckNum()

    @Test
    fun `숫자 입력 테스트`() {
        //given
        val plus = "+"

        // then
        Assertions.assertThatThrownBy { changeAndCheckNum.stringToNum(plus) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자가 입력되어야 합니다. 입력값: $plus")
    }

    @Test
    fun `readLine()이 null값인지 테스트`() {
        //given
        val nullValue = null
        // then
        Assertions.assertThatThrownBy { changeAndCheckNum.stringToNum(nullValue) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("입력값은 null일 수 없습니다.")
    }

    @Test
    fun `숫자가 0보다 큰 수로 입력되었는지 테스트`() {
        //given
        val minusValue = "-2"
        // then
        Assertions.assertThatThrownBy { changeAndCheckNum.stringToNum(minusValue) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage("숫자가 잘못 입력되었습니다.\n 입력값: $minusValue")
    }
}