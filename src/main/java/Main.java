import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BullsAndCows bullsAndCows = new BullsAndCows();

        Scanner scanner = new Scanner(System.in);

        String yesOrNo;

        boolean validInput = false;
        boolean game;

        do {
            bullsAndCows.guess();

            game = false;

            System.out.print("Do you want to play again: yes or no? ");

            yesOrNo = scanner.nextLine();

            if (yesOrNo.equalsIgnoreCase("yes") || yesOrNo.equalsIgnoreCase("no")) {
                validInput = true;
            }

            if (yesOrNo.equalsIgnoreCase("yes")) {
                game = true;
            }

            if (!validInput) {
                System.out.println("Invalid input. Try again");
            }
        } while (validInput && game);
    }
}