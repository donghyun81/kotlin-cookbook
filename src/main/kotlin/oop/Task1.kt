package oop

class Task1(val name: String) {
    var priority = 3 // 사용자 정의 설정자
        set(value) {
            field = value.coerceIn(1..5)
        }

    val lowPriority // 사용자 정의 획득자
        get() = priority < 3
}