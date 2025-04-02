package ProgrammeringsUppgifter.ProgrammeringsOlympiaden;

import java.util.Scanner;

/**<a href="https://po.kattis.com/problems/lavapaddling">Lavapaddlings-uppgiften</a>
 */
//Lav ska bara till sista ön i serien inte som det står att han ska tillbaka
public class Lavapaddling {

    private byte numberOfIslands;
    //Spann: 1<=N<=20
    private byte metersPerPaddle;
    //Spann: 1<=K<=15
    private long metersPerHexmeter;
    //Spann: 1<=H<=10^12
    private short[] hexmetersBetweenIslands;
    //Spann: 1<=d_i<=1000

    private void setConstants() {
        Scanner scanner = new Scanner(System.in);
        numberOfIslands = scanner.nextByte();
        metersPerPaddle = scanner.nextByte();
        metersPerHexmeter = scanner.nextLong();
        hexmetersBetweenIslands = new short[numberOfIslands - 1];
        for (int i = 0; i < hexmetersBetweenIslands.length; i++) {
            hexmetersBetweenIslands[i] = scanner.nextShort();
        }
    }

    public Lavapaddling() {
        setConstants();
        long paddles = 0;
        for (byte i = 0; i < hexmetersBetweenIslands.length; i++) {
            long next = paddlesNeeded(i);
            if (next > paddles) {
                paddles = next;
            }
        }

    }

    private long paddlesNeeded(byte index) {
        long distance = metersPerHexmeter * hexmetersBetweenIslands[index];
        long paddles = distance / metersPerPaddle;
        paddles += distance % metersPerPaddle == 0 ? 0 : 1;
        return paddles;
    }
}
