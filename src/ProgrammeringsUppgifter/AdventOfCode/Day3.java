package ProgrammeringsUppgifter.AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

/**
 * Problem statement: <a href="https://adventofcode.com/2024/day/3">Day 3 of AoC 2024</a>
 */
public class Day3 {

    public static void sumAllMultiplications() {
        Scanner sc = day3Scanner();
        long sum = sc.findAll(Pattern.compile("mul\\((?<num1>\\d+),(?<num2>\\d+)\\)"))
                .mapToLong(e -> Long.parseLong(e.group(1)) * Long.parseLong(e.group(2))).sum();
        System.out.println("Total: " + sum);
    }

    public static void sumSomeMultiplications() {
        Scanner sc = day3Scanner();
        long sum = sc.findAll(Pattern.compile("(mul\\((?<num1>\\d+),(?<num2>\\d+)\\))|(do\\(\\))|(don't\\(\\))"))
                .mapToLong(Day3::readInstruction).sum();
        System.out.println("Total: " + sum);
    }

    private static boolean isExecuting = true;

    private static long readInstruction(MatchResult e) {
        if (e.group(1) == null) {
            isExecuting = e.group(4) != null;   //IntelliJ suggested simplification (if instruction is do() then group(4) isn't null)
        } else {
            if (isExecuting) {
                return Long.parseLong(e.group(2) ) * Long.parseLong(e.group(3));
            }
        }
        return 0L;
    }
    private static Scanner day3Scanner() {
        try {
            return new Scanner(new File("InputFiles/Day3.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Scanner("file not found");
    }
}
