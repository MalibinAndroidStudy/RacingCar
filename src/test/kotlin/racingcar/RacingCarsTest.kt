package racingcar

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class RacingCarsTest {

    @DisplayName("차량 리스트 얻어오기")
    @Test
    fun getCurrentCarListTest() {
        //given
        val racingCars = RacingCars(3)
        // then
        assertThat(racingCars.getCurrentCarList().size).isEqualTo(3)
    }
}