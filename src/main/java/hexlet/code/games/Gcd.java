package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

public class Gcd {
    private static final String RULES = "Find the greatest common divisor of given numbers.";

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[Engine.MAX_NUMBER_OF_ROUND][2];

        for (int i = 0; i < Engine.MAX_NUMBER_OF_ROUND; i++) {
            int firstNumber = Utilities.getRandomNumber();
            int secondNumber = Utilities.getRandomNumber();
            int leastOperand = Math.min(firstNumber, secondNumber);

            while (leastOperand > 0) {
                if (firstNumber % leastOperand == 0 && secondNumber % leastOperand == 0) {
                    break;
                }
                leastOperand--;
            }

            questionAndAnswer[i][0] = firstNumber + " " + secondNumber;
            questionAndAnswer[i][1] = String.valueOf(leastOperand);
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.gameLoop(RULES, generateGameData());
    }
}
