package second

object Bowling {

    fun score(game: String): Int {
        var total = 0
        game.forEach { char ->
            total += if(char == '1')  1
            else if (char == '2')  2
            else  0
        }
        return total
    }
}
