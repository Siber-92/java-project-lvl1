package hexlet.code;

public class Utilities {
    private static final int LOWER_BOUND = 5;
    private static final int HIGHER_BOUND = 25 + LOWER_BOUND;

    public static int getRandomNumber() {
        return LOWER_BOUND + (int) (Math.random() * HIGHER_BOUND);
    }
    public static int getRandomNumber(int higherBound) {
        higherBound = higherBound - LOWER_BOUND;
        return LOWER_BOUND + (int) (Math.random() * higherBound);
    }
}
