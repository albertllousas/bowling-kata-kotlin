class Bowling {

    companion object {
        fun score(game: String): Int {
            var total = 0
            val frames = game.split(" ")
            frames.forEachIndexed { i, frame ->
                val nextBall = (if (i + 1 < frames.size) frames[i + 1][0].digitToIntOrNull() else 0) ?: 0
                val ballAfterNext = (if (i + 1 < frames.size) frames[i + 1][1].digitToIntOrNull() else 0) ?: 0
                total += scoreSingleFrame(frame, nextBall, ballAfterNext)
            }
            return total
        }

        private fun scoreSingleFrame(game: String, nextBall: Int, ballAfterNext: Int): Int {
            var frameScore = 0
            if (game[0].digitToIntOrNull() != null) frameScore += game[0].digitToInt()
            if (game.length > 1 && game[1].digitToIntOrNull() != null) frameScore += game[1].digitToInt()
            if (game.length > 1 && game[1] == '/') frameScore = 10 + nextBall
            if (game == "X") frameScore = 10 + nextBall + ballAfterNext
            return frameScore
        }
    }
}
