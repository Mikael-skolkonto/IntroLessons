package ProgrammeringsUppgifter.ProjectEuler;

import java.util.Scanner;

/**<a href="https://projecteuler.net/problem=10">Problem 10 på projecteuler.net</a>
 * Problem statement is "Find the sum of all primes below 2 million." but this class
 * can take in any positive integer.
 */
public class Problem10 {

    public Problem10() {
        int primeCeiling = getInput();
        boolean[] primes = new boolean[primeCeiling];
        for (int i = 0; i < primeCeiling; i++) {

        }
    }

    private int getInput() {
        Scanner scanner = new Scanner(System.in);
        int input;
        //Take in value and redo if the value is negative or 0
        do {
            System.out.println("Set a ceiling, greater than 0, on the primes summed: ");
            input = scanner.nextInt();
        } while (input < 1);
        scanner.close();
        return input;
    }
}
