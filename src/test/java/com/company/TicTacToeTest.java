package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    @Test
    void actionPerformed() {
        TicTacToe ticTacToe = new TicTacToe();
        assertTrue(TicTacToe.flag);
    }
}