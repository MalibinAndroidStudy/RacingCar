package racingcar.view

import racingcar.ChangeAndCheckNum

class InputView {
    private val changeAndCheckNum = ChangeAndCheckNum()
    fun getNumOfCar(): Int {
        print("자동차 대수는 몇 대인가요?")
        return changeAndCheckNum.stringToNum(readLine())
    }

    fun getNumOfTry(): Int {
        print("시도할 횟수는 몇 회인가요?")
        return changeAndCheckNum.stringToNum(readLine())
    }
}
