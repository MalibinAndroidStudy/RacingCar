package stringcaclulator

import java.lang.IllegalArgumentException

enum class Operator(
    private val operator: String,
    private val operateStrategy: (Double, Double) -> Double
) {
    PLUS("+", { leftValue, rightValue -> leftValue + rightValue }),
    MINUS("-", { leftValue, rightValue -> leftValue - rightValue }),
    MULTIPLY("*", { leftValue, rightValue -> leftValue * rightValue }),
    DIVIDE("/", { leftValue, rightValue -> leftValue / rightValue });

    fun hasSymbol(otherSymbol: String) =
        this.operator == otherSymbol

    fun operate(leftNumber: Double, rightNumber: Double): Double {
        return this.operateStrategy(leftNumber, rightNumber)
    }

    companion object {
        fun findOperator(symbol: String): Operator {
            return values().find { it.hasSymbol(symbol) }
                ?: throw IllegalArgumentException("잘못된 연산자 입니다. 잘못된 연산자: $symbol")
        }
    }
}

class Calculator {
    fun calculate(mathExpression: List<String>): Double {
        Checker.checkMathExpressionSize(mathExpression)
        Checker.checkNumber(mathExpression[0])
        var acc = mathExpression[0].toDouble()

        for (i in 1 until mathExpression.size step 2) {
            val symbol = mathExpression[i]
            val number = mathExpression[i + 1]
            checkValidity(number, symbol)
            acc = accumulateCalculation(
                symbol,
                acc,
                number.toDouble()
            )
        }
        return acc
    }

    private fun checkValidity(number: String, operator: String) {
        Checker.checkNumber(number)
        Checker.checkOperator(operator)
    }

    private fun accumulateCalculation(symbol: String, acc: Double, number: Double): Double {
        val operator = Operator.findOperator(symbol)
        return operator.operate(acc, number)
    }
}
