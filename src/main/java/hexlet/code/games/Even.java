package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

import static hexlet.code.Engine.NUMBER_OF_ROUND_DATA;
import static hexlet.code.Engine.QUESTION_INDEX;
import static hexlet.code.Engine.CORRECT_ANSWER_INDEX;
import static hexlet.code.Engine.MAX_NUMBER_OF_ROUND;

public class Even {
    private static final String RULES = "Answer 'yes' if number even otherwise 'no'";

    private static String[][] generateGameData() {
        String[][] questionAndAnswer = new String[MAX_NUMBER_OF_ROUND][NUMBER_OF_ROUND_DATA];

        for (int i = 0; i < MAX_NUMBER_OF_ROUND; i++) {
            int number = Utilities.getRandomNumber();

            questionAndAnswer[i][QUESTION_INDEX] = String.valueOf(number);
            questionAndAnswer[i][CORRECT_ANSWER_INDEX] = number % 2 == 0 ? "yes" : "no";
        }
        return questionAndAnswer;
    }

    public static void startGame() {
        Engine.gameLoop(RULES, generateGameData());
    }
}
