import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BowlingTest{

    @Test
    fun `given game with 0 pins down should end with 0 points`(){
        Bowling.score("0") shouldBe 0
    }

    @Test
    fun `given game with 1 pin down should end with 1 point`(){
        Bowling.score("1") shouldBe 1
    }
}