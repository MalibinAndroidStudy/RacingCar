import java.lang.IllegalArgumentException

fun main() {

    val num: Int = readLine()!!.toInt()

    if (num !in 1..10) {
        throw IllegalArgumentException("test")
    }

    require(num !in 1..10) { "test" } // IllegalArgumentException 이 뜬다.

    // runtime exception은 사용하지 말자!. 최상위 이기 때문에 더 구체적인 exception을 사용하는 것이 좋다.

    check(num !in 1..10) { "test" } // status 상태가 말이 안된때만

    // null이 논리적으로 말이 안될때는 무조건 예외처리
}
