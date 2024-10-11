package ProgrammeringsUppgifter;

import java.util.Random;
import java.util.Scanner;

public class KastaDice {

    public KastaDice() {
        boolean villSpela;
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int kassa = 100;
        do {
            System.out.println("Kastar tärningarna...");
            int dice1 = random.nextInt(6) + 1;
            int dice2 = random.nextInt(6) + 1;
            System.out.printf("Det blev %d och %d%n", dice1, dice2);

            if (dice1 == dice2) {
                kassa += dice1<<1;
            } else {
                kassa -= dice1 + dice2;
            }
            System.out.println("Du har nu " + kassa + " kr. \nVill du spela mer?");
            villSpela = villDuSpela(sc);

        } while (villSpela);
    }

    private boolean villDuSpela(Scanner sc) {
        String villSpela = sc.next();
        while (!(villSpela.equals("ja") || villSpela.equals("nej"))) {
            System.out.println("Jag förstår inte, försök igen. (ja/nej)");
            villSpela = sc.next();
        }
        return villSpela.equals("ja");
    }
}
