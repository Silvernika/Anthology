package com.company;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *  Main class of TicTacToe game
 * @author Anton Polovoy "a.polovoy@inbox.ru"
 * @version 1.0
 * */
public class TicTacToe implements ActionListener {

    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    boolean flag = true;
    ImageIcon image = new ImageIcon("xoxo.png");
    /**
     *  The TicTacToe method is the main method in which the game window is created,
     *  as well as the creation of a 3x3 playing field from 9 buttons.
     *  Consists of check method, oWins method, xWins method, firsTurn method,
     *  @author Anton Polovoy "a.polovoy@inbox.ru"
     * */
    TicTacToe() {

        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setIconImage(image.getImage());
        textfield.setBackground(new Color(35, 35, 35));
        textfield.setForeground(new Color(125, 250, 0, 203));
        textfield.setFont(new Font("Courier New", Font.PLAIN, 95));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setBorder(BorderFactory.createLineBorder(Color.GREEN, 3));
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3, 5, 5));
        button_panel.setBackground(new Color(125, 250, 0, 203));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("Courier New", Font.PLAIN, 240));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check();
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(Color.GREEN);
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
/**
 * Here randomly determines whose move will be the first.
 * */
    public void firstTurn() {

        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0) {
            player1_turn = true;
            textfield.setText("X turn");
        } else {
            player1_turn = false;
            textfield.setText("O turn");
        }
    }

    /**
     * Game condition check. This method refers to oWins and xWins methods.
     * */
    public void check() {
        //check X win conditions
        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[1].getText().equals("X")) &&
                        (buttons[2].getText().equals("X"))
        ) {
            xWins(0, 1, 2);
        }
        if (
                (buttons[3].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[5].getText().equals("X"))
        ) {
            xWins(3, 4, 5);
        }
        if (
                (buttons[6].getText().equals("X")) &&
                        (buttons[7].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(6, 7, 8);
        }
        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[3].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))
        ) {
            xWins(0, 3, 6);
        }
        if (
                (buttons[1].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[7].getText().equals("X"))
        ) {
            xWins(1, 4, 7);
        }
        if (
                (buttons[2].getText().equals("X")) &&
                        (buttons[5].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(2, 5, 8);
        }
        if (
                (buttons[0].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[8].getText().equals("X"))
        ) {
            xWins(0, 4, 8);
        }
        if (
                (buttons[2].getText().equals("X")) &&
                        (buttons[4].getText().equals("X")) &&
                        (buttons[6].getText().equals("X"))
        ) {
            xWins(2, 4, 6);
        }
        //check O win conditions
        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[1].getText().equals("O")) &&
                        (buttons[2].getText().equals("O"))
        ) {
            oWins(0, 1, 2);
        }
        if (
                (buttons[3].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[5].getText().equals("O"))
        ) {
            oWins(3, 4, 5);
        }
        if (
                (buttons[6].getText().equals("O")) &&
                        (buttons[7].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(6, 7, 8);
        }
        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[3].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))
        ) {
            oWins(0, 3, 6);
        }
        if (
                (buttons[1].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[7].getText().equals("O"))
        ) {
            oWins(1, 4, 7);
        }
        if (
                (buttons[2].getText().equals("O")) &&
                        (buttons[5].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(2, 5, 8);
        }
        if (
                (buttons[0].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[8].getText().equals("O"))
        ) {
            oWins(0, 4, 8);
        }
        if (
                (buttons[2].getText().equals("O")) &&
                        (buttons[4].getText().equals("O")) &&
                        (buttons[6].getText().equals("O"))
        ) {
            oWins(2, 4, 6);

        }
        if (flag) {
            if (
                    ((buttons[0].getText().equals("O")) || (buttons[0].getText().equals("X"))) &&
                            ((buttons[1].getText().equals("O")) || (buttons[1].getText().equals("X"))) &&
                            ((buttons[2].getText().equals("O")) || (buttons[2].getText().equals("X"))) &&
                            ((buttons[3].getText().equals("O")) || (buttons[3].getText().equals("X"))) &&
                            ((buttons[4].getText().equals("O")) || (buttons[4].getText().equals("X"))) &&
                            ((buttons[5].getText().equals("O")) || (buttons[5].getText().equals("X"))) &&
                            ((buttons[6].getText().equals("O")) || (buttons[6].getText().equals("X"))) &&
                            ((buttons[7].getText().equals("O")) || (buttons[7].getText().equals("X"))) &&
                            (((buttons[8].getText().equals("O")) || (buttons[8].getText().equals("X"))))) {
                for (int i = 0; i < 9; i++) {
                    buttons[i].setEnabled(false);
                    textfield.setText("DRAW!!!");
                }
                boolean invalidInput = true;
                String answer;
                do {


                    answer = JOptionPane.showInputDialog("Do you want to play again(Yes/No)?");
                    if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                        invalidInput = false;
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid input. Try again");
                    }
                } while (invalidInput);

                if (answer.equalsIgnoreCase("yes")) {
                    frame.setVisible(false);
                    new TicTacToe();
                }
                else frame.setVisible(false);
            }
        }
    }
/**
 *  Displaying a message that the X's won,
 *  highlighting the winning combination in red,
 *  disables all buttons.
 * */
    public void xWins(int a, int b, int c) {
        buttons[a].setBackground(Color.RED);
        buttons[b].setBackground(Color.RED);
        buttons[c].setBackground(Color.RED);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        textfield.setText("X wins");
        flag = false;
    }
        boolean invalidInput = true;
        String answer;
        do {


            answer = JOptionPane.showInputDialog("Do you want to play again(Yes/No)?");
            if(answer == null ){
                System.exit(0);
            }
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                invalidInput = false;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Try again");
            }
        } while (invalidInput);

        if (answer.equalsIgnoreCase("yes")) {
            frame.setVisible(false);
            new TicTacToe();
        }
        else frame.setVisible(false);
    }
    /**
     *  Displaying a message that the O's won,
     *  highlighting the winning combination in green,
     *  disables all buttons.
     * */
    public void oWins(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);

            textfield.setText("O wins");
            flag = false;
        }
        boolean invalidInput = true;
        String answer;
        do {


            answer = JOptionPane.showInputDialog("Do you want to play again(Yes/No)?");
            if(answer == null ){
                System.exit(1);
            }
            if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("no")) {
                invalidInput = false;
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input. Try again");
            }
        } while (invalidInput);

        if (answer.equalsIgnoreCase("yes")) {
            frame.setVisible(false);
            new TicTacToe();
            flag=true;
        }
        else frame.setVisible(false);


    }
}
