class Bowling {
    companion object {
        fun score(game: String): Int {
            var count = 0
            val frames = game.split(" ")
            for (frame in frames) {
                var currentFrame =  frame
                while (currentFrame != "") {
                    val pinsDown = currentFrame.first()
                    count += if (pinsDown == 'X') {
                        10
                    } else if (pinsDown == '-') {
                        0
                    } else {
                        pinsDown.digitToInt()
                    }
                    currentFrame = currentFrame.drop(1)
                }
            }
            return count
        }

    }
}
