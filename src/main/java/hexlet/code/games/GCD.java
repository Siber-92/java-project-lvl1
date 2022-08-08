package hexlet.code.games;

public class GCD {
    public static void printRulesOfGames() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public static String getCorrectAnswer(int firstOperand, int secondOperand) {
        firstOperand = Math.abs(firstOperand);
        secondOperand = Math.abs(secondOperand);

        int greatestOperand = Math.max(firstOperand, secondOperand);
        int leastOperand = Math.min(firstOperand, secondOperand);

        if (greatestOperand % leastOperand == 0) {
            return String.valueOf(leastOperand);
        }

        int firstDivisor = 1;
        int secondDivisor = 1;
        int divisorOfBothOperand = 1;

        for (int i = 2; i <= firstOperand / 2; i++) {
            firstDivisor = firstOperand % i == 0 ? i : firstDivisor;
            for (int j = 2; j <= secondOperand / 2; j++) {
                secondDivisor = secondOperand % j == 0 ? j : secondDivisor;
                divisorOfBothOperand = firstDivisor == secondDivisor ? firstDivisor : divisorOfBothOperand;
            }
        }

        return String.valueOf(divisorOfBothOperand);
    }

    public static String generateGameQuest(int firstOperand, int secondOperand) {
        firstOperand = Math.abs(firstOperand);
        secondOperand = Math.abs(secondOperand);

        return firstOperand + " " + secondOperand;
    }
}
