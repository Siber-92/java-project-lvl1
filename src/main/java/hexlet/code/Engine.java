package hexlet.code;

import hexlet.code.games.*;

import static java.lang.System.out;

public class Engine {
    private static final String[] GAMES = {"Exit", "Greet", "Even", "Calculator", "GCD", "Progression", "Prime"};
    private static final int MAX_NUMBER_OF_ROUND = 3;
    private static int numberOfGame;
    private static String correctAnswer;

    public static void printGamesList() {
        out.println("Please enter the game number and press Enter");
        for (int i = 1; i < GAMES.length; i++) {
            out.println(i + " - " + GAMES[i]);
        }
        out.println("0 - Exit");
        out.print("Your choice: ");
    }

    public static void choiceGame() {
        printGamesList();
        numberOfGame = Integer.parseInt(Cli.getPlayerInput());
        out.println();
    }

    public static String getGameQuest() {
        int lowerBound = 2;
        int multiplier = 25; // lowerBound + multiplier == higherBound
        int operand = lowerBound + (int) (Math.random() * multiplier);
        int secondOperand = lowerBound + (int) (Math.random() * multiplier);

        switch (numberOfGame) {
            case 2:
                correctAnswer = Even.getCorrectAnswer(operand);
                return Even.generateGameQuest(operand);
            case 3:
                correctAnswer = Calculator.getCorrectAnswer(operand, secondOperand);
                return Calculator.generateGameQuest(operand, secondOperand);
            case 4:
                correctAnswer = GCD.getCorrectAnswer(operand, secondOperand);
                return GCD.generateGameQuest(operand, secondOperand);
            case 5:
                correctAnswer = Progression.getCorrectAnswer(operand, secondOperand);
                return Progression.generateGameQuest();
            case 6:
                correctAnswer = Prime.getCorrectAnswer(operand);
                return Prime.generateGameQuest(operand);
            default:
                return null;
        }
    }

    public static boolean checkAmountOfCorrectAnswer() {
        String answer;
        String question;
        int countOfRightAnswer = 0;

        for (int i = 0; i < Engine.MAX_NUMBER_OF_ROUND; i++) {
            question = getGameQuest();
            out.println("Question: " + question);
            out.print("Your answer: ");
            answer = Cli.getPlayerInput();

            if (answer.equals(correctAnswer)) {
                out.println("Correct!");
                countOfRightAnswer++;
            } else {
                out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
                break;
            }
        }
        return countOfRightAnswer == Engine.MAX_NUMBER_OF_ROUND;
    }

    public static void printGameResult(boolean gameResult) {
        String playerName = Cli.getPlayerName();
        if (gameResult) {
            out.println("Congratulations, " + playerName + "!");
        } else {
            out.println("Let's try again, " + playerName + "!");
        }
    }

    public static void startGame() {
        if (numberOfGame > 0) {
            Cli.printGreet();
        }

        switch (numberOfGame) {
            case 2 -> Even.printRulesOfGames();
            case 3 -> Calculator.printRulesOfGames();
            case 4 -> GCD.printRulesOfGames();
            case 5 -> Progression.printRulesOfGames();
            case 6 -> Prime.printRulesOfGames();
            default -> {
            }
        }

        if (numberOfGame > 1) {
            printGameResult(checkAmountOfCorrectAnswer());
        }
    }
}
