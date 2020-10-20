package stringcaclulator

import java.lang.IllegalArgumentException
import kotlin.math.round

class Calculator {
    fun calculate(input: String): Double {
        val inputList = input.split(" ")
        return calculateWithSplitList(inputList)
    }

    fun calculateWithSplitList(splitList: List<String>): Double {
        checkNumber(splitList[0])
        var result = splitList[0].toDouble()

        for (i in 1 until splitList.size step 2) {
            val operator = splitList[i]
            val number = splitList[i + 1]
            result = checkThenCalculate(
                operator,
                result,
                number
            )
        }
        return result
    }

    fun checkThenCalculate(operator: String, result: Double, number: String): Double {
        checkNumber(number)
        checkOperator(operator)
        return when (operator) {
            "+" -> add(result, number.toDouble())
            "-" -> subtract(result, number.toDouble())
            "*" -> multiply(result, number.toDouble())
            "/" -> divide(result, number.toDouble())
            else -> throw IllegalArgumentException("연산자 위치에 잘못된 값이 들어있습니다. 잘못된 연산자: $operator")
        }
    }

    fun checkNumber(number: String): Boolean {
        val result = NUMBER_REGEX.matches(number)
        if (!result) {
            throw IllegalArgumentException("숫자 위치에 잘못된 값이 들어있습니다. 잘못된 숫자: $number")
        }
        return result
    }

    fun checkOperator(operator: String): Boolean {
        val result = OPERATOR_REGEX.matches(operator)
        if (!result) {
            throw IllegalArgumentException("연산자 위치에 잘못된 값이 들어있습니다. 잘못된 연산자: $operator")
        }
        return result
    }

    fun add(number1: Double, number2: Double) = number1 + number2

    fun subtract(number1: Double, number2: Double): Double {
        val result = number1 - number2
        return round(result * 1000) / 1000.0
    }

    fun divide(number1: Double, number2: Double) = number1 / number2

    fun multiply(number1: Double, number2: Double) = number1 * number2

    companion object {
        private val NUMBER_REGEX = "[0-9]+|[0-9]+[.][0-9]+".toRegex()
        private val OPERATOR_REGEX = "[+]|[-]|[*]|[/]".toRegex()
    }
}
