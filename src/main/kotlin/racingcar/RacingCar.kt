package racingcar

class RacingCar(
    private var carStepList: MutableList<String> = mutableListOf()
) {
    private val oneStepGoOrNot = OneStepGoOrNot()
    fun tryGoForward() {
        if (oneStepGoOrNot.judgeCanGo()) {
            carStepList.add("-")
        }
    }

    fun getCarStepList(): MutableList<String> {
        return carStepList.toMutableList()
    }
}
