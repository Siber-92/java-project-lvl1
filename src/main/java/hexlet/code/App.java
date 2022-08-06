package hexlet.code;

public class App {
    public static void main(String[] args) {
        System.out.print("Welcome to the Brain Games!" + "\nMay I have your name? ");

        String playerName = Cli.getPlayerInput();

        System.out.println("Hello, " + playerName + "!");
    }
}
