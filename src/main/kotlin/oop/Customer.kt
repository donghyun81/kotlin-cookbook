package oop

class Customer(val name: String) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        val otherCustomer = (other as? Customer) ?: return false
        return this.name == otherCustomer.name
    }

    override fun hashCode() = name.hashCode()

    // Version 1:
//    private var _messages: List<String>? = null // 널 허용 private 속성 초기화
//
//    val messages: List<String> // 클라이언트가 불러올 속성(NonNull타입)
//        get() {
//            if (_messages == null) {
//                _messages = loadMessages() // null일 경우 호출될 함수 호출
//            }
//            return _messages!!
//        }

    // Version 2:
    val messages: List<String> by lazy { loadMessages() }

    private fun loadMessages(): MutableList<String> = // 메세지를 반환하는 private 함수
        mutableListOf(
            "Initial contact",
            "Convinced them to use Kotlin",
            "Sold training class. Sweet."
        ).also { println("Loaded messages") }



}