package hexlet.code.games;

public class Progression {
    private static int[] numbers;
    private static int indexOfHiddenElement;

    public static void printRulesOfGames() {
        System.out.println("What number is missing in the progression?");
    }

    public static void generateProgression(int firstProgressionValue, int stepOfProgression) {
        int lowerBound = 5;
        int progressionSize = lowerBound + (int) (Math.random() * lowerBound);
        indexOfHiddenElement = (int) (Math.random() * progressionSize);

        numbers = new int[progressionSize];
        numbers[0] = firstProgressionValue;
        for (int i = 1; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + stepOfProgression;
        }
    }

    public static String getCorrectAnswer(int firstOperand, int secondOperand) {
        generateProgression(firstOperand, secondOperand);

        return String.valueOf(numbers[indexOfHiddenElement]);
    }

    public static String generateGameQuest() {
        String[] convertArray = new String[numbers.length];
        StringBuilder question = new StringBuilder();

        for (int i = 0; i < numbers.length; i++) {
            convertArray[i] = i != indexOfHiddenElement ? String.valueOf(numbers[i]) : "..";
            question.append(convertArray[i]).append(" ");
        }
        return question.toString();
    }
}
