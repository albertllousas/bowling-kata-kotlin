package org.example

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BowlingTest{

    @Test
    fun `given game with only one 0 the match should end with 0 points`(){
        val result = Bowling.score("0")

        assertEquals(0, result)
    }
}