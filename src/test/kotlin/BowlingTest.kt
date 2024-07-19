import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory

class BowlingTest {

    @TestFactory
    fun `given game with 0 pins down should end with 0 points`() =
        listOf(
            Pair("0", 0),
            Pair("1", 1),
            Pair("2", 2),
        ).map { (game, expected) ->
            DynamicTest.dynamicTest("$game $expected") {
                Bowling.score(game) shouldBe expected
            }
        }

}