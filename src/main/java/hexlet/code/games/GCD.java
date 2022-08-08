package hexlet.code.games;

public class GCD {
    public static void printRulesOfGames() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public static String getCorrectAnswer(int firstOperand, int secondOperand) {
        firstOperand = Math.abs(firstOperand);
        secondOperand = Math.abs(secondOperand);

        int leastOperand = Math.min(firstOperand, secondOperand);

        while (leastOperand > 0) {
            if (firstOperand % leastOperand == 0 && secondOperand % leastOperand == 0) {
                break;
            }
            leastOperand--;
        }
        return String.valueOf(leastOperand);
    }

    public static String generateGameQuest(int firstOperand, int secondOperand) {
        firstOperand = Math.abs(firstOperand);
        secondOperand = Math.abs(secondOperand);

        return firstOperand + " " + secondOperand;
    }
}
