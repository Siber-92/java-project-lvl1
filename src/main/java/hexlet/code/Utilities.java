package hexlet.code;

public class Utilities {
    public static final int MAX_NUMBER_OF_ROUND = 3;
    private static final int LOWER_BOUND = 5;
    private static final int MULTIPLIER = 25; // LOWER_BOUND + MULTIPLIER == higherBound

    public static int getRandomNumber() {
        return LOWER_BOUND + (int) (Math.random() * MULTIPLIER);
    }
}
