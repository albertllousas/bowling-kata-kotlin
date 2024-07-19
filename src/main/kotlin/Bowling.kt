class Bowling {
    companion object {
        fun score(game: String): Int {
            var count = 0
            val frames = game.split(" ")
            var spare = false

            for (frame in frames) {
                when {
                    frame.contains("/") -> {
                        spare = true
                        count += 10
                    }

                    frame.contains("X") -> {
                        count += 10
                    }

                    else -> {
                        val digits = frame.replace("-", "0")
                        val firstVal = (digits[0].digitToInt() * if (spare) 2 else 1)
                        val secondVal = digits.getOrElse(1) { '0' }.digitToInt()
                        count += firstVal + secondVal
                        spare = false
                    }
                }
            }
            return count
        }

    }
}
