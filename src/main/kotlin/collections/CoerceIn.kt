package collections

fun main() {
    val range = 3..8
    println(5.coerceIn(range)) // 5는 3~8사이라 5 반환
    println(1.coerceIn(range)) // 1는 3~8사이가 아니라 최소값 3 반환
    println(9.coerceIn(range)) // 9는 3~8사이가 아니라 최대값 8 반환

    println(5.coerceIn(2, 6)) //5는 2~6사이라 5 반환
    println(1.coerceIn(2, 6)) //1은 2~6사이가 아니라 최소값 2 반환
    println(9.coerceIn(2, 6)) //9는 2~6사이가 아니라 최대값 6 반환
}