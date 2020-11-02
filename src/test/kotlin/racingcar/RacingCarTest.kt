package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import java.util.stream.Stream

/**
 * > 요구사항
 * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
 * 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
 * 전진하는 조건은 0에서 9사이에서 무작위 값을 구한 후 무작위 값이 4이상일 경우이다.
 * 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다. => 계산 즉시 바로 출력 / 계산 다하고 출력
 *
 * > 요구사항 분석
 * 자동차 대수, 횟수를 차례로 입력 받기
 * 대수, 횟수에 대한 검증 - 숫자인지, null이 아닌지 검사하여 입력값을 저장.
 *
 * [1안]
 * 1대를 5번 진행한다고 가정.
 * 자동차 객체 생성
 *  아래 로직 5번 반복
 *      go -> stepList에 "-" 하나 추가
 *      not -> 아무것도 진행 안함
 *      stepList 현재 결과값 plintln으로 출력
 *
 * 2대를 5번씩 진행한다고 가정.
 * 자동차 A,B객체 생성
 *  각각 아래 로직 실행
 *      A자동차 ->   go -> stepList에 "-" 하나 추가
 *                  not -> 아무것도 진행 안함
 *                  stepList 현재 결과값 plintln으로 출력
 *
 *      B자동차 ->   go -> stepList에 "-" 하나 추가
 *                  not -> 아무것도 진행 안함
 *                  stepList 현재 결과값 plintln으로 출력
 *    한 턴 진행했다면 println으로 아래 한 줄 띄우기
 *
 *
 * [2안]
 * main로직
 * inputView에서 자동차 대수, 반복 횟수 입력받아옴
 * 입력받은 자동차 대수만큼 자동차 객체 생성(?) -> 리스트에 저장한다.
 *      자동차가 앞으로 한 칸 갈지 판단 로직. = Random로직
 *      자동차의 현재 위치 정보 - 일급 컬렉션이 갖고 있도록 한다.
 *      현재위치로부터 한 칸 이동시키는 로직
 * 2대를 5번씩 진행한다고 가정.
 * 자동자 A, B객체 생성
 *      A 자동차 -> 현재 스텝 정보, 한칸 갈지 말지 시도하는 로직 필요.
 *
 */
class RacingCarTest {
    @DisplayName("전진했을 때 carStep이 변하는지 테스트")
    @TestFactory
    fun tryGoForwardTest(): Stream<DynamicTest> {
        //given
        val racingCar = RacingCar()
        var carStepList: List<String> = racingCar.getCarStepList()

        //when
        val tryGoForwardGenerator = object : Iterator<List<String>> {
            override fun hasNext(): Boolean {
                carStepList = racingCar.getCarStepList()
                racingCar.tryGoForward()
                return carStepList != racingCar.getCarStepList()
            }

            override fun next(): List<String> {
                return carStepList
            }
        }

        val displayStepGenerator: (steps: List<String>) -> String = { steps -> "step:$steps" }

        val testExecutor: (steps: List<String>) -> Unit = { steps ->
            assertThat(steps).isNotEqualTo(racingCar.getCarStepList())
        }

        //then
        return DynamicTest.stream(tryGoForwardGenerator, displayStepGenerator, testExecutor)
    }
}
