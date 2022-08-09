package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calculator;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import static java.lang.System.out;

public class Engine {
    private static final int MAX_NUMBER_OF_ROUND = 3;
    private static final int LOWER_BOUND = 2;
    private static final int MULTIPLIER = 25; // LOWER_BOUND + MULTIPLIER == higherBound
    private static int operand;
    private static int secondOperand;
    private static int countOfRightAnswer = 0;
    private static String selectedGame;
    private static String rulesOfGame = "";
    private static String correctAnswer;
    private static String question;

    public static void printGamesList() {
        final String[] games = {"Exit", "Greet", "Even", "Calculator", "GCD", "Progression", "Prime"};

        out.println("Please enter the game number and press Enter");
        for (int i = 1; i < games.length; i++) {
            out.println(i + " - " + games[i]);
        }
        out.println("0 - Exit");
        out.print("Your choice: ");
    }

    public static void startGame() {
        printGamesList();
        selectedGame = Cli.getPlayerInput();
        if (!selectedGame.equals("0")) {
            out.println();
            Cli.printGreet();
            if (!selectedGame.equals("1")) {
                gameLoop();
                out.println(rulesOfGame);
                startQuiz();
                printGameResult();
            }
        }
    }

    public static void gameLoop() {
        generateGamesVariable();
        switch (selectedGame) {
            case "2" -> Even.startGame(operand);
            case "3" -> Calculator.startGame(operand, secondOperand);
            case "4" -> Gcd.startGame(operand, secondOperand);
            case "5" -> Progression.startGame(operand, secondOperand);
            case "6" -> Prime.startGame(operand);
            default -> {
            }
        }
    }

    public static void setVariable(String rules, String gameQuest, String answerToQuestion) {
        if (rulesOfGame.equals("")) {
            rulesOfGame = rules;
        }
        question = gameQuest;
        correctAnswer = answerToQuestion;
    }

    public static void generateGamesVariable() {
        operand = LOWER_BOUND + (int) (Math.random() * MULTIPLIER);
        secondOperand = LOWER_BOUND + (int) (Math.random() * MULTIPLIER);
    }

    public static void startQuiz() {
        for (int i = 0; i < MAX_NUMBER_OF_ROUND; i++) {
            out.println("Question: " + question);
            out.print("Your answer: ");
            String answer = Cli.getPlayerInput();
            if (answer.equals(correctAnswer)) {
                out.println("Correct!");
                countOfRightAnswer++;
            } else {
                out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
                break;
            }
            gameLoop();
        }
    }

    public static void printGameResult() {
        String playerName = Cli.getPlayerName();

        if (countOfRightAnswer == MAX_NUMBER_OF_ROUND) {
            out.println("Congratulations, " + playerName + "!");
        } else {
            out.println("Let's try again, " + playerName + "!");
        }
    }
}
