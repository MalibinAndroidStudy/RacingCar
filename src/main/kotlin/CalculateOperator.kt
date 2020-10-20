fun main() {
    val stringCalculator = StringCalculator()

    println("계산할 식을 입력하세요")
    val input = readLine()
    BadCalculateStringCheck.checkBlank(input!!)
    stringCalculator.splitEquation(input)
}
