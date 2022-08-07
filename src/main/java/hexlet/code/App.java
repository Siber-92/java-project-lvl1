package hexlet.code;

import static java.lang.System.out;

//Файл App.java предназначен только для отображения игрового меню, выбора
// и запуска нужной игры
public class App {
    public static void main(String[] args) {
        String[] games = {"Exit", "Greet", "Even"};

        out.println("Please enter the game number and press Enter");
        for (int i = 1; i < games.length; i++) {
            out.println(i + " - " + games[i]);
        }
        out.println("0 - Exit");

        out.print("Your choice: ");
        int numberOfGame = Integer.parseInt(Cli.getPlayerInput());

        if (numberOfGame != 0) {
            out.println("Welcome to the Brain Games!");
            out.print("May I have your name? ");
            String playerName = Cli.getPlayerInput();
            out.println("Hello, " + playerName + "!");

            switch (numberOfGame) {
                case 2:
                    Even.printRulesOfGames();

                    if (Even.getCountOfRightAnswers() == Even.getRequiredNumberOfRightAnswers()) {
                        out.println("Congratulations, " + playerName + "!");
                    } else {
                        out.println("Let's try again, " + playerName + "!");
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
