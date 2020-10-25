package firstweekstringcalculator

fun main() {
    val readCalculateString: String? = readLine()

    val stringCalculation = StringCalculation().calculate(readCalculateString)

    println(stringCalculation)
}
