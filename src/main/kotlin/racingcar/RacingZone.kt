package racingcar

class RacingZone {
    companion object {
        const val LINE_SPACE = "\n"
    }

    fun startRaceAndGetResult(carList: MutableList<RacingCar>, numOfTry: Int): String {
        var resultOfRace = ""
        for (i in 0 until numOfTry) {
            resultOfRace += (runOneCycle(carList)) + (LINE_SPACE)
            print("전체 차가 한 번의 레이스를 시도한 결과: $resultOfRace")
        }
        print("전체 레이스 끝났을 때: $resultOfRace")
        return resultOfRace
    }

    private fun runOneCycle(carList: MutableList<RacingCar>): String {
        var resultOfOneCycle = ""
        for (racingCar in carList) {
            racingCar.tryGoForward()
            val currentCarStepList = racingCar.getCarStepList()
            val currentCarStepString = currentCarStepList.joinToString(separator = "")
            resultOfOneCycle += currentCarStepString + LINE_SPACE
            print("한 번씩 돌때 차량 한대: $resultOfOneCycle")
        }
        print("한 번씩 돌때 전체: $resultOfOneCycle")
        return resultOfOneCycle
    }
}
