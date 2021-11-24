package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BullsNCowsTest {
    BullsNCows bullsNCows = new BullsNCows();

    @Test
    void guess() {
        assertFalse(bullsNCows.guess());

    }
}