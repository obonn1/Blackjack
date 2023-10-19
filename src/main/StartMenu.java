package main;
/**
 * this class represents the initial game loop's menu.
 */
public class StartMenu {
    private boolean quitGame = false;

    public void start() {
        OutputHandler.displayWelcome();
        while (!quitGame) {
            OutputHandler.displayStartMenu();
            int selection = InputHandler.getStartMenuDecision();
            processStartMenuSelection(selection);

        }
    }

    private void processStartMenuSelection(int selection) {
        Game game = new Game();
        switch (selection) {
            case 1:
                game.play();
                break;
            case 2:
                OutputHandler.displayInstructions();
                break;
            case 3:
                quitGame = true;
                break;
            default:
                break;
        }
    }
}
