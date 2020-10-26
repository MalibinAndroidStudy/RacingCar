package calculator.view

class InputView() {
    fun inputString(): String {
        println("계산할 식을 입력해주세요")
        return readLine() ?: throw IllegalArgumentException("공백은 입력할 수 없습니다.")
    }
}
