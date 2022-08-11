package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

import java.util.HashMap;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";

    public static HashMap<String, String> getGameData() {
        int firstProgressionValue = Utilities.getRandomNumber();
        int stepOfProgression = Utilities.getRandomNumber();
        int progressionSize = Utilities.getRandomNumber();
        int[] numbers = new int[progressionSize];
        int indexOfHiddenElement = (int) (Math.random() * progressionSize);
        HashMap<String, String> gameData = new HashMap<>();

        numbers[0] = firstProgressionValue;
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + stepOfProgression;
        }

        String[] convertedArray = new String[numbers.length];
        StringBuilder question = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            convertedArray[i] = i != indexOfHiddenElement ? String.valueOf(numbers[i]) : "..";
            question.append(convertedArray[i]).append(" ");
        }

        gameData.put("question", question.toString());
        gameData.put("correctAnswer", String.valueOf(numbers[indexOfHiddenElement]));

        return gameData;
    }

    public static void startGame() {
        Engine.printGreet(RULES);
        Engine.gameLoop();
    }
}
