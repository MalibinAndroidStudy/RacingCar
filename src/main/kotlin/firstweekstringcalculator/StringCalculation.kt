package firstweekstringcalculator

import java.lang.IllegalArgumentException

class StringCalculation {

    fun calculate(calculateList: List<String>): Double {
        validateMathematicalExpression(calculateList)
        var accumulator = StringToDoubleOperand().toDoubleTwoDecimalPlace(calculateList[0])
        for (i in 1 until calculateList.size step 2) {
            val operator: Operator = Operator.findByOperatorSymbol(calculateList[i])
            val operand: Double = StringToDoubleOperand().toDoubleTwoDecimalPlace(calculateList[i + 1])
            accumulator = operator.calculate(accumulator, operand)
        }
        return accumulator
    }

    private fun validateMathematicalExpression(calculateList: List<String>) {
        require(calculateList.size >= 3) {
            throw IllegalArgumentException("입력받은 값은 수식이 아닙니다!")
        }
    }
}
