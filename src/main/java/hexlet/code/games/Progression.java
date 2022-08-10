package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.Utilities;

public class Progression {
    private static String gameQuest;
    private static String correctAnswer;

    public static void printRulesOfGame() {
        System.out.println("What number is missing in the progression?");
    }

    public static void generateGameData() {
        int firstProgressionValue = Utilities.getRandomNumber();
        int stepOfProgression = Utilities.getRandomNumber();
        int progressionSize = Utilities.getRandomNumber();
        int[] numbers = new int[progressionSize];
        int indexOfHiddenElement = (int) (Math.random() * progressionSize);

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
        correctAnswer = String.valueOf(numbers[indexOfHiddenElement]);
        gameQuest = question.toString();
    }

    public static void startGame() {
        Cli.printGreet();
        printRulesOfGame();

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
