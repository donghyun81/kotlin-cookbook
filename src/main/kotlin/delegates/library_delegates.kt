package delegates

import kotlin.properties.Delegates

val ultimateAnswer: Int by lazy {
    println("computing the answer")
    42
}

var watched: Int by Delegates.observable(1) { prop, old, new ->
    println("${prop.name} changed from $old to $new")
}

var checked: Int by Delegates.vetoable(0) { prop, old, new ->
    println("Trying to change ${prop.name} from $old to $new")
    new >= 0
}
// Delegates.notNull()을 위임 받으면 ReadWriteProperty타입의 private 구현 객체 NotNullVar에서 override된 getValue,setValue가 실행된다
var shouldNotBeNull: String by Delegates.notNull()


fun main() {
    println(ultimateAnswer)
    println(ultimateAnswer)

    watched *= 2
    watched *= 2

    checked = 42
    println(checked)
    checked = -1
    println(checked)
    checked = 17
    println(checked)
}