import com.sun.source.tree.CaseTree

class Bowling {

    companion object {
        fun score(game: String): Int {
            var total = 0
            val frames = game.split(" ")
            frames.forEach { frame ->
                total += scoreSingleFrame(frame)
            }
            return total
        }

        private fun scoreSingleFrame(game: String): Int {
            var frameScore = 0
            if (game[0].digitToIntOrNull() != null) frameScore += game[0].digitToInt()
            if (game.length > 1 && game[1].digitToIntOrNull() != null) frameScore += game[1].digitToInt()
            return frameScore
        }
    }
}
