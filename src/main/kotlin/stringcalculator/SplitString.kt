package stringcalculator

import java.lang.IllegalArgumentException

class SplitString {
    companion object {
        const val delimiter = " "
    }

    fun splitString(string: String): List<String> {
        val splitList = string.split(delimiter)
        checkSize(splitList)
        return splitList
    }

    private fun checkSize(splitList: List<String>) {
        require(splitList.size > 2) { throw IllegalArgumentException("계산 식이 아닙니다.\n입력 받은 값 : $splitList") }
    }
}