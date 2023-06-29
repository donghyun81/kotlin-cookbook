package oop

fun main(){
    println( Task("바보",-3).priority)

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

    private fun validPriority(p: Int) = // private 선언된 우선순위 검증 함수
        p.coerceIn(MIN_PRIORITY, MAX_PRIORITY) // 최소보다 작을경우 MIN_PRIORITY 반환 최대보다 클 경우 MAX_PRIORITY 반환


//    private fun validPriority(p: Int) = when {
//        p < MIN_PRIORITY -> MIN_PRIORITY
//        p > MAX_PRIORITY -> MAX_PRIORITY
//        else -> p
//    }
}