package racingcar

class RacingCar(
    private var carStepList: MutableList<String> = mutableListOf()
) {
    fun tryGoForward() {
        val carStepList = mutableListOf<String>()
        if (GoOrNot().judgeCanGo()) {
            carStepList.add("-")
        }
        this.carStepList = carStepList
    }

    fun getCarStepList(): MutableList<String> {
        return carStepList.toMutableList()
    }
}
