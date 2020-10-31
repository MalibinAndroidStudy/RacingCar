package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class RacingZoneTest {
    @DisplayName("차들을 numOfTry횟수만큼 레이스 한 결과를 반환")
    @ParameterizedTest
    @EnumSource(CarEnum::class)
    fun startRaceAndGetResultTest(carEnum: CarEnum) {
        //given
        val racingZone = RacingZone()
        //when
        val carList = carEnum.carList
        val numOfTry = carEnum.numOfTry
        //then
        assertThat(racingZone.startRaceAndGetResult(carList, numOfTry)).isNotBlank()
    }
}

enum class CarEnum(
    val carList: MutableList<RacingCar>,
    val numOfTry: Int
) {
    CarList1(mutableListOf(RacingCar(), RacingCar()), 5),
    CarList2(mutableListOf(RacingCar(), RacingCar(), RacingCar()), 3)
}