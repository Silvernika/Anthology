package com.company;
import java.util.Random;
import  javax.swing.JOptionPane;

public class BullsNCows {
    private static final int TRYMAXNUM = 1;


    public void guess() {
        boolean isFind = false;

        String guessedNumStr = Integer.toString(getGuessedNum());
        String inputStr;


        int tryNum = 0;
        int cows;
        int bulls;

        while (!isFind && tryNum < TRYMAXNUM) {
            JOptionPane.showMessageDialog(null,"Guess a number, you have " + (TRYMAXNUM - tryNum) + " attempts: ");

            inputStr = Integer.toString(getInput());

            cows = 0;
            bulls = 0;

            for (int i = 0; i < 4; i++) {
                if (guessedNumStr.charAt(i) == inputStr.charAt(i)) {
                    bulls++;
                } else if (guessedNumStr.contains(Character.toString(inputStr.charAt(i)))) {
                    cows++;
                }
            }

            if (bulls == 4) {
                isFind = true;
            } else {
                JOptionPane.showMessageDialog(null,"There are " + cows + " cows and " + bulls + " bulls");
            }

            tryNum++;
        }

        if (isFind) {
            JOptionPane.showMessageDialog(null,"You won after " + tryNum + " guesses!");
        } else {
            JOptionPane.showMessageDialog(null,"You lose! The number was: " + guessedNumStr);
        }
    }

    private int getGuessedNum() {
        boolean checker;

        int guessedNum;

        do {
            checker = false;
            Random random = new Random();
            guessedNum = random.nextInt(9000) + 1000;

            if (hasDupes(guessedNum)) {
                checker = true;
            }

        } while (checker);

        return guessedNum;
    }

    private static int getInput() {
        boolean checker;

        int guess = 0;

        do {
            checker = false;

            try {
                guess = Integer.parseInt(JOptionPane.showInputDialog(null,"Guesed number"));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Invalid input, try again: ");

                checker = true;

                continue;
            }


            if (guess < 1000 || guess > 10000) {
                checker = true;

                JOptionPane.showMessageDialog(null,"Invalid input, try again: ");

                continue;
            }

            if (hasDupes(guess)) {
                checker = true;

                JOptionPane.showMessageDialog(null,"Your number has dupes, try again: ");
            }

        } while (checker);

        return guess;
    }

    private static boolean hasDupes(int num){
        String checkNum = Integer.toString(num);
        return checkNum.charAt(0) == checkNum.charAt(1) || checkNum.charAt(0) == checkNum.charAt(2)
                || checkNum.charAt(0) == checkNum.charAt(3) || checkNum.charAt(1) == checkNum.charAt(2)
                || checkNum.charAt(1) == checkNum.charAt(3) || checkNum.charAt(2) == checkNum.charAt(3);
    }
}