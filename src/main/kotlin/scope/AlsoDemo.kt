package scope

fun main(){
    val tom = Person("Tom",23)

    print(
        tom.also { println(it.age) }
            .also { twoYearsLater(tom) }
            .also { println(it.age) }
            .also { it.age +=2
                println(it.age)
            }.age
    )
}