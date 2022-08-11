package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

import java.util.HashMap;

public class Even {
    private static final String RULES = "Answer 'yes' if number even otherwise 'no'";

    public static HashMap<String, String> getGameData() {
        HashMap<String, String> gameData = new HashMap<>();
        int operand = Utilities.getRandomNumber();

        gameData.put("question", String.valueOf(operand));
        gameData.put("correctAnswer", operand % 2 == 0 ? "yes" : "no");

        return gameData;
    }

    public static void startGame() {
        Engine.printGreet(RULES);
        Engine.gameLoop();
    }
}
