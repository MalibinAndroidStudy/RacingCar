package calculator.view

import calculator.StringCalculator

class OutputView(val splitInput: List<String>) {
    fun outputString() {
        val stringCalculator = StringCalculator()
        println("계산 결과는 ${stringCalculator.calculate(splitInput)} 입니다.")
    }
}
