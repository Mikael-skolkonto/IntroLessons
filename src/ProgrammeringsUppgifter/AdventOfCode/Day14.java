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

        // TODO: 2025-04-28 VARFÖR ÄR RESULTATET "Safety factor: 97941888" FÖR LÅGT??
        //Converts stream of coordinates and velocities (botData) to stream of quadrants' added safetyFactor
        int[][] quadrants = botData.map(Day14::stepHundredSec).toArray(int[][]::new);

        int safetyFactor = quadrantSum(quadrants,0) * quadrantSum(quadrants,1)
                * quadrantSum(quadrants,2) * quadrantSum(quadrants,3);
        System.out.println("Safety factor: " + safetyFactor);
    }

    /**
     * Sums the bots in the given quadrant
     * @param quadrants The table of bot positions, each array containing all zeroes except for a 1 for the quadrant it's in.
     * @param quadrantOrdinal The index that should be summed across all arrays contained in the table.
     * @return The sum of all entries with the second index given.
     */
    private static int quadrantSum(int[][] quadrants, int quadrantOrdinal) {
        int sum = 0;
        for (int i = 0; i < quadrants.length; i++) {
            sum += quadrants[i][quadrantOrdinal];
        }
        return sum;
    }

    /**One hundred time steps in unit seconds
     * @param botData should be with format [x, y, vx, vy] and x between 0 and 100 and y between 0 and 102
     * @return the four quadrant's number of bots, aka just 1 at any position in the array or just 0's if the bot is in between quadrants
     */
    private static int[] stepHundredSec(int[] botData) {
        botData[0] = (botData[0] - botData[2]) % 101;
        botData[1] = (botData[1] - (botData[3] << 1) - botData[3]) % 103;

        if (botData[0] < 0)
            botData[0] += 101;
        if (botData[1] < 0)
            botData[1] += 103;

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

    /**
     * Returns the time when the bots (presumably) forms a picture of a Christmas tree.
     * This will be done by checking for 10 consecutive non-empty tiles.
     */
    public static void robotTree() {

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
