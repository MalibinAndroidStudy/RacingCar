class Person(
    var name: String,
    val age: Int
) {
    fun changeName(newName: String) {
        this.name = newName
    }

    fun sumList(list: List<Int>): Int {
        return list.sum()
    }

    companion object {
        const val PLUS = "+"
        const val BLANK = " "
        // 유지보수를 위해서 같은 상수를 이름만 다르게 해서 사용하는 경우도 많음
    }
}
