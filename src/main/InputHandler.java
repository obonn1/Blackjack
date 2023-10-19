package main;

import java.util.Scanner;
/**
 * This class handles all player input.
 */
public class InputHandler {

    private static final Scanner scanner = new Scanner(System.in);

    public static int getStartMenuDecision() {
        return getNumericInput(1, 3);
    }

    public static int getHitStand() {
        return getNumericInput(1, 2);
    }

    private static int getNumericInput(int startNumber, int endNumber) {
        String validInputs = "";
        for (int i = startNumber; i <= endNumber; i++) {
            validInputs += i;
        }
        while (true) {
            String input = scanner.nextLine();
            if (input.length() == 1 && validInputs.contains(input)) {
                return Integer.parseInt(input);
            } else {
                OutputHandler.displayInvalidInput();
            }
        }
    }

    public static boolean getYesNo() {
        while (true) {
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "yes":
                case "y":
                    return true;
                case "n":
                case "no":
                    return false;
                default:
                    OutputHandler.displayInvalidInput();
            }
        }
    }
}
