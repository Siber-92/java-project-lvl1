package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utilities;

public class Even {
    private static final String RULES = "Answer 'yes' if number even otherwise 'no'";
    private static String gameQuest;
    private static String correctAnswer;

    private static void generateGameData() {
        int operand = Utilities.getRandomNumber();

        correctAnswer = operand % 2 == 0 ? "yes" : "no";
        gameQuest = String.valueOf(operand);
    }

    public static void startGame() {
        Engine.printGreet(RULES);

        boolean quizResult;
        int countOfRightAnswer = 0;
        do {
            generateGameData();
            quizResult = Engine.checkQuizResult(gameQuest, correctAnswer);
            countOfRightAnswer++;
        } while (quizResult && countOfRightAnswer != Utilities.MAX_NUMBER_OF_ROUND);

        Engine.printGameResult(quizResult);
    }
}
