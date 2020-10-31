package stringcalculator

import org.assertj.core.api.Assertions
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

/**
 * 2주차 리팩터링 사고과정
 * 1 + 2 * 3 - 1 / 4
 * 문자열로 받았다 -> 쪼개는 과정이 있어야 할 것이다.
 *
 * 쪼갠 문자열 하나씩 유효한 문자인지 검증하는 과정이 있어야 한다
 *  -> 계산식이 맞는지 : 2 + 3 처럼 쪼갰을 때 배열의 최대 index가 2 이상 나와야 함
 *  -> 홀수 index면 숫자인지
 *  -> 짝수 index면 사칙연산자인지
 *
 * 계산하기
 * 숫자 -> 연산자 -> 숫자 -> 연산자 -> 숫자 순서.
 * 이전 계산 결과 데이터에
 *      해당 연산자에 맞는 계산으로 다음 숫자와 연산된 값을 결과에 대입.
 *
 * 문자열 입력 -> 쪼갬 -> 검증 -> 계산 -> 출력 5단계 과정
 *
 */
class StringCalculatorTest {
    @Test
    fun calculateTest() {
        assertThat(
            StringCalculator()
                .calculate(listOf("1", "+", "8", "/", "3", "*", "2", "-", "1")))
            .isEqualTo(5)
    }

    @Test
    fun changeToNumTest() {
        Assertions.assertThatThrownBy { StringCalculator()
            .calculate(listOf("1", "+", "+")) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("해당 문자는 숫자로 변환할 수 없습니다.")
    }
}
