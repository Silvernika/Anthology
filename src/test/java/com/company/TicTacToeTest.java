package com.company;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Random;

import static org.mockito.Mockito.*;

class TicTacToeTest {

    private TicTacToe ticTacToeUnderTest;

    @BeforeEach
    void setUp() {
        ticTacToeUnderTest = new TicTacToe();
        ticTacToeUnderTest.random = mock(Random.class);
        ticTacToeUnderTest.frame = mock(JFrame.class);
        ticTacToeUnderTest.title_panel = mock(JPanel.class);
        ticTacToeUnderTest.button_panel = mock(JPanel.class);
        ticTacToeUnderTest.textfield = mock(JLabel.class);
        ticTacToeUnderTest.buttons = new JButton[]{new JButton("text")};
        ticTacToeUnderTest.player1_turn = false;
        ticTacToeUnderTest.flag = false;
        ticTacToeUnderTest.image = mock(ImageIcon.class);
    }

    @Test
    void testActionPerformed() {
        // Setup
        final ActionEvent e = new ActionEvent("source", 0, "command", 0L, 0);

        // Run the test
        ticTacToeUnderTest.actionPerformed(e);

        // Verify the results
        verify(ticTacToeUnderTest.textfield).setText("text");
        verify(ticTacToeUnderTest.frame).setVisible(false);
    }

    @Test
    void testFirstTurn() {
        // Setup
        when(ticTacToeUnderTest.random.nextInt(0)).thenReturn(0);

        // Run the test
        ticTacToeUnderTest.firstTurn();

        // Verify the results
        verify(ticTacToeUnderTest.textfield).setText("text");
    }

    @Test
    void testCheck() {
        // Setup

        // Run the test
        ticTacToeUnderTest.check();

        // Verify the results
        verify(ticTacToeUnderTest.textfield).setText("text");
        verify(ticTacToeUnderTest.frame).setVisible(false);
    }

    @Test
    void testXWins() {
        // Setup

        // Run the test
        ticTacToeUnderTest.xWins(0, 0, 0);

        // Verify the results
        verify(ticTacToeUnderTest.textfield).setText("text");
        verify(ticTacToeUnderTest.frame).setVisible(false);
    }

    @Test
    void testOWins() {
        // Setup

        // Run the test
        ticTacToeUnderTest.oWins(0, 0, 0);

        // Verify the results
        verify(ticTacToeUnderTest.textfield).setText("text");
        verify(ticTacToeUnderTest.frame).setVisible(false);
    }
}
