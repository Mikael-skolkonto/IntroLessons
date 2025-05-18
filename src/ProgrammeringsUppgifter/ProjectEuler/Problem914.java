package ProgrammeringsUppgifter.ProjectEuler;

import java.util.Scanner;

/**
 * <a href="https://projecteuler.net/problem=914">Problem 914 på projecteuler.net</a>
 */
public class Problem914 {
    private final Scanner scanner = new Scanner(System.in);

    public Problem914() {
        long U;
        long V;
        long inradius = 0;

        // Om U och V är relativt prima, sådant att U > V och U + V = 1 (mod 2)
        // Så bildar sidor av längder U*U-V*V och 2*U*V och U*U+V*V en primitiv pythagoreisk trippel
        // Med incirkeln av radien (U-V)*V

        // OH BABY A TRIPLE!

        // Enligt randvinkelsatsen så ligger räta vinkeln av triangeln på cirkumcirkelns rand,
        // alltså krävs det bara att hypotenusan är kortare än diametern 2*R.

        long radius = getInput("Radius = ");
        V = (long) Math.sqrt(radius);
        for (; V > 0; V--) {

            long max = radius / V;
            U = ((V+max) % 2 == 0) ? max-1 : max;
            for (; U > V; U -= 2) {
                if (gcd(U,V) != 1L || U*U+V*V >= (radius << 1)) continue;
                if (inradius < (U - V) * V) {
                    inradius = (U - V) * V;
                    System.out.printf("Inradius: %d, U = %d, V = %d, c = %d%n",inradius,U,V,(U*U+V*V));
                    break;
                }
            }
        }

        System.out.println("Largest inradius: " + inradius);
    }

    private long gcd(long a, long b) {
        long temp;
        while (b > 0L) {
            temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    /**
     * Returns a number greater than 1, throws exception if input other than integer.
     * @param query An explanation of what argument the user should enter in.
     * @return Number greater than 0.
     */
    private long getInput(String query) {
        long input;
        //Take in value and redo if the value is negative or 0
        do {
            System.out.print(query);
            input = scanner.nextLong();
        } while (input < 1L);
        return input;
    }
}
