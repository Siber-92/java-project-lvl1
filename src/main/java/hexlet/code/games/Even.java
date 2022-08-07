package hexlet.code.games;

import static java.lang.System.out;

public class Even {
    public static void printRulesOfGames() {
        out.println("Answer 'yes' if number even otherwise 'no'");
    }

    public static String getCorrectAnswer(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    public static String generateGameQuest(int number) {
        return String.valueOf(number);
    }
}
