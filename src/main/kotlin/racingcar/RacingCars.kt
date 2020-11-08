package racingcar

class RacingCars(
    numOfCar: Int
) {
    private var carList: MutableList<RacingCar> = mutableListOf()
    init {
        repeat(numOfCar){
            val racingCar = RacingCar()
            carList.add(racingCar)
        }
    }

    fun getCurrentCarList(): MutableList<RacingCar> {
        return carList.toMutableList()
    }
}