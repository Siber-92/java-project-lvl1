package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

public class Even {
    private static final String RULES = "Answer 'yes' if number even otherwise 'no'";

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[Engine.MAX_NUMBER_OF_ROUND][Engine.ROUND_DATA_INDEX];

        for (int i = 0; i < Engine.MAX_NUMBER_OF_ROUND; i++) {
            int number = Utilities.getRandomNumber();

            questionAndAnswer[i][Engine.QUESTION_INDEX] = String.valueOf(number);
            questionAndAnswer[i][Engine.CORRECT_ANSWER_INDEX] = number % 2 == 0 ? "yes" : "no";
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.gameLoop(RULES, generateGameData());
    }
}
