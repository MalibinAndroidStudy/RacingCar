package firstweekstringcalculator

fun main() {
    val readCalculateString = inputCalculateString()
    val calculationList = InputCalculationString().toCalculationList(readCalculateString)

    println(StringCalculation().calculate(calculationList))
}
