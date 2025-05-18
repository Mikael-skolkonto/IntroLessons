package ProgrammeringsUppgifter.ProjectEuler;

import java.util.Scanner;

/**
 * <a href="https://projecteuler.net/problem=914">Problem 914 på projecteuler.net</a>
 */
public class Problem914 {
    private final Scanner scanner = new Scanner(System.in);

    public Problem914() {
        long U = 2;
        long V = 1;
        // Om U och V är relativt prima, sådant att U > V och U + V = 1 (mod 2)
        // Så bildar sidor av längder U*U-V*V och 2*U*V och U*U+V*V en primitiv pythagoreisk trippel
        // Med incirkeln av radien (U-V)*V

        // OH BABY A TRIPLE!

        // Enligt randvinkelsatsen så ligger räta vinkeln av triangeln på cirkumcirkelns rand,
        // alltså krävs det bara att hypotenusan är kortare än diametern 2*R.
    }

    /**
     * Returns a number greater than 1, throws exception if input other than integer.
     * @param query An explanation of what argument the user should enter in.
     * @return Number greater than 0.
     */
    private int getInput(String query) {
        int input;
        //Take in value and redo if the value is negative or 0
        do {
            System.out.print(query);
            input = scanner.nextInt();
        } while (input < 1);
        return input;
    }
}
