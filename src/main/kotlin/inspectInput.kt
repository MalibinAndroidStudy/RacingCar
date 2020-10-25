// Todo : enum class 이렇게 사용하는게 맞는지 확인 후 수정
enum class Operator(
    val operator: String,
    val calculateMethod: (leftOperand: Int, rightOperand: Int) -> Int
) {
    PLUS("+", { leftOperand, rightOperand -> leftOperand + rightOperand }),
    MINUS("-", { leftOperand, rightOperand -> leftOperand - rightOperand }),
    MULTIPLY("*", { leftOperand, rightOperand -> leftOperand * rightOperand }),
    DIVIDE("/", { leftOperand, rightOperand -> leftOperand / rightOperand });

    fun checkSymbol(inputSymbol: String): Boolean {
        return this.operator == inputSymbol
    }

    companion object {
        fun findBySymbol(operator: String): Operator {
            return values().find { it.checkSymbol(operator) }
                ?: throw IllegalArgumentException("$operator 는 사칙연산자가 아닙니다.")
        }
    }
}

class InspectInput {

    fun checkBlank(input: String) {
        require(input.isNotBlank()) {
            "공백은 입력할 수 없습니다."
        }
    }

    fun splitEquation(input: String): List<String> {
        val splitString: List<String> = input.split(" ")
        checkOperator(splitString)

        return splitString
    }

    fun checkOperator(splitString: List<String>) {
        val operator = listOf("+", "-", "*", "/")
        for (i in 1 until splitString.indices.count() step 2) {
            require(splitString[i] in operator) {
                "연산자가 잘못되었습니다."
            }
        }
    }
}
