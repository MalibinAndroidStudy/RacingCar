package stringcaclulator

import java.lang.IllegalArgumentException
import kotlin.math.round

enum class Operator(
    private val operator: String,
) {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/");

    fun hasSymbol(otherSymbol: String) =
        this.operator == otherSymbol

    companion object {
        fun findOperator(symbol: String): Operator {
            return values().find { it.hasSymbol(symbol) }
                ?: throw IllegalArgumentException("잘못된 연산자 입니다. 잘못된 연산자: $symbol")
        }
    }
}

class Calculator {
    private var acc = 0.0

    fun calculate(input: String): Double {
        val mathExpression = input.split(" ")
        Checker.checkMathExpressionSize(mathExpression)
        return calculateProgressively(mathExpression)
    }

    private fun calculateProgressively(splitList: List<String>): Double {
        Checker.checkNumber(splitList[0])
        acc = splitList[0].toDouble()

        for (i in 1 until splitList.size step 2) {
            val symbol = splitList[i]
            val number = splitList[i + 1]
            checkValidity(number, symbol)
            acc = accumulateCalculation(
                symbol,
                number.toDouble()
            )
        }
        return acc
    }

    private fun checkValidity(number: String, operator: String) {
        Checker.checkNumber(number)
        Checker.checkOperator(operator)
    }

    private fun accumulateCalculation(symbol: String, number: Double): Double {
        val operator = Operator.findOperator(symbol)
        return when (operator) {
            Operator.PLUS -> add(acc, number)
            Operator.MINUS -> subtract(acc, number)
            Operator.MULTIPLY -> multiply(acc, number)
            Operator.DIVIDE -> divide(acc, number)
        }
    }

    private fun add(number1: Double, number2: Double): Double {
        val result = number1 + number2
        return round(result * 1000) / 1000.0
    }

    private fun subtract(number1: Double, number2: Double): Double {
        val result = number1 - number2
        return round(result * 1000) / 1000.0
    }

    private fun multiply(number1: Double, number2: Double) = number1 * number2

    private fun divide(number1: Double, number2: Double) = number1 / number2
}
