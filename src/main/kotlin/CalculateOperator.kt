fun main() {
    println("계산할 식을 입력하세요")
    val stringCalculator = StringCalculator()
    val inspectInput = InspectInput()
    val input = readLine()
    val splitInput = inspectInput.splitEquation(input!!)
    inspectInput.checkBlank(input)
    inspectInput.checkOperator(splitInput)
    println("계산 결과는 ${stringCalculator.calculate(splitInput)} 입니다.")
}
