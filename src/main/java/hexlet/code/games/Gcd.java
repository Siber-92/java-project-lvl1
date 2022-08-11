package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

import java.util.HashMap;

public class Gcd {
    private static final String RULES = "Find the greatest common divisor of given numbers.";

    public static HashMap<String, String> getGameData() {
        HashMap<String, String> gameData = new HashMap<>();

        int firstOperand = Utilities.getRandomNumber();
        int secondOperand = Utilities.getRandomNumber();
        int leastOperand = Math.min(firstOperand, secondOperand);

        while (leastOperand > 0) {
            if (firstOperand % leastOperand == 0 && secondOperand % leastOperand == 0) {
                break;
            }
            leastOperand--;
        }

        gameData.put("question", firstOperand + " " + secondOperand);
        gameData.put("correctAnswer", String.valueOf(leastOperand));

        return gameData;
    }

    public static void startGame() {
        Engine.printGreet(RULES);
        Engine.gameLoop();
    }
}
