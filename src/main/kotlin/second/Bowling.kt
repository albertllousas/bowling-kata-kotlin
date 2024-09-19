package second

object Bowling {

    fun score(game: String): Int {
        var total = 0
        val frames = game.split(" ")
        frames.forEach { frame ->
            frame.forEach { char ->
                total += if (char == '1') 1
                else if (char == '2') 2
                else 0
            }
        }
        return total
    }
}
