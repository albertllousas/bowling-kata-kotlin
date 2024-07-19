import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.*
import org.junit.jupiter.api.TestFactory

class BowlingTest {

    @TestFactory
    fun `given game with 0 pins down should end with 0 points`() =
        listOf(
            Pair("-", 0),
            Pair("1", 1),
            Pair("2", 2),
            Pair("3", 3),
            Pair("4", 4),
            Pair("5", 5),
            Pair("6", 6),
            Pair("7", 7),
            Pair("8", 8),
            Pair("9", 9),
            Pair("X", 10),
            Pair("--", 0),
            Pair("22", 4),
            Pair("22 2", 6),
            Pair("22 22", 8),
            Pair("2- 33", 8),
            Pair("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-", 90),
            Pair("2/ 33", 19),
            Pair("-/ 33", 19),
            Pair("X 33", 22),
        ).map { (game, expected) ->
            dynamicTest("$game $expected") {
                Bowling.score(game) shouldBe expected
            }
        }

}