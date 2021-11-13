import java.security.SecureRandom;
import java.util.Scanner;

public class BullsAndCows {
    private static final int TRYMAXNUM = 2;

    SecureRandom random = new SecureRandom();

    public void guess() {
        boolean isFind = false;

        String guessedNumStr = Integer.toString(getGuessedNum());
        String inputStr;

        System.out.println(guessedNumStr);
        System.out.println();

        int tryNum = 0;
        int cows;
        int bulls;

        while (!isFind && tryNum < TRYMAXNUM) {
            System.out.print("Guess a number, you have " + (TRYMAXNUM - tryNum) + " attempts: ");

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
                System.out.println("There are " + cows + " cows and " + bulls + " bulls");
                System.out.println();
            }

            tryNum++;
        }

        if (isFind) {
            System.out.println("You won after " + tryNum + " guesses!");
        } else {
            System.out.println("You lose! The number was: " + guessedNumStr);
        }
    }

    private int getGuessedNum() {
        boolean checker;

        int guessedNum;

        do {
            checker = false;

            guessedNum = random.nextInt(9000) + 1000;

            if (hasDupes(guessedNum)) {
                checker = true;
            }

        } while (checker);

        return guessedNum;
    }

    private static int getInput() {
        Scanner scanner = new Scanner(System.in);

        boolean checker;

        int guess;

        do {
            checker = false;

            guess = scanner.nextInt();

            if (guess < 1000 || guess > 10000) {
                checker = true;

                System.out.print("Invalid input, try again: ");

                continue;
            }

            if (hasDupes(guess)) {
                checker = true;

                System.out.print("Your number has dupes, try again: ");
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
