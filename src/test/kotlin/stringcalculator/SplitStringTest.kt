package stringcalculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class SplitStringTest {
    @Test
    fun splitTest() {
        assertThat(SplitString().splitString("1 + 3")).isEqualTo(listOf("1", "+", "3"))
    }

    @Test
    fun checkSizeTest() {
        Assertions.assertThatThrownBy { SplitString().splitString("2 +") }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("계산 식이 아닙니다.")
    }
}