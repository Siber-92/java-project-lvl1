package hexlet.code.games;

import static java.lang.System.out;

// Greatest Common Divisor
public class GCD {
    //    Step 1: Find the divisors of positive integer "a".
//    Step 2: Find the divisors of positive integer "b".
//    Step 3: Lis the divisors common to "a" and "b".
//    Step 4: Find the divisor which is the highest of all the common divisors of both "a" and "b".
//Find the greatest common divisor of given numbers.
    public static void printRulesOfGames() {
        out.println("Find the greatest common divisor of given numbers.");
    }

    public static String getCorrectAnswer(int firstOperand, int secondOperand) {
        firstOperand = Math.abs(firstOperand);
        secondOperand = Math.abs(secondOperand);

        int greatestOperand = firstOperand > secondOperand ? firstOperand : secondOperand;
        int leastOperand = firstOperand < secondOperand ? firstOperand : secondOperand;

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
