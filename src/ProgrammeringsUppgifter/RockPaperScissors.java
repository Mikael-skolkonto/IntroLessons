package ProgrammeringsUppgifter;

import java.util.Random;
import java.util.Scanner;

/**Flödesschema på Lucidchart <a href="https://lucid.app/lucidchart/995ec0cb-766d-4b41-b9d5-ac1cf1389e02/edit?invitationId=inv_e6fc4dd3-62cc-421c-83fb-cda638e3604d">...</a>
 *Uppgiftsbeskrivning <a href="https://karlsson.app/page/uppgifter.php?url=7073-flodesdiagram">...</a>
 */
public class RockPaperScissors {
    public RockPaperScissors() {
        Random randNumGenerator = new Random();
        Scanner scanner = new Scanner(System.in);

        int bot_decision = randNumGenerator.nextInt(3);

        System.out.print("Select rock (1), paper (2) or scissors (3): ");

        int user_decision = scanner.nextInt() - 1;
        while (user_decision > 2 || user_decision < 0) {
            System.out.println("Incorrect number, please pick a number between 1 and 3.");
            user_decision = scanner.nextInt() - 1;
        }
        scanner.close();

        if (bot_decision == 2) {
            System.out.println("I picked scissors.");
        } else if (bot_decision == 1) {
            System.out.println("I picked paper.");
        } else {
            System.out.println("I picked rock.");
        }

        switch (bot_decision - user_decision) {
            case -2, 1 -> System.out.println("You lost!");
            case -1, 2 -> System.out.println("I lost!");
            case 0 -> System.out.println("It's a draw!");
        }
    }
}
