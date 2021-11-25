package com.company;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BullsNCowsTest {

    @Test
    void Testing() {
        BullsNCows bullsNCows = new BullsNCows();
        int res = 0;
        assertEquals(res, BullsNCows.guess);
    }
}