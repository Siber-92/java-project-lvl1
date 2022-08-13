package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

public class Prime {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise 'no'";

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[Engine.MAX_NUMBER_OF_ROUND][2];

        for (int i = 0; i < Engine.MAX_NUMBER_OF_ROUND; i++) {
            int number = Utilities.getRandomNumber();
            int divider = number / 2;

            String correctAnswer = "yes";
            while (divider > 1) {
                if (number % divider == 0) {
                    correctAnswer = "no";
                    break;
                }
                divider--;
            }
            questionAndAnswer[i][0] = String.valueOf(number);
            questionAndAnswer[i][1] = correctAnswer;
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.gameLoop(RULES, generateGameData());
    }
}
