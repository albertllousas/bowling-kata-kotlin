import com.sun.source.tree.CaseTree

class Bowling {
    companion object {
        fun score(game: String): Int {
            var total = 0
            if(game[0].digitToIntOrNull() != null) total += game[0].digitToInt()
            if(game.length > 1 && game[1].digitToIntOrNull() != null) total += game[1].digitToInt()
            return total
        }
    }
}
