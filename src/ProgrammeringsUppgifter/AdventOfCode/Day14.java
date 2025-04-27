package ProgrammeringsUppgifter.AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Problem statement: <a href="https://adventofcode.com/2024/day/14">Day 14 AoC 2024</a>
 */
public class Day14 {

    public static void robotSafetyFactor() {
        Scanner sc = day14Scanner();

        Pattern botDataFormat = Pattern.compile("p=(?<x>-?\\d+),(?<y>-?\\d+) v=(?<vx>-?\\d+),(?<vy>-?\\d+)");

        //x y vx vy
        Stream.Builder<int[]> streamBuilder = Stream.builder();
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            java.util.regex.Matcher matcher = botDataFormat.matcher(str);

            matcher.find();
            //OMG JAVA FÖFAN; JAG HÖLL PÅ HELA DAGEN
            //OCH ALLT JAG BEHÖVDE GÖRA VAR ATT ANROPA .find() FÖR DET SAKNAS I Pattern.matcher(String) !?

            streamBuilder.add(new int[] {Integer.parseInt(matcher.group("x"))
                    ,Integer.parseInt(matcher.group("y"))
                    ,Integer.parseInt(matcher.group("vx"))
                    ,Integer.parseInt(matcher.group("vy"))});
        }
        Stream<int[]> botData = streamBuilder.build();
        // TODO: 2025-04-28 VARFÖR GER DEN RESULTATET safetyFactor = 1 ??
        //Converts stream of coordinates and velocities (botData) to stream of quadrants' added safetyFactor
        int[][] quadrants = botData.map(Day14::stepHundredSec).toArray(int[][]::new);
        int safetyFactor = Arrays.stream(quadrants[0]).sum() * Arrays.stream(quadrants[1]).sum()
                * Arrays.stream(quadrants[2]).sum() * Arrays.stream(quadrants[3]).sum();
        System.out.println("Safety factor: " + safetyFactor);
    }

    /**One hundred time steps in unit seconds
     * @param botData should be with format [x, y, vx, vy] and x between 0 and 100 and y between 0 and 102
     * @return the four quadrant's number of bots, aka just 1 at any position in the array or just 0's if the bot is in between quadrants
     */
    private static int[] stepHundredSec(int[] botData) {
        botData[0] = (botData[0] - botData[2]) % 101;
        botData[1] = (botData[1] - (botData[3] << 1) - botData[3]) % 103;

        if (botData[0] == 50 || botData[1] == 51) {
            //in between quadrants
            botData[0] = botData[1] = botData[2] = botData[3] = 0;
            return botData;
        }

        int quadrant = 0;

        if (botData[1] > 51)
            quadrant += 2;
        if (botData[0] > 50)
            quadrant += 1;

        botData[0] = botData[1] = botData[2] = botData[3] = 0;
        botData[quadrant] = 1;
        return botData;
    }

    private static Scanner day14Scanner() {

        try {
            return new Scanner(new File("InputFiles/Day14.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return new Scanner("file not found");
    }
}
