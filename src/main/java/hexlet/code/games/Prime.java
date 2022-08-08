package hexlet.code.games;

public class Prime {
    public static void printRulesOfGames() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise 'no'");
    }

    public static String getCorrectAnswer(int number) {
        String answer = "yes";

        for (int i = number / 2; i > 1; i--) {
            if (number % i == 0) {
                answer = "no";
                break;
            }
        }
        return answer;
    }

    public static String generateGameQuest(int number) {
        return String.valueOf(number);
    }
}
