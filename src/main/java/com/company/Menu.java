package com.company;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Main menu of our game Antology.
 * @author Anton Polovoy "a.polovoy@inbox.ru"
 * @version 1.0
 * */
public abstract class Menu extends JFrame implements ActionListener {
     JFrame menu = new JFrame();
    /**
     *  Drawing the main menu with buttons.
     *  Each button refers to its own game class.
     * @author Anton Polovoy "a.polovoy@inbox.ru"
     * */
    Menu(){

        menu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        menu.setSize(800,800);
        menu.setLayout(null);
        menu.setResizable(false);
        menu.setVisible(true);
        menu.getContentPane().setBackground(new Color(123, 50, 250));
        menu.setLayout(new BorderLayout());
        menu.setTitle("Антология игр");
        JButton game_tictactoe = new JButton();
        game_tictactoe.setBounds(250,105,300,100);
        game_tictactoe.addActionListener(e -> new com.company.TicTacToe());
        game_tictactoe.setForeground(Color.BLUE);
        game_tictactoe.setFont(new Font("Comic Sans",Font.ITALIC,25));
        game_tictactoe.setBackground(Color.lightGray);
        game_tictactoe.setBackground(Color.lightGray);
        game_tictactoe.setText("Крестики-нолики");
        game_tictactoe.setFocusable(false);

        JButton game_2048 = new JButton();
        game_2048.setBounds(250,235,300,100);
        game_2048.addActionListener(e -> new com.company.Main2048()  {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        game_2048.setForeground(Color.BLUE);
        game_2048.setFont(new Font("Comic Sans",Font.ITALIC,25));
        game_2048.setBackground(Color.lightGray);
        game_2048.setBackground(Color.lightGray);
        game_2048.setText("2048");
        game_2048.setFocusable(false);

        JButton game_BnC = new JButton();
        game_BnC.setBounds(250,355,300,100);
        game_BnC.addActionListener(e -> new com.company.MainBnC()  {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        game_BnC.setForeground(Color.BLUE);
        game_BnC.setFont(new Font("Comic Sans",Font.ITALIC,25));
        game_BnC.setBackground(Color.lightGray);
        game_BnC.setBackground(Color.lightGray);
        game_BnC.setText("Быки и коровы");
        game_BnC.setFocusable(false);

        JButton game_exit = new JButton();
        game_exit.setBounds(250,475,300,100);
        game_exit.addActionListener(e -> System.exit(0));
        game_exit.setForeground(Color.BLUE);
        game_exit.setFont(new Font("Comic Sans",Font.ITALIC,25));
        game_exit.setBackground(Color.lightGray);
        game_exit.setText("ВЫЙТИ");
        game_exit.setFocusable(false);

        menu.add(game_tictactoe);
        menu.add(game_2048);
        menu.add(game_BnC);
        menu.add(game_exit);

    }

}
