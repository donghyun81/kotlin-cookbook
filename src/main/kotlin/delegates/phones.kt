package delegates

interface Dialable {
    fun dial(number: String): String
}

class Phone : Dialable {
    override fun dial(number: String) = "Dialing $number..."
}

interface Snappable {
    val a: Int

    fun takePicture(): String
}

class Camera : Snappable {
    override val a = 0
    val b = 0
    override fun takePicture() = "Taking picture..."
}

class SmartPhone(
    private val phone: Dialable = Phone(),  // Dialable을 구현한 Phone()객체를 기본 인자값으로 할당
    private val camera: Snappable = Camera() // Snappable을 구현한 Camera() 객체를 기본 인자값으로 할당
) : Dialable by phone, Snappable by camera // by 키워드를 통해서 인자값의 객체의 함수들에 접근하여 자동으로 구현해준다.

fun main() {
    val myPhone = SmartPhone()
    println(myPhone.a)
    //println(myPhone.b) Snappable 타입 객체인 camera는 Camera()에만 존재하는 b변수,다른 각종 함수에 접근할 수 없다.
    println(myPhone.dial("555-1234"))
    println(myPhone.takePicture())
}

