package stringcaclulator

import java.lang.IllegalArgumentException
import kotlin.math.round

class Calculator {
    private val checker = Checker()
    private var result = 0.0

    fun calculate(input: String): Double {
        val mathExpression = input.split(" ")
        checker.checkMathExpressionSize(mathExpression)
        return calculateProgressively(mathExpression)
    }

    fun calculateProgressively(splitList: List<String>): Double {
        checker.checkNumber(splitList[0])
        result = splitList[0].toDouble()

        for (i in 1 until splitList.size step 2) {
            val operator = splitList[i]
            val number = splitList[i + 1]
            checker.checkNumber(number)
            checker.checkOperator(operator)
            result = calculateByOperator(
                operator,
                number
            )
        }
        return result
    }

    private fun calculateByOperator(operator: String, number: String): Double {
        return when (operator) {
            "+" -> add(result, number.toDouble())
            "-" -> subtract(result, number.toDouble())
            "*" -> multiply(result, number.toDouble())
            "/" -> divide(result, number.toDouble())
            else -> throw IllegalArgumentException("연산자 위치에 잘못된 값이 들어있습니다. 잘못된 연산자: $operator")
        }
    }

    fun add(number1: Double, number2: Double) = number1 + number2

    fun subtract(number1: Double, number2: Double): Double {
        val result = number1 - number2
        return round(result * 1000) / 1000.0
    }

    fun divide(number1: Double, number2: Double) = number1 / number2

    fun multiply(number1: Double, number2: Double) = number1 * number2
}
