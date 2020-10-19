import java.lang.IllegalArgumentException

fun main() {
    val i = readLine()!!.toInt()
    // if (i !in 1..10) {
    //     throw IllegalArgumentException("인풋값은 1부터 10 사이입니다")
    // }

    //require(i !in 1..10) { "인풋값은 1부터 10 사이입니다" }

    /*RunTimeException보다 IllegalArgumentException(에러에도 용도를 명시)*/

    check(i in 1..10) { "인풋값은 1부터 10 사이입니다" }
}
