package collections

import java.util.*

// From tweet on @Kotlin feed
// Also, https://kotlinlang.org/docs/reference/whatsnew13.html#associatewith

@Suppress("ReplaceAssociateFunction")
fun <T> repeatAndCapitalizeUsingAssociate(keys: Iterable<T>) =
    keys.associate { it to it.toString().repeat(5) // 각 key와 value를 Pair(key,value) 형식으로 반환해서 map을 만든다
        .replaceFirstChar { letter ->
            if (letter.isLowerCase()) letter.titlecase(Locale.getDefault()) else it.toString()
        }
    }

fun <T> repeatAndCapitalizeUsingAssociateWith(keys: Iterable<T>) =
        keys.associateWith { it.toString().repeat(5) // 각 key에 value만 반환해서 담아서 map을 만든다
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() } }

fun main() {
    val keys = 'a'..'f'
    val map = repeatAndCapitalizeUsingAssociate(keys)
    println(map)

    val map1 = repeatAndCapitalizeUsingAssociateWith(keys)
    println(map1)
}
