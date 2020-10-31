package racingcar

import java.lang.IllegalArgumentException

class ChangeAndCheckNum {
    fun stringToNum(numString: String?): Int {
        val num = numString?.let {
            it.toIntOrNull() ?: throw IllegalArgumentException("숫자가 입력되어야 합니다. 입력값: $it")
        } ?: throw IllegalArgumentException("입력값은 null일 수 없습니다.")
        require(num > 0) { throw IllegalArgumentException("숫자가 잘못 입력되었습니다.\n 입력값: $num") }
        return num
    }
}
