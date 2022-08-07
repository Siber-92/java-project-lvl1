package hexlet.code;

import java.util.Scanner;

import static java.lang.System.out;

public class Cli {
    //FIXME fix return type
    public static String getPlayerInput() {
        Scanner playerName = new Scanner(System.in);

        return playerName.next();
    }
}
