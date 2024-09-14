import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.*
import org.junit.jupiter.api.TestFactory

class BowlingTest {

    @TestFactory
    fun `should score a bowling game`() =
        listOf(
            Pair("-", 0),
            Pair("1", 1),
            Pair("2", 2),
            Pair("11", 2),
            Pair("12 11", 5),
            Pair("1/ 11", 13),
            Pair("X 22", 18),
            Pair("X 1/ 11", 34),
        ).map { (game, expected) ->
            dynamicTest("When game is '$game' the score should be '$expected'") {
                Bowling.score(game) shouldBe expected
            }
        }
}
