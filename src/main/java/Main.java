import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows();

        Scanner scanner = new Scanner(System.in);

        String yesOrNo;

        boolean invalidInput;
        boolean game;

        do {
            bullsAndCows.guess();

            game = false;

            do {
                System.out.print("Do you want to play again: yes or no? ");

                invalidInput = true;

                yesOrNo = scanner.nextLine();

                if (yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equalsIgnoreCase("no")) {
                    invalidInput = false;
                } else {
                    System.out.println("Invalid input. Try again");
                }
            } while (invalidInput);

            if (yesOrNo.equalsIgnoreCase("yes")) {
                game = true;
            }

        } while (game);
    }
}