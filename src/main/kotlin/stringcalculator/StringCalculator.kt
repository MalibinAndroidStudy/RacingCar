package stringcalculator

import java.lang.IllegalArgumentException
//fun main() {
//    val keyboardInputString = readLine() ?: throw IllegalArgumentException("입력값은 null일 수 없습니다.")
//    val splitList = SplitString().splitString(keyboardInputString)
//    val resultValue = StringCalculator().calculate(splitList)
//    print("계산값은 ${resultValue}입니다.")
//}
class StringCalculator {
    fun calculate(splitList: List<String>): Int {
        val firstString = splitList[0]
        var accumulateNum = changeToNum(firstString)
        for (i in 1 until splitList.size step 2) {
            val operator = splitList[i]
            val numString = splitList[i + 1]
            accumulateNum = Operator.findBySymbol(operator)
                .calculateStrategy(
                    accumulateNum,
                    changeToNum(numString)
                )
        }
        return accumulateNum
    }

    private fun changeToNum(num: String): Int {
        return num.toIntOrNull() ?: throw IllegalArgumentException("해당 문자는 숫자로 변환할 수 없습니다. \n 입력된 문자 : $num")
    }
}