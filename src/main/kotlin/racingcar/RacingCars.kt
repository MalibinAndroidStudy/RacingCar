package racingcar

class RacingCars(
    private var carList: MutableList<RacingCar> = mutableListOf()
) {
    fun prepareCar(numOfCar: Int) {
        val carList = mutableListOf<RacingCar>()
        for (i in 0 until numOfCar) {
            val racingCar = RacingCar()
            carList.add(racingCar)
        }
        this.carList = carList
    }

    fun getCurrentCarList(): MutableList<RacingCar> {
        return carList
    }
}