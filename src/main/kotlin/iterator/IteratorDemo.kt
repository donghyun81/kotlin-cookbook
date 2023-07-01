package iterator

data class Player(val name: String)

class Team(val name: String,
           val players: MutableList<Player> = mutableListOf()) : Iterable<Player>  {
    override fun iterator(): Iterator<Player> = players.iterator() // Iterable 인터페이스 상속 받아서 구현
    fun addPlayers(vararg people: Player) = players.addAll(people)
    fun removePlayer(player: Player) {
        if (players.contains(player)) {
            players.remove(player)
        }
    }
}

//operator fun Team.iterator() : Iterator<Player> = players.iterator()

fun main() {
    val team = Team("Warriors")
    team.addPlayers(
        Player("Curry"),
        Player("Thompson"),
        Player("Durant"),
        Player("Green"),
        Player("Cousins"),
    )

    // for 구문해서 for(i in collection) 일경우 collection의 iterator를 호출하고 for문이 실행될때마다 next로 넘어가고 hasNext가 false일 경우에 종료된다
    for (player in team ) {

        // Team 객체에 iterator = players.iterator()이여서 player는 players의 내부 값으로 호출된다
        println(player)
    }

    println(team.any { it.name == "Curry" })
    println(team.map { it.name }.sorted().joinToString())
}