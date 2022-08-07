package hexlet.code;

import static java.lang.System.out;

public class Even {
    public static void printRulesOfGames() {
        out.println("Answer 'yes' if number even otherwise 'no'");
    }

    public static int getRequiredNumberOfRightAnswers() {
        // The number is determined by the conditions of the game
        return 3;
    }

    public static int generateNumber() {
        return (int) (Math.random() * 100);
    }

    public static boolean checkAnswer(String playerAnswer, int number) {
        String rightAnswer = number % 2 == 0 ? "yes" : "no";

        return playerAnswer.equals(rightAnswer);
    }

    public static boolean checkCountOfRightAnswers() {
        String answer;
        int number;
        int countOfRightAnswer = 0;

        for (int i = 0; i < getRequiredNumberOfRightAnswers(); i++) {
            number = generateNumber();
            out.println("Question: " + number);
            out.print("Your answer: ");
            answer = Cli.getPlayerInput();

            if (checkAnswer(answer, number)) {
                out.println("Correct!");
                countOfRightAnswer++;
            } else {
                out.println("'" + answer + "' is wrong answer ;(. Correct answer was 'no'");
                break;
            }
        }
        return countOfRightAnswer == getRequiredNumberOfRightAnswers();
    }

    public static void startGame() {
        Cli.printGreet();
        printRulesOfGames();
        Cli.printGameResult(checkCountOfRightAnswers());
    }
}
