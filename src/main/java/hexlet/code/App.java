package hexlet.code;

public class App {
    public static void main(String[] args) {
        Cli.printGamesList();

        int numberOfGame = Integer.parseInt(Cli.getPlayerInput());

        switch (numberOfGame) {
            case 1:
                Cli.printGreet();
                break;
            case 2:
                Even.startGame();
                break;
            default:
                break;
        }
    }
}

