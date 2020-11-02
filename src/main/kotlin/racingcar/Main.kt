package racingcar

import racingcar.view.InputView
import racingcar.view.ResultView

fun main() {
    val inputView = InputView()
    val numOfCar = inputView.getNumOfCar()
    val numOfTry = inputView.getNumOfTry()

    val racingCars = RacingCars(numOfCar)

    val racingZone = RacingZone()
    val resultOfRace = racingZone.startRaceAndGetResult(racingCars.getCurrentCarList(), numOfTry)

    val resultView = ResultView()
    resultView.showResult(resultOfRace)
}
