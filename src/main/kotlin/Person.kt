class Person(
    var name: String,
    val age: Int,
) {
    fun changeNameTo(newName: String) {
        this.name = newName
    }

    fun sumList(list: List<Int>): Int {
        /* return (list[0] + list[list.size - 1])*list.size / 2 */
        var sum = 0
        repeat(list.size) {
            sum += list[it]
        }
        return sum
    }
}
