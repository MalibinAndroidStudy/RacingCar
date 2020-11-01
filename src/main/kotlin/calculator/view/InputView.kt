package calculator.view

fun getExpression(): String {
    println("사칙연산 계산식을 입력해주세요.")
    return readLine() ?: throw IllegalArgumentException("계산식은 공백일 수 없습니다.")
}
