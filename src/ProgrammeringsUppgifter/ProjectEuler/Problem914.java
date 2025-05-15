package ProgrammeringsUppgifter.ProjectEuler;

import java.util.Scanner;

/**
 * <a href="https://projecteuler.net/problem=914">Problem 914 på projecteuler.net</a>
 */
public class Problem914 {
    private final Scanner scanner = new Scanner(System.in);

    public Problem914() {
        long a = 1; // Fibonacci(1)
        long b = 1; // Fibonacci(2)

        for (long i = 0; i < 50; i++) {
            a += b;
            b += a;
        }
        System.out.println("100th fibonacci number: " + b);
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
