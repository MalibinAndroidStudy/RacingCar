package calculator

fun main() {
    print("수식을 입력하세요: ")
    val expression = readLine()
    val result = Calculator.calculateString(expression)
    print("계산결과: $result")
}
