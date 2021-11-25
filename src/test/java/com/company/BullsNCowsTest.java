package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BullsNCowsTest {

    private BullsNCows bullsNCowsUnderTest;

    @BeforeEach
    void setUp() {
        bullsNCowsUnderTest = new BullsNCows();
    }

    @Test
    void testGuess() {
        // Setup

        // Run the test
        bullsNCowsUnderTest.guess();

        // Verify the results
    }
}
