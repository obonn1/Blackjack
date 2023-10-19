package main;

/**
 * This class will play the Game
 */
public class Game {
    final int SHOE_SIZE = 1;
    Player dealer = new Player();
    Player player1 = new Player();
    Shoe shoe = new Shoe(SHOE_SIZE);
    boolean isFreshGame = true;
    boolean isGameOver = false;
    boolean isPlayerTurn;
    boolean didPlayerWin = false;

    public void play() {
        while (!isGameOver) {
            if (isFreshGame) {
                dealFreshGame();
                OutputHandler.displayStartGame(dealer);
            }
            isPlayerTurn = true;
            playerTurn(player1);
            if (!isGameOver) {
                dealerTurn();
            }
            playAgain();
        }
    }

    private void dealFreshGame() {
        dealer.giveCard(shoe.drawCard());
        dealer.giveCard(shoe.drawCard());
        player1.giveCard(shoe.drawCard());
        player1.giveCard(shoe.drawCard());
        if (shoe.getSize() < SHOE_SIZE * 52 * 0.2) {
            shoe = new Shoe(SHOE_SIZE);
        }
    }

    private void playerTurn(Player player) {

        OutputHandler.displayPlayerHand(player);
        if (checkBlackJack(player)) {
            processPlayerBlackJack();
        }

        while (isPlayerTurn) {
            if (checkBust(player)) {
                processPlayerBust();
            } else {
                OutputHandler.displayHitStand();
                int selection = InputHandler.getHitStand();
                processHitStand(selection);
                OutputHandler.displayPlayerHand(player);
            }
        }
    }
    
    private void dealerTurn() {
        OutputHandler.announceDealerTurn();
        processDealerHitStand();
        if (checkBlackJack(dealer)) {
            processDealerBlackJack();
        } else if (checkBust(dealer)) {
            OutputHandler.displayDealerHandOpen(dealer);
            processDealerBust();
        } else {
            OutputHandler.displayDealerHandOpen(dealer);
            processEndGame();
        }
    }
    
        private void processPlayerBlackJack() {
            if (checkBlackJack(dealer)) {
                OutputHandler.displayBlackJackTie();
                OutputHandler.displayPush();
            } else {
                OutputHandler.displayBlackJackWin();
            }
            isGameOver = true;
            isPlayerTurn = false;
        }

    private void processEndGame() {
        if (dealer.getHandValue() > player1.getHandValue()) {
            OutputHandler.displayDealerWin();
        } else if (player1.getHandValue() > dealer.getHandValue()) {
            OutputHandler.displayPlayerWin();
        } else {
            OutputHandler.displayPush();
        }
        isGameOver = true;
    }

    private void processDealerHitStand() {
        while (dealer.getHandValue() < 17) {
            dealer.giveCard(shoe.drawCard());
        }
    }

    private void processDealerBust() {
        OutputHandler.displayPlayerWin();
        isGameOver = true;
    }

    private void processDealerBlackJack() {
            OutputHandler.displayBlackJackLoss();
            isGameOver = true;
    }

    private boolean checkBlackJack(Player dealer) {
        return dealer.getHand().size() == 2 && dealer.getHandValue() == 21;
    }

    private void processPlayerBust() {
        OutputHandler.displayPlayerBust();
        isPlayerTurn = false;
        isGameOver = true;
    }

    private boolean checkBust(Player player) {
        return player.getHandValue() > 21;
    }

    private void processHitStand(int selection) {
        if (selection == 1) {
            isPlayerTurn = false;
        } else {
            player1.giveCard(shoe.drawCard());
        }

    }
    private void playAgain() {
        OutputHandler.displayPlayAgain();
        if (InputHandler.getYesNo()) {
            reset();
        } else {
            OutputHandler.displayGoodbye();
        }
    }

    private void reset() {
        isGameOver = false;
        isFreshGame = true;
        dealer.clearHand();
        player1.clearHand();
    }

}
