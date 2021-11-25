package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Game2048Test {

    @Test
    void resetGame() {
        assertNotNull(new Game2048());
    }

    @Test
    void left() {
        assertNotNull(new Game2048.Tile());
    }

}