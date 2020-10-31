import racingcar.RacingZone
import racingcar.RacingCars
import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val numOfCar = inputView.getNumOfCar()
    val numOfTry = inputView.getNumOfTry()

    val racingCars = RacingCars()
    RacingCars().prepareCar(numOfCar)

    val racingZone = RacingZone()
    val resultOfRace = racingZone.startRaceAndGetResult(racingCars.getCurrentCarList(), numOfTry)

    val resultView = ResultView()
    resultView.showResult(resultOfRace)
}
