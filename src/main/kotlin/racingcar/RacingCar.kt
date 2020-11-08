package racingcar

class RacingCar(
    private val carStepList: MutableList<String> = mutableListOf()
) {
    private val oneStepGoOrNot = OneStepGoOrNot()
    fun tryGoForward() {
        if (oneStepGoOrNot.judgeCanGo()) {
            carStepList.add("-")
        }
    }

    fun getCarStepList(): List<String> {
        return carStepList.toList()
    }
}
