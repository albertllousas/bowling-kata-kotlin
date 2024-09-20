package second

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DynamicTest.dynamicTest
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
            Pair("X 1/ 11", 33),
            Pair("X X 11", 35),
            Pair("9- 9- 9- 9- 9- 9- 9- 9- 9- 9-", 90),
            Pair("5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 1/5", 146),
            Pair("X X X X X X X X X X X X", 300),
        ).map { (game, expected) ->
            dynamicTest("When game is '$game' the score should be '$expected'") {
                Bowling.score(game) shouldBe expected
            }
        }
}