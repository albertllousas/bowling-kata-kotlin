import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.DynamicTest.*
import org.junit.jupiter.api.TestFactory

class BowlingTest {

    @TestFactory
    fun `should score a bowling game`() =
        listOf(
            Pair("-", 0),
        ).map { (game, expected) ->
            dynamicTest("When is'$game'the score should be '$expected'") {
                Bowling.score(game) shouldBe expected
            }
        }

}