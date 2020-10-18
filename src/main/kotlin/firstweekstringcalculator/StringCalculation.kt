package firstweekstringcalculator

import java.lang.NumberFormatException

class StringCalculation(
    private val calculateString: String?
) {

    private fun validCalculateString(): List<String> {
        if (calculateString.isNullOrBlank()) {
            throw IllegalArgumentException("입력값이 Null 이거나 공백일 수 없습니다")
        }
        return calculateString.split(" ")
    }

    private fun validOperand(operand: String): Int {
        return try {
            operand.toInt()
        } catch (errorMessage: NumberFormatException) {
            throw IllegalArgumentException("$operand 은 피연산자로 사용될 수 없습니다.")
        }
    }

    private fun operation(result: Int, operand: Int, operator: String): Int {
        return when (operator) {
            "+" -> add(result, operand)
            "-" -> minus(result, operand)
            "*" -> multiplication(result, operand)
            "/" -> divide(result, operand)
            else -> throw IllegalArgumentException(
                "$operator 를 연산자로 사용하실 수 없습니다. +, -, *, / 의 연산을 사용해주세요."
            )
        }
    }

    private fun add(result: Int, operand: Int): Int {
        return result + operand
    }

    private fun minus(result: Int, operand: Int): Int {
        return result - operand
    }

    private fun multiplication(result: Int, operand: Int): Int {
        return result * operand
    }

    private fun divide(result: Int, operand: Int): Int {
        return result / operand
    }

    private fun calculate(calculateList: List<String>): Int {
        var result = validOperand(calculateList[0])
        for (i in 1 until calculateList.size step 2) {
            val operator: String = calculateList[i]
            val operand: Int = validOperand(calculateList[i + 1])
            result = operation(result, operand, operator)
        }
        return result
    }

    fun calculateResult(): Int {

        val calculateStringList: List<String> = validCalculateString()

        return calculate(calculateStringList)
    }
}
