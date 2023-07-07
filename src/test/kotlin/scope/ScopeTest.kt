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

    @Test
    fun `also 테스트`(){
        val tom = Person("Tom",23)
        assertEquals(tom.also { assertEquals(tom.age,23) }
                .also { twoYearsLater(tom) }
                .also { assertEquals(tom.age,25)  }
                .also { it.age +=2
                    assertEquals(tom.age,27) }
                .age,27
        )
    }

}
