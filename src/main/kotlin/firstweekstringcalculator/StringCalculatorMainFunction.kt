package firstweekstringcalculator

fun main() {
    val readCalculateString: String? = readLine()

    val stringCalculation = StringCalculation(readCalculateString)

    println(stringCalculation.calculateResult())
}
