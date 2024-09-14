import java.awt.Frame

class Bowling {

    companion object {

        private val FRAME_SEPARATOR = " "
        private val STRIKE_CHAR = 'X'
        private val SPARE_CHAR = '/'
        private val MISS_CHAR = '-'

        fun score(game: String): Int {
            var total = 0
            val frames = game.split(FRAME_SEPARATOR)
            frames.forEachIndexed { i, frame ->
                val nextRoll = if (i + 1 < frames.size) getPinsDown(frames[i + 1][0]) else 0
                val rollAfterNext = if (i + 1 < frames.size) getPinsDown(frames[i + 1][1]) else 0
                total += scoreSingleFrame(frame, nextRoll, rollAfterNext)
            }
            return total
        }

        private fun scoreSingleFrame(frame: String, nextBall: Int, ballAfterNext: Int) =
            when {
                frame.length == 2 && frame[1] == SPARE_CHAR -> getPinsDown(frame[1]) + nextBall
                frame[0] == STRIKE_CHAR -> getPinsDown(frame[0]) + nextBall + ballAfterNext
                else -> getPinsDown(frame[0]) + getPinsDown(frame.getOrElse(1) { MISS_CHAR })
            }

        private fun getPinsDown(roll:Char) = when(roll) {
            STRIKE_CHAR -> 10
            SPARE_CHAR -> 10
            MISS_CHAR -> 0
            else -> roll.digitToInt()
        }
    }
}
