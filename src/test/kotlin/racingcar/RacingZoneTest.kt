package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RacingZoneTest {
    @DisplayName("차들을 numOfTry횟수만큼 레이스 한 결과를 반환")
    @Test
    fun startRaceAndGetResultTest() {
        //given
        val racingZone = RacingZone()
        val carList = mutableListOf(RacingCar(), RacingCar())
        val numOfTry = 2
        //when
        val actualLineNum = 7
        //then
        assertThat(racingZone.startRaceAndGetResult(carList, numOfTry)
            .split("\n").size)
            .isEqualTo(actualLineNum)
    }
}