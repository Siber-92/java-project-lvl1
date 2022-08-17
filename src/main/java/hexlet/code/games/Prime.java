package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.NUMBER_OF_ROUND_DATA;
import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.CORRECT_ANSWER_INDEX;
import static hexlet.code.Engine.MAX_NUMBER_OF_ROUND;
import static hexlet.code.Utilities.getRandomNumber;

public class Prime {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise 'no'";

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i < number / 2; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[MAX_NUMBER_OF_ROUND][NUMBER_OF_ROUND_DATA];

        for (int i = 0; i < MAX_NUMBER_OF_ROUND; i++) {
            int number = getRandomNumber();

            questionAndAnswer[i][QUESTION_INDEX] = String.valueOf(number);
            questionAndAnswer[i][CORRECT_ANSWER_INDEX] = isPrime(number) ? "yes" : "no";
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.startGameLoop(RULES, generateGameData());
    }
}
