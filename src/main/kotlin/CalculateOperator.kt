fun main() {
    println("계산할 식을 입력하세요")
    val stringCalculator = StringCalculator()
    val input = readLine()
    val splitInput = InspectInput.splitEquation(input!!)
    InspectInput.checkBlank(input!!)
    InspectInput.checkOperator(splitInput)
    println("계산 결과는 ${stringCalculator.calculate(splitInput)} 입니다.")
}
