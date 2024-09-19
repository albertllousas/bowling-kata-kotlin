package second

object Bowling {

    private const val FRAME_DELIMITER = " "

    fun score(game: String): Int {
        val frames = parse(game)
        return frames.foldRightIndexed(0) { index, frame, total ->
            if(isSpare(frame)) total + 10 + nextRoll(frames, index)
            else total + frame.sum()
        }
    }

    private fun nextRoll(frames: List<List<Int>>, currentIdx: Int) =
        frames.getOrNull(currentIdx + 1)?.getOrElse(0) { 0 } ?: 0

    private fun isSpare(frame: List<Int>) = frame.size == 2 && frame.sum() == 10

    private fun parse(game: String): List<List<Int>> {
        return game.split(FRAME_DELIMITER).map { frame ->
            frame.mapIndexed { index, char ->
                if(char == '/') 10 - frame[index - 1].pinsDown()
                else char.pinsDown()
            }
        }
    }

    private fun Char.pinsDown() = if(this == '-') 0 else this.digitToInt()
}
