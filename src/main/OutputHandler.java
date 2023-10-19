package main;

/**
 * This class handles all text output to the player.
 */
public class OutputHandler {
    public static void displayWelcome() {
        System.out.println("\nWelcome to the Blackjack Table");
    }

    public static void displayStartMenu() {
        System.out.println("\n\n\n");
        System.out.println("        MAIN MENU");
        System.out.println(" +++++++++++++++++++++++");
        System.out.println(" 1. Start Game");
        System.out.println(" 2. Read Instructions");
        System.out.println(" 3. Close Game");
        System.out.print("\n Please make a selection: ");
    }

    public static void displayInstructions() {
        String blackjackRules = """
                1. The goal is to beat the dealer by having a hand value closer to 21 without going over.
                2. Number cards are worth their face value; face cards (King, Queen, Jack) are worth 10 points.
                3. Aces can be worth 1 or 11 points, whichever is more advantageous for the player.
                4. Each player is dealt two cards initially.
                5. Players can choose to "hit" (take another card) or "stand" (keep their current hand).
                6. If a your total exceeds 21, you bust and lose the game.
                7. The dealer must hit until their hand is worth at least 17 points.
                8. If the dealer busts, you win.
                9. If the player's hand is closer to 21 than the dealer's without busting, they win.
                10. A "blackjack" (an Ace and a 10-point card) is the highest hand and wins unless there is a tie.
                """;
        System.out.println(blackjackRules + "\n");
    }

    public static void displayStartGame(Player dealer) {
        System.out.println("\n\n The cards are dealt and the game has begun.\n");
        displayDealerHandClosed(dealer);
        System.out.println("");
    }

    private static void displayDealerHandClosed(Player dealer) {
        System.out.printf(" The dealer's current hand:%n[Hole card]%n[%s]%n%n", dealer.getHand().get(0).toString());
        System.out.printf(" The dealer's shown value is: %s%n", dealer.getHand().get(0).getValue());
    }

    public static void displayPlayerHand(Player player1) {
        System.out.println("\n Your current hand:");
        for (Card card : player1.getHand()) {
            System.out.printf(" [%s]%n", card.toString());
        }
        System.out.println("\n Your hand's value: " + player1.getHandValue());
        System.out.println("");
    }

    public static void displayHitStand() {
        System.out.println(" Enter 1 to Stand. Enter 2 to Hit.\n");
    }

    public static void displayPlayerBust() {
        System.out.println(" Bust! Dealer wins. Better luck next time!");
    }

    public static void announceDealerTurn() {
        System.out.println(" It's now the dealer's turn and they reveal the hole card.");
    }

    public static void displayDealerHandOpen(Player dealer) {
        System.out.println("\n Dealer's current hand:");
        for (Card card : dealer.getHand()) {
            System.out.printf(" [%s]%n", card.toString());
        }
        System.out.println("\n Dealer's hand value: " + dealer.getHandValue());
        System.out.println(" ");
    }

    public static void displayPlayerWin() {
        System.out.println(" Congratulations! You beat the dealer's hand\n");
    }

    public static void displayDealerWin() {
        System.out.println(" Tough luck! You lost to the dealer'n");
    }

    public static void displayPush() {
        System.out.println(" The game is tied!\n");
    }

    public static void displayBlackJackTie() {
        System.out.println(" You have blackjack!!! But so does the dealer...\n");
    }

    public static void displayBlackJackWin() {
        System.out.println(" You have blackjack. You won!!\n");

    }

    public static void displayBlackJackLoss() {
        System.out.println(" Dealer has blackjack and you lose. Better luck next time.\n");
    }

    public static void displayPlayAgain() {
        System.out.println("\n Would you like to play again? y/n");
    }

    public static void displayGoodbye() {
        System.out.println(" Thank you for playing. Come back soon!\n");
    }

    public static void displayInvalidInput() {
        System.out.println(" Invalid Selection. Try again.");
    }

}
