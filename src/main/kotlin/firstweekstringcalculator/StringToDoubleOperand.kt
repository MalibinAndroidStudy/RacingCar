package firstweekstringcalculator

import java.math.BigDecimal

class StringToDoubleOperand {

    fun toDoubleTwoDecimalPlace(stringOperand: String): Double {
        validateOperand(stringOperand)
        return stringOperand.toBigDecimal().setScale(2, BigDecimal.ROUND_DOWN).toDouble()
    }

    private fun validateOperand(stringOperand: String) {
        require(stringOperand.toDoubleOrNull() is Double) {
            throw IllegalArgumentException("$stringOperand 은 피연산자로 사용될 수 없습니다.")
        }
    }
}
