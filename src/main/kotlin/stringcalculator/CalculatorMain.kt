package stringcalculator

fun main() {
    val inputString = readLine()!!.toString()
    val calculator = Calculator(inputString)
    println(calculator.calculate())
}
