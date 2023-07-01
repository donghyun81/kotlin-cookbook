package collections

data class User(val name:String)
fun main(){
   filterIsInstanceEx()
    filterIsInstanceToEx()
}

fun filterIsInstanceEx(){
    val list = listOf("a",1,'c',User("알프스"))
    val allType = list.filterIsInstance<Any>()
    val stringType = list.filterIsInstance<String>()
    val intTyep  = list.filterIsInstance<Int>()
    val userType = list.filterIsInstance<User>()
    println(allType) // "a",1,'c',User("알프스")
    println(stringType) // "a"
    println(intTyep) // 1
    println(userType) // User("알프스")
}
fun filterIsInstanceToEx(){
    val list = listOf("a",1,'c',User("알프스"))
    val allType = list.filterIsInstanceTo(mutableListOf<Any>())
    val stringType = list.filterIsInstanceTo(mutableListOf<String>())
    val intTyep  = list.filterIsInstanceTo(mutableListOf<Int>())
    val userType =list.filterIsInstanceTo(mutableListOf<User>())
    println(allType) // "a",1,'c',User("알프스")
    println(stringType) // "a"
    println(intTyep) // 1
    println(userType) // User("알프스")
}