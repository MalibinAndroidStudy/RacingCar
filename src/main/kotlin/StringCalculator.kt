import CheckString.checkOperator
import java.util.Scanner

class StringCalculator {
    private var result: Int = 0
    val checkString = CheckString

    fun readEquation() {
        println("계산할 식을 입력하세요")
        val scanner = Scanner(System.`in`)
        val input = scanner.nextLine()
        splitEquation(input)
    }

    fun splitEquation(input: String) {
        checkString.checkBlank(input)
        val splitString: List<String> = input.split(" ")
        calculate(splitString)
    }

    fun calculate(splitString: List<String>): Boolean {
        val finalresultNumber = setUpCalculate(splitString)
        if (checkOperator(splitString) == false) {
            return false
        }
        println("계산한 값은 $finalresultNumber 입니다.")
        return true
    }

    fun setUpCalculate(splitString: List<String>): Int {
        val eachSplitString = splitString.indices
        result = splitString[0].toInt()

        for (i in eachSplitString) {

            when (i % 2) {
                1 -> {
                    when (splitString[i]) {
                        "+" -> {
                            result = add(result, splitString[i + 1].toInt())
                        }
                        "-" -> {
                            result = subtract(result, splitString[i + 1].toInt())
                        }
                        "*" -> {
                            result = multiply(result, splitString[i + 1].toInt())
                        }
                        "/" -> {
                            result = divide(result, splitString[i + 1].toInt())
                        }
                    }
                }
            }
        }
        return result
    }

    fun add(i: Int, j: Int): Int {
        return i + j
    }

    fun subtract(i: Int, j: Int): Int {
        return i - j
    }

    fun multiply(i: Int, j: Int): Int {
        return i * j
    }

    fun divide(i: Int, j: Int): Int {
        return i / j
    }
}
