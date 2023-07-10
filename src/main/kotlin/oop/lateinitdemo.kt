package oop

class LateInitDemo {
    lateinit var name: String

    fun initializeName() {
        println("Before assignment: ${::name.isInitialized}") // name 초기화전
        name = "World"
        println("After assignment: ${::name.isInitialized}") //name = World로 초기화된 후
    }
}

fun main() {
    LateInitDemo().initializeName()
}