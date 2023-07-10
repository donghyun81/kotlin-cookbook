package collections

import java.time.LocalDate

class LocalDateProgression(
    override val start: LocalDate,
    override val endInclusive: LocalDate,
    val step: Long = 1
) : Iterable<LocalDate>, ClosedRange<LocalDate> {

    override fun iterator(): Iterator<LocalDate> = LocalDateProgressionIterator(start, endInclusive, step) // start,end까지 정렬 순서에 따라 step만킁 이동하면서 호출

    infix fun step(days: Long) = LocalDateProgression(start, endInclusive, days) // step 2 -> step(2) 2칸씩 이동
}

internal class LocalDateProgressionIterator(
    start: LocalDate,
    val endInclusive: LocalDate,
    val step: Long
) : Iterator<LocalDate> {

    private var current = start

    override fun hasNext() = current <= endInclusive // 마지막 날짜보다 작을경우 true

    override fun next(): LocalDate {
        val next = current
        current = current.plusDays(step) // current+1day
        return next //현 일자
    }
}

operator fun LocalDate.rangeTo(other: LocalDate) = LocalDateProgression(this, other) // ..연산자와 같은 rangeTo를 사용자 정의
