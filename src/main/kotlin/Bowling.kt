class Bowling {
    companion object {
        fun score(game: String): Int {
            return if(game == "X") {
                10
            } else
            if (game == "-") {
                0
            } else {
                game.toInt()
            }
        }
    }
}
