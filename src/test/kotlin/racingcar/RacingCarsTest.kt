package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class RacingCarsTest {

    @DisplayName("차량 수만큼 객체 생성")
    @ParameterizedTest
    @ValueSource(strings = ["2", "5"])
    fun prepareCarTest(carNumString: String) {
        //given
        val racingCars = RacingCars()
        // when
        val carNum = carNumString.toInt()
        racingCars.prepareCar(carNum)
        // then
        assertThat(racingCars.getCurrentCarList().size).isEqualTo(carNum)
    }

    @DisplayName("차량 리스트 얻어오기")
    @Test
    fun getCurrentCarListTest() {
        //given
        val racingCars = RacingCars()
        // then
        assertThat(racingCars.getCurrentCarList().size).isEqualTo(0)
    }
}