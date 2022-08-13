package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

import static hexlet.code.Engine.NUMBER_OF_ROUND_DATA;
import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.CORRECT_ANSWER_INDEX;
import static hexlet.code.Engine.MAX_NUMBER_OF_ROUND;

public class Gcd {
    private static final String RULES = "Find the greatest common divisor of given numbers.";

    private static String gcd(int firstNum, int secondNum) {
        int leastOperand = Math.min(firstNum, secondNum);

        while (leastOperand > 0) {
            if (firstNum % leastOperand == 0 && secondNum % leastOperand == 0) {
                break;
            }
            leastOperand--;
        }
        return String.valueOf(leastOperand);
    }

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[MAX_NUMBER_OF_ROUND][NUMBER_OF_ROUND_DATA];

        for (int i = 0; i < MAX_NUMBER_OF_ROUND; i++) {
            int firstNum = Utilities.getRandomNumber();
            int secondNum = Utilities.getRandomNumber();

            questionAndAnswer[i][QUESTION_INDEX] = firstNum + " " + secondNum;
            questionAndAnswer[i][CORRECT_ANSWER_INDEX] = gcd(firstNum, secondNum);
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.gameLoop(RULES, generateGameData());
    }
}
