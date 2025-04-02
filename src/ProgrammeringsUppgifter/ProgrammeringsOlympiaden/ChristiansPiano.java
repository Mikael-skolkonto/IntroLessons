package ProgrammeringsUppgifter.ProgrammeringsOlympiaden;

import java.util.ArrayList;
import java.util.Scanner;

/**<a href="https://po2punkt0.kattis.com/problems/pianot">Christian's Piano-uppgiften</a>
 * Eftersom den har "svår" svårighetsgrad så har jag passat på denna tills vidare.
 */
public class ChristiansPiano {
    char[] musicPiece = getInput();
    char[] keyLayout = getKeys(musicPiece);

    private char[] getKeys(char[] musicPiece) {
        ArrayList<Character> keys = new ArrayList<>(1);
        for (int i = 0; i < musicPiece.length; i++) {
            for (Character c : keys) {
                c.toString().equals(musicPiece[i]);
            }
        }
        //TODO finish this method
        return new char[]{};
    }

    private char[] getInput() {
        Scanner scanner = new Scanner(System.in);
        char[] list = scanner.next().toCharArray();
        scanner.close();
        return list;
    }
}