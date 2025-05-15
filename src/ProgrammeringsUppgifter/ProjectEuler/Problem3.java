package ProgrammeringsUppgifter.ProjectEuler;

// Detta problemet är andra uppgiften på A-nivå.

import java.util.Scanner;

/**
 * <a href="https://projecteuler.net/problem=3">Problem 3 på projecteuler.net</a>
 */
public class Problem3 {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Finds the largest prime factor of a user-input long number
     */
    public Problem3() {
        long bigNum = getInput("Input the number to find the largest prime of: ");

        long factor = 2;
        while (factor * factor <= bigNum) {
            if (bigNum % factor == 0) {
                bigNum /= factor;
            } else factor++;
        }

        System.out.println("Largest prime factor is: " + bigNum);
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