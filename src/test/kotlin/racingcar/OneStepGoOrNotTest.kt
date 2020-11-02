package racingcar

import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory
import java.util.stream.Stream

class OneStepGoOrNotTest {
    private val oneStepGoOrNot = OneStepGoOrNot()

    @DisplayName("한 칸 전진 테스트")
    @TestFactory
    fun judgeCanGoTest(): Stream<DynamicTest> {
        val tryGoForwardGenerator = object : Iterator<Boolean> {
            override fun hasNext(): Boolean {
                return oneStepGoOrNot.judgeCanGo()
            }

            override fun next(): Boolean {
                return true
            }
        }

        val displayStepGenerator: (go: Boolean) -> String = { go -> "goOrNot:$go" }

        val testExecutor: (go: Boolean) -> Unit = { go -> assertTrue(go) }

        return DynamicTest.stream(tryGoForwardGenerator, displayStepGenerator, testExecutor)
    }

    @DisplayName("랜덤 숫자 만들기 테스트")
    @Test
    fun createRandomNumTest() {
        //given
        val randomInteger = oneStepGoOrNot.createRandomNum()
        // then
        assertTrue { randomInteger >= 1 }
        assertTrue { randomInteger <= 9 }
    }
}
