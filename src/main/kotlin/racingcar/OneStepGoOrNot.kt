package racingcar

import kotlin.random.Random

class OneStepGoOrNot {

    fun judgeCanGo(): Boolean {
        return createRandomNum() >= MIN_NUM_OF_GO
    }

    fun createRandomNum(): Int {
        return Random.nextInt(BOUND)
    }

    companion object {
        const val BOUND = 10
        const val MIN_NUM_OF_GO = 4
    }
}
