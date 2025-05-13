package ProgrammeringsUppgifter.ProjectEuler;

// Detta problemet är första uppgiften på A-nivå.

import java.util.Scanner;

/**
 * <a href="https://projecteuler.net/problem=1">Problem 1 på projecteuler.net</a>
 */
public class Problem1 {
    private final Scanner scanner = new Scanner(System.in);

    public Problem1() {
        final int ceiling = getInput("Set a ceiling (inclusive), greater than 0, on the numbers counted: ");
        final int divisor1 = getInput("Enter the first divisor that should be a predicate for which numbers are summed: ");
        final int divisor2 = getInput("Enter the second divisor that should be a predicate for which numbers are summed: ");

        final int n = ceiling / divisor1; // Antal tal delbara med divisor1
        final int m = ceiling / divisor2; // Antal tal delbara med divisor2

        final int commonMultiple = lcm(divisor1,divisor2);
        final int k = ceiling / commonMultiple; // Antal tal delbara med både divisor1 och divisor2

        final int partial_sum1 = sum(n,divisor1);
        final int partial_sum2 = sum(m,divisor2);
        final int partial_sum3 = sum(k,commonMultiple);
        final int total = partial_sum1 + partial_sum2 - partial_sum3; //Enligt inklusions-exklusions-principen
        System.out.printf("Sum between 1 and %d of numbers divisible by %d and %d: %d",
                                        ceiling,                divisor1,divisor2, total);
        scanner.close();
    }

    /**
     * Sum of arithmetic series where difference is .
     * n integers starting from a0 and difference between adjacent terms in the series equal a0.
     * @param n number of terms in the series
     * @param a0 the initial term
     * @return sum of n terms in arithmetic series where difference between terms equals a0.
     */
    private int sum(int n, int a0) {
        return ((n++ * n) >>> 1) * a0; //Hard-rightshift saves the highest-order bit from overflow
    }

    /**
     * Simple lcm() using gcd()
     * @param a int 1
     * @param b int 2
     * @return lowest common multiple
     */
    private int lcm(int a, int b) {
        return a*b / gcd(a,b);
    }

    /**
     * Implementation of Euclid's gcd() algorithm.
     * @param a int 1
     * @param b int 2
     * @return greatest common multiple
     */
    private int gcd(int a, int b) {
        int temp;
        while (b > 0) {
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
