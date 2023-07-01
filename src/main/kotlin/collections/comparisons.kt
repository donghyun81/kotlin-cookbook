package collections

data class Golfer(val score: Int,
                  val first: String,
                  val last: String)

fun main() {
    val golfers = listOf(
        Golfer(70, "Jack", "Nicklaus"),
        Golfer(68, "Tom", "Watson"),
        Golfer(68, "Bubba", "Watson"),
        Golfer(70, "Tiger", "Woods"),
        Golfer(68, "Ty", "Webb")
    )

    // Create comparator and sort using it
    val comparator = compareBy(Golfer::score) // Golfer 타입 객체 점수 별로 정렬
        .thenBy(Golfer::last)  // Golfer 타입 객체 점수가 같을 경우 last별로 정렬
        .thenBy(Golfer::first) // Golfer 타입 객체 점수가 같을 경우 last도 같을 경우 first로 정렬하는 Comparator 반환
    golfers.sortedWith(comparator) //Comparator 형식에 따라 정렬
        .forEach(::println) // 객체를 println으로 출력

    // Sort by properties
    val sorted = golfers.sortedWith(
        compareBy({ it.score }, { it.last }, { it.first }) //위 comparator 변수랑 같은 Comparator 반환
    )

    sorted.forEach { println(it) }
}
