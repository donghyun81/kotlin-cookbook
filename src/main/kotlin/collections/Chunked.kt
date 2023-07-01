package collections


fun main() {
    val list = 0..10
    val pieces = list.chunked(3)
    println(pieces)

    val sums = list.chunked(3) { it.sum() } //인자값 만큼 나누기(마지막이 인자값만큼 없으면 해당 부분만 반환)
    println("Sums: $sums")

    println(list.windowed(3, 1,false)) // size 만큼 나누지만 step 만큼 이동하면서 나누기 1,2,3,4 (3,1)일 경우 [1,2,3] [2,3,4]
    //(마지막이 인자값만큼 없으면 버린다)
    println("Averages: " + list.windowed(3, 1) { it.average() })

    println(list.windowed(3, 3,true)) // size 만큼 나누지만 step 만큼 이동하면서 나누기 1,2,3,4 (3,3)일 경우 [1,2,3]
    ////(마지막이 인자값만큼 없으면 해당 부분만 반환)
    println("Averages: " + list.windowed(3, 3) { it.average() })
}
