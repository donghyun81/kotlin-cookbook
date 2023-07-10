package oop

fun main(){
    val myTask = Task("동현").apply { priority = 2 }
    val myTast1 = Task("동현",4)
    val myTast2 = Task("동현")
    println(myTask.priority) // 2
    println(myTast1.priority) // 3
    println(myTast2.priority) // 4
}
class Task(val name: String, _priority: Int = DEFAULT_PRIORITY) {

    companion object {
        // const(컴파일 타임 상수)는 객체나 동반 객체(companion object) 선언의 최상위 속성 또는 멤버여야 한다
        const val MIN_PRIORITY = 1
        const val MAX_PRIORITY = 5
        const val DEFAULT_PRIORITY = 3
    }

    var priority = validPriority(_priority) // 사용자 정의 설정(setter)
        set(value) {
            field = validPriority(value)
        }

    private fun validPriority(p: Int) =
        p.coerceIn(MIN_PRIORITY, MAX_PRIORITY) // 최소보다 작을경우 MIN_PRIORITY 반환 최대보다 클 경우 MAX_PRIORITY 반환


//    private fun validPriority(p: Int) = when {
//        p < MIN_PRIORITY -> MIN_PRIORITY
//        p > MAX_PRIORITY -> MAX_PRIORITY
//        else -> p
//    }
}