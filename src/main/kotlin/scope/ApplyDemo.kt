package scope


fun main(){
    val tom = Person("Tom",21)
    println(tom.age)
    twoYearsLater(tom)
    println(tom.age)
}
fun twoYearsLater(person:Person):Person = person.apply { age +=2 }