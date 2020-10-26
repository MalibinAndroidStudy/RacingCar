package calculator

import calculator.view.InputView
import calculator.view.OutputView

fun main() {
    val inputView = InputView()
    val input = inputView.inputString()
    val splitInput = OperatorChecker.splitEquation(input)
    OperatorChecker.checkOperator(splitInput)

    val outputView = OutputView(splitInput)
    outputView.outputString()
}
