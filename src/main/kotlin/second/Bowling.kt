package second

object Bowling {

    private const val FRAME_DELIMITER = " "

    fun score(game: String): Int {
        val frames = parse(game)
        return frames.foldRightIndexed(0) { index, frame, total ->
            if(isSpare(frame)) total + 10 + pinsDownNextRolls(frames, index, 1)
            else if(isStrike(frame)) total + 10 + pinsDownNextRolls(frames, index, 2)
            else total + frame.sum()
        }
    }

    private fun isStrike(frame: List<Int>) = frame.size == 1 && frame[0] == 10

    private fun pinsDownNextRolls(frames: List<List<Int>>, currentIdx: Int, numOfRolls: Int) =
        frames.drop(currentIdx + 1).flatten().take(numOfRolls).sum()

    private fun isSpare(frame: List<Int>) = frame.size == 2 && frame.sum() == 10

    private fun parse(game: String): List<List<Int>> {
        return game.split(FRAME_DELIMITER).map { frame ->
            frame.mapIndexed { index, char ->
                if(char == '/') 10 - frame[index - 1].pinsDown()
                else if(char == 'X') 10
                else char.pinsDown()
            }
        }
    }

    private fun Char.pinsDown() = if(this == '-') 0 else this.digitToInt()
}
