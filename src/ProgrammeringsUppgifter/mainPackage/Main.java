package ProgrammeringsUppgifter.mainPackage;

import ProgrammeringsUppgifter.PokerProv;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] chanser = PokerProv.chanser();
        System.out.printf("stege: %f\ntvåpar: %f\npar: %f\nfyrtal: %f\ntretal: %f\nkåk: %f",
                chanser[0],chanser[1],chanser[2],chanser[3],chanser[4],chanser[5]);
    }
}