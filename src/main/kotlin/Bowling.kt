class Bowling {

    companion object {

        private const val FRAME_SEPARATOR = " "
        private const val STRIKE_CHAR = 'X'
        private const val SPARE_CHAR = '/'
        private const val MISS_CHAR = '-'

        fun score(game: String): Int {
            var total = 0
            val frames = game.split(FRAME_SEPARATOR)
            frames.forEachIndexed { i, frame ->
                val (nextRoll, rollAfterNext) = getNextPinsDown(frames, i)
                total += scoreSingleFrame(frame, nextRoll, rollAfterNext)
            }
            return total
        }

        private fun getNextPinsDown(frames: List<String>, i: Int): Pair<Int, Int> {
            if (i + 1 >= frames.size) return Pair(0, 0)
            val nextRoll = getPinsDown(frames[i + 1][0])
            val rollAfterNext = getPinsDown(frames[i + 1][1])
            return Pair(nextRoll, rollAfterNext)
        }

        private fun scoreSingleFrame(frame: String, nextBall: Int, ballAfterNext: Int) =
            when {
                frame.length == 2 && frame[1] == SPARE_CHAR -> getPinsDown(frame[1]) + nextBall
                frame[0] == STRIKE_CHAR -> getPinsDown(frame[0]) + nextBall + ballAfterNext
                else -> getPinsDown(frame[0]) + getPinsDown(frame.getOrElse(1) { MISS_CHAR })
            }

        private fun getPinsDown(roll: Char) = when (roll) {
            STRIKE_CHAR -> 10
            SPARE_CHAR -> 10
            MISS_CHAR -> 0
            else -> roll.digitToInt()
        }
    }
}
