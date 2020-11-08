package racingcar

class RacingZone {

    fun startRaceAndGetResult(carList: MutableList<RacingCar>, numOfTry: Int): String {
        var resultOfRace = ""
        repeat(numOfTry){
            runOneCycle(carList)
            resultOfRace += getOneCycleResult(carList) + LINE_SPACE
        }
        return resultOfRace
    }

    private fun runOneCycle(carList: MutableList<RacingCar>) {
        carList.forEach { racingCar ->
            racingCar.tryGoForward()
        }
    }

    private fun getOneCycleResult(carList: MutableList<RacingCar>): String {
        var resultOfOneCycle = ""
        carList.forEach { racingCar ->
            val cycleOfOneCar = racingCar.getCarStepList().joinToString(separator = "")
            resultOfOneCycle += (cycleOfOneCar + LINE_SPACE)
        }
        return resultOfOneCycle
    }

    companion object {
        const val LINE_SPACE = "\n"
    }
}
