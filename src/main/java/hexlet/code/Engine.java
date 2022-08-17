package hexlet.code;

import java.util.Scanner;

import static java.lang.System.out;

public class Engine {
    public static final int MAX_NUMBER_OF_ROUND = 3;
    public static final int QUESTION_INDEX = 0;
    public static final int CORRECT_ANSWER_INDEX = 1;
    public static final int NUMBER_OF_ROUND_DATA = 2;

    public static void startGameLoop(String rulesOfGame, String[][] questionAndAnswer) {
        Cli.printGreet();
        out.println(rulesOfGame);

        int round = 0;
        do {
            String question = questionAndAnswer[round][QUESTION_INDEX];
            String correctAnswer = questionAndAnswer[round][CORRECT_ANSWER_INDEX];

            out.println("Question: " + question);
            out.print("Your answer: ");
            String answer = new Scanner(System.in).next();

            if (answer.equals(correctAnswer)) {
                out.println("Correct!");
                round++;
            } else {
                out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'");
                break;
            }
        } while (round != MAX_NUMBER_OF_ROUND);

        printGameResult(round);
    }

    private static void printGameResult(int round) {
        String playerName = Cli.getPlayerName();

        if (round == MAX_NUMBER_OF_ROUND) {
            out.println("Congratulations, " + playerName + "!");
        } else {
            out.println("Let's try again, " + playerName + "!");
        }
    }
}
