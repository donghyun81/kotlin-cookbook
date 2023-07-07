package scope

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ScopeTest {
    @Test
    fun `apply 테스트`(){
        val tom = Person("Tom",21)
        assertEquals(tom.age,21)
        twoYearsLater(tom)
        assertEquals(tom.age,23)
    }
}
