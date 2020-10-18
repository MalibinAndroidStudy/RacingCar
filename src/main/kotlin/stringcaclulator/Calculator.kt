package stringcaclulator

import java.lang.IllegalArgumentException
import kotlin.math.round

class Calculator {
    fun calculate(input: String): Double {
        val inputList = splitInput(input)
        return calculateWithSplitList(inputList)
    }

    fun splitInput(input: String): List<String> {
        return input
            .split(" ")
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
        val result = "[0-9]+|[0-9]+[.][0-9]+".toRegex()
            .matches(number)
        if (!result) {
            throw IllegalArgumentException("숫자 위치에 잘못된 값이 들어있습니다. 잘못된 숫자: $number")
        }
        return result
    }

    fun checkOperator(operator: String): Boolean {
        val result = "[+]|[-]|[*]|[/]".toRegex()
            .matches(operator)
        if (!result) {
            throw IllegalArgumentException("연산자 위치에 잘못된 값이 들어있습니다. 잘못된 연산자: $operator")
        }
        return result
    }

    fun <T : Number> add(number1: T, number2: T) =
        number1.toDouble() + number2.toDouble()

    fun <T : Number> subtract(number1: T, number2: T): T {
        val result = number1.toDouble()
            .minus(number2.toDouble())
        val roundResult = round(result * 1000) / 1000.0
        return roundResult as T
    }

    fun <T : Number> divide(number1: T, number2: T) = number1.toDouble() / number2.toDouble()

    fun <T : Number> multiply(number1: T, number2: T) = number1.toDouble() * number2.toDouble()
}
