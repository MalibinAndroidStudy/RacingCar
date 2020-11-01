package stringcaclulator

fun main() {
    val mathExpression = readLine()!!.split(" ")
    val result = Calculator().calculate(mathExpression)
    print(result)
}
