package com.company;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 *  Main class of 2048 game
 * @author Denis
 * @version 1.0
 * */
public abstract class Main2048 implements ActionListener {
        /**
         *  hgfhgjvjhcgjh
         * @author Denis
         * */
    Main2048() {
            JFrame game = new JFrame();
            ImageIcon image2048 = new ImageIcon("Без названия.png");
            game.setTitle("2048");
            game.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            game.setSize(355, 400);
            game.setResizable(true);
            game.setIconImage(image2048.getImage());
            game.add(new Game2048());

            game.setLocationRelativeTo(null);
            game.setVisible(true);
    }
}