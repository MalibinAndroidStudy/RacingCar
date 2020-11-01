@file:JvmName("CalculatorKt")

package calculator

import calculator.view.getExpression
import calculator.view.printCalculationResult

fun main() {
    val expression = getExpression()
    val result = Calculator.calculateExpression(expression)
    printCalculationResult(result)
}
