package calculator

class Calculator {
    companion object {
        private val ArithmeticOperations = listOf<String>("+", "-", "*", "/")

        fun add(a: Int, b: Int): Int = a + b
        fun subtract(a: Int, b: Int): Int = a - b
        fun multiply(a: Int, b: Int): Int = a * b
        fun divide(a: Int, b: Int): Int {
            require(b != 0) { "0으로 나눌 수 없습니다." }
            return a / b
        }

        fun checkNullOrBlank(expression: String?) {
            require(!expression.isNullOrBlank()) { "입력 값이 null 이거나 공백 문자열 입니다." }
        }

        fun checkArithmeticOperations(operator: String) {
            require(ArithmeticOperations.contains(operator)) { "${operator}는 사칙연산 기호가 아닙니다." }
        }

        fun calculate(operator: String, operand1: Int, operand2: Int): Int {
            checkArithmeticOperations(operator)
            return when (operator) {
                "+" -> add(operand1, operand2)
                "-" -> subtract(operand1, operand2)
                "*" -> multiply(operand1, operand2)
                "/" -> divide(operand1, operand2)
                else -> -1
            }
        }

        fun calculateString(expression: String?): Int {
            checkNullOrBlank(expression)
            val splitExpression = expression!!.split(" ")
            var result = splitExpression[0].toInt()
            for (i in splitExpression.indices) {
                if (i % 2 == 0) continue
                val operator = splitExpression[i]
                val operand1 = result
                val operand2 = splitExpression[i + 1].toInt()
                result = calculate(operator, operand1, operand2)
            }
            return result
        }
    }
}
