package hexlet.code;

import static java.lang.Math.random;

public class Utilities {
    private static final int LOWER_BOUND = -3;
    private static final int HIGHER_BOUND = 50;

    public static int getRandomNumber() {
        return LOWER_BOUND + (int) (random() * (HIGHER_BOUND - LOWER_BOUND));
    }

    public static int getRandomNumber(int higherBound) {
        return (int) (random() * higherBound);
    }

    public static int getRandomNumber(int lowerBound, int higherBound) {
        return lowerBound + (int) (random() * (higherBound - lowerBound));
    }
}
