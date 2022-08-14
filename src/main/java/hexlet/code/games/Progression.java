package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

import static hexlet.code.Engine.NUMBER_OF_ROUND_DATA;
import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.CORRECT_ANSWER_INDEX;
import static hexlet.code.Engine.MAX_NUMBER_OF_ROUND;

public class Progression {
    private static final String RULES = "What number is missing in the progression?";
    private static final int HIGHER_BOUND = 15;
    private static final int LOWER_BOUND = 5;

    private static int[] generateProgression() {
        int firstElement = Utilities.getRandomNumber();
        int stepOfProgression = Utilities.getRandomNumber();
        int progressionSize = Utilities.getRandomNumber(LOWER_BOUND, HIGHER_BOUND);

        int[] numbers = new int[progressionSize];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i == 0 ? firstElement : numbers[i - 1] + stepOfProgression;
        }
        return numbers;
    }

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[MAX_NUMBER_OF_ROUND][NUMBER_OF_ROUND_DATA];

        for (int i = 0; i < MAX_NUMBER_OF_ROUND; i++) {
            int[] progression = generateProgression();
            int hiddenElement = Utilities.getRandomNumber(progression.length);

            StringBuilder question = new StringBuilder();

            for (int element = 0; element < progression.length; element++) {
                question.append(element == hiddenElement ? ".." : progression[element]).append(" ");
            }
            questionAndAnswer[i][QUESTION_INDEX] = question.toString();
            questionAndAnswer[i][CORRECT_ANSWER_INDEX] = String.valueOf(progression[hiddenElement]);
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.gameLoop(RULES, generateGameData());
    }
}
