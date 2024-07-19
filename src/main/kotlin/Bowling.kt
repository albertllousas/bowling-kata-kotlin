class Bowling {
    companion object {
        fun score(game: String): Int {
            var count = 0
            var remaining = game
            while (remaining != "") {
                val pinsDown = remaining.first()
                count += if (pinsDown == 'X') {
                    10
                } else if (pinsDown == '-') {
                    0
                } else {
                    pinsDown.digitToInt()
                }
                remaining = remaining.drop(1)
            }
            return count
        }

    }
}
