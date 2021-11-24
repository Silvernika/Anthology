package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  Main class of BullsNCows game
 * @author Nika
 * @version 1.0
 * */
public abstract class MainBnC implements ActionListener {
    /**
     *  yttyc
     * @author Nika
     * */
    MainBnC() {

            com.company.BullsNCows bullsAndCows = new com.company.BullsNCows();

            String yesOrNo;

            boolean invalidInput;
            boolean game;

            do {
                bullsAndCows.guess();

                do {

                    invalidInput = true;

                    yesOrNo = JOptionPane.showInputDialog("Do you want to play again(Yes/No)?");

                    if(yesOrNo == null ){
                        System.exit(0);
                    }
                    if (yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equalsIgnoreCase("no")) {
                        invalidInput = false;
                    } else {
                        JOptionPane.showMessageDialog(null,"Invalid input. Try again");
                    }
                } while (invalidInput);

                game = yesOrNo.equalsIgnoreCase("yes");

            } while (game);
        }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
