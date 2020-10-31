package racingcar

class RacingZone {
    companion object {
        const val LINE_SPACE = "\n"
    }

    fun startRaceAndGetResult(carList: MutableList<RacingCar>, numOfTry: Int): String {
        var resultOfRace = ""
        for (i in 0 until numOfTry) {
            resultOfRace += (runOneCycle(carList)) + (LINE_SPACE)
        }
        return resultOfRace
    }

    private fun runOneCycle(carList: MutableList<RacingCar>): String {
        var resultOfOneCycle = ""
        for (racingCar in carList) {
            racingCar.tryGoForward()
            val currentCarStepList = racingCar.getCarStepList()
            val currentCarStepString = currentCarStepList.joinToString(separator = "")
            resultOfOneCycle += currentCarStepString + LINE_SPACE
        }
        return resultOfOneCycle
    }
}
