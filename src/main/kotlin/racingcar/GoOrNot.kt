package racingcar

import java.util.concurrent.ThreadLocalRandom

class GoOrNot {
    companion object {
        const val BOUND = 10
        const val MIN_NUM_OF_GO = 4
    }

    fun judgeCanGo(): Boolean {
        if (createRandomNum() < MIN_NUM_OF_GO) {
            return false
        }
        return true
    }

    fun createRandomNum(): Int {
        return ThreadLocalRandom.current().nextInt(BOUND)
    }
}
