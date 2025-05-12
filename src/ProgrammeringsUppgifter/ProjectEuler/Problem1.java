package ProgrammeringsUppgifter.ProjectEuler;

// Detta problemet är första uppgiften på A-nivå.

import java.util.Scanner;

/**
 * <a href="https://projecteuler.net/problem=1">Problem 1 på projecteuler.net</a>
 */
public class Problem1 {

    public Problem1() {
        int ceiling = getInput("Set a ceiling (inclusive), greater than 0, on the numbers counted: ");
        int divisor1 = getInput("Enter the first divisor that should be a predicate for which numbers are summed: ");
        int divisor2 = getInput("Enter the second divisor that should be a predicate for which numbers are summed: ");

        int n = ceiling / divisor1;
        int m = ceiling / divisor2;
        int i = divisor1 > divisor2 ? m/divisor1 : n/divisor2;
        // TODO: 2025-05-13 Review the formula in desmos, I think it doesn't scale correctly in the general case.

    }

    /**
     * Returns a number greater than 1, throws exception if input other than integer.
     * @param query An explanation of what argument the user should enter in.
     * @return Number greater than 0.
     */
    private int getInput(String query) {
        Scanner scanner = new Scanner(System.in);
        int input;
        //Take in value and redo if the value is negative or 0
        do {
            System.out.println(query);
            input = scanner.nextInt();
        } while (input < 1);
        scanner.close();
        return input;
    }
}
