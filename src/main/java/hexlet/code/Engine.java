package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Calculator;

import static java.lang.System.out;

public class Engine {
    private static int numberOfGame;
    private static String correctAnswer;
    public static final int MAX_NUMBER_OF_ROUND = 3;

    public static void choiceGame() {
        Cli.printGamesList();
        numberOfGame = Integer.parseInt(Cli.getPlayerInput());
    }

    public static String getGameQuest() {
        int multiplier = 25;
        int operand = 1 + (int) (Math.random() * multiplier);

        switch (numberOfGame) {
            case 2:
                correctAnswer = Even.getCorrectAnswer(operand);
                return Even.generateGameQuest(operand);
            case 3:
                int secondOperand = 1 + (int) (Math.random() * multiplier);
                int index = (int) (Math.random() * Calculator.getAmountOfOperators());

                correctAnswer = Calculator.getCorrectAnswer(operand, secondOperand, index);
                return Calculator.generateGameQuest(operand, secondOperand, index);
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

    public static void startGame() {
        if (numberOfGame > 0) {
            Cli.printGreet();
        }

        switch (numberOfGame) {
            case 2 -> Even.printRulesOfGames();
            case 3 -> Calculator.printRulesOfGames();
            default -> {
            }
        }

        if (numberOfGame > 1) {
            Cli.printGameResult(checkAmountOfCorrectAnswer());
        }
    }
}
