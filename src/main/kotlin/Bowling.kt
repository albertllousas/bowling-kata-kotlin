import com.sun.source.tree.CaseTree

class Bowling {

    companion object {
        fun score(game: String): Int {
            var total = 0
            val frames = game.split(" ")
            frames.forEach { frame ->
                total = scoreSingleFrame(frame, total)
            }
            return total
        }

        private fun scoreSingleFrame(game: String, total: Int): Int {
            var total1 = total
            if (game[0].digitToIntOrNull() != null) total1 += game[0].digitToInt()
            if (game.length > 1 && game[1].digitToIntOrNull() != null) total1 += game[1].digitToInt()
            return total1
        }
    }
}
