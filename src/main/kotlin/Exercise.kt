class MyString {
    var string = ""
    infix fun add(other: String) {
        this.string = this.string + other
    }
    companion object {
        const val A = "A"
    }
}

fun main(){
    val myString = MyString()
    myString
    System.out.println(myString.string)
}

