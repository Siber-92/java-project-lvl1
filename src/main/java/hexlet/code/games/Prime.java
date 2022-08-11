package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

import java.util.HashMap;

public class Prime {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise 'no'";

    public static HashMap<String, String> getGameData() {
        int operand = Utilities.getRandomNumber();
        HashMap<String, String> gameData = new HashMap<>();

        String correctAnswer = "yes";
        for (int i = operand / 2; i > 1; i--) {
            if (operand % i == 0) {
                correctAnswer = "no";
                break;
            }
        }

        gameData.put("question", String.valueOf(operand));
        gameData.put("correctAnswer", correctAnswer);

        return gameData;
    }

    public static void startGame() {
        Engine.printGreet(RULES);
        Engine.gameLoop();
    }
}
