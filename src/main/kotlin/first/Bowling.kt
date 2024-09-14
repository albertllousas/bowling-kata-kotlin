package first

class Bowling {

    companion object {

        private const val FRAME_SEPARATOR = " "
        private const val STRIKE_CHAR = 'X'
        private const val SPARE_CHAR = '/'
        private const val MISS_CHAR = '-'

        fun score(game: String): Int {
            val allFrames = game.split(FRAME_SEPARATOR)
            return (0..9).fold(0) { total, i ->
                val (nextRoll, rollAfterNext) = getNextTwoPinsDown(allFrames, i)
                val currentFrame = allFrames.getOrElse(i) { MISS_CHAR.toString() }
                total + when {
                    currentFrame.isSpare() -> 10 + nextRoll
                    currentFrame.isStrike() -> 10 + nextRoll + rollAfterNext
                    else -> pinsDown(currentFrame[0]) + pinsDown(currentFrame.getOrElse(1) { MISS_CHAR })
                }
            }
        }

        private fun getNextTwoPinsDown(frames: List<String>, i: Int): Pair<Int, Int> {
            val fstRollNextFrame = pinsDown(frames.charAtOrNull(i + 1, 0))
            return when {
                i + 1 == 10 && frames.getOrNull(1).isSpare() -> Pair(pinsDown(frames.charAtOrNull(i, 2)), 0)
                frames.getOrNull(i + 1).isSpare() -> Pair(fstRollNextFrame, 10 - fstRollNextFrame)
                frames.getOrNull(i + 1).isStrike() -> Pair(10, pinsDown(frames.charAtOrNull(i + 2, 0)))
                else -> Pair(fstRollNextFrame, pinsDown(frames.charAtOrNull(i + 1, 1)))
            }
        }

        private fun String?.isSpare() = this?.let { this.length > 1 && this[1] == SPARE_CHAR } ?: false

        private fun String?.isStrike() = this?.let { this[0] == STRIKE_CHAR } ?: false

        private fun List<String>.charAtOrNull(i: Int, j: Int) = this.getOrNull(i)?.getOrNull(j)

        private fun pinsDown(roll: Char?) = when (roll) {
            STRIKE_CHAR -> 10
            MISS_CHAR -> 0
            null -> 0
            else -> roll.digitToInt()
        }
    }
}
