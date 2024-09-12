import com.sun.source.tree.CaseTree

class Bowling {
    companion object {
        fun score(game: String): Int {
            if(game == "-") return 0
            else if(game == "1") return 1
            else throw NotImplementedError("Not implemented yet")
        }
    }
}
