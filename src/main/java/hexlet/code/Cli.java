package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String getPlayerInput() {
        Scanner playerInput = new Scanner(System.in);

        return playerInput.next();
    }
}
