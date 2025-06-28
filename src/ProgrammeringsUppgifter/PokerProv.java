package ProgrammeringsUppgifter;

/*
 Uppgifskrav:

 Metoder:
 boolean är_stege(int[])
 boolean är_tvåpar(int[])
 boolean är_par(int[])
 boolean är_fyrtal(int[])
 boolean är_tretal(int[])
 boolean är_kåk(int[])
 boolean har_kort(int,int[])

 Returnerar:
 chansen att en hand på 5 kort är något av ovanstående i ordingen ovan
 (1 sortering per hand, 1000 oberoende händer)
 */

import java.util.Arrays;
import java.util.Random;

public class PokerProv {

    private static final Random generator = new Random();

    /**
     * Expected return value is approximately 30, since that is the mean
     * value of minimal sum (1) and maximal sum (59)
     * @return the mean sum of a random hand of cards
     */
    public static double testCardDistribution() {
        int[] hand = new int[5];
        int sum = 0;
        for (int i = 0; i < 25000; i++) {
            plockaFem(hand);
            sum += Arrays.stream(hand).sum();
        }
        return sum / 25000.0;
    }

    /**
     * Prov-uppgiften i en metod, slumpar 1 miljon händer och räknar olika sannolikheter.
     * @return lista med chanserna att få: stege [0], tvåpar [1], par [2], fyrtal [3], tretal [4], kåk [5]
     */
    public static double[] chanser() {
        int[] hand = new int[5];
        double[] sannolikheter = {0.0,0.0,0.0,0.0,0.0,0.0};

        for (int i = 0; i < 1000000; i++) {
            plockaFem(hand);
            if (är_tvåpar(hand)) sannolikheter[1]++;
            else if (är_par(hand)) sannolikheter[2]++;
            else if (är_kåk(hand)) sannolikheter[5]++;
            else if (är_tretal(hand)) sannolikheter[4]++;
            else if (är_stege(hand)) sannolikheter[0]++;
            else if (är_fyrtal(hand)) sannolikheter[3]++;
        }

        return Arrays.stream(sannolikheter).map(e -> e/1000000).toArray();
    }

    /**
     * Returnerar {@code true} om handen innehåller två par.
     * @param hand lista med 5 tal
     * @return sant endast om listan har 2 grupper med 2 likadana tal
     */
    private static boolean är_tvåpar(int[] hand) {
        boolean förra = false;
        short antalPar = 0;
        for (int i = 0; i < 4; i++) {
            if (hand[i] == hand[i+1]) {
                //tre av samma -> räknas inte som 2 par
                if (förra) return false;
                //annars fortsätt
                förra = true;
                antalPar++;
            } else {
                förra = false;
            }
        }

        return antalPar == 2;
    }

    /**
     * Returnerar {@code true} om handen innehåller ett par.
     * @param hand lista med 5 tal
     * @return sant om listan har endast 2 likadana tal
     */
    private static boolean är_par(int[] hand) {
        boolean ettPar = false;

        for (int i = 0; i < 4; i++) {

            if (hand[i] == hand[i+1]) {
                if (ettPar) return false;
                ettPar = true;
            }
        }

        return ettPar;
    }

    /**
     * Returnerar {@code true} om handen innehåller ett tretal.
     * @param hand lista med 5 tal
     * @return sant om listan har 3 likadana tal
     */
    private static boolean är_tretal(int[] hand) {
        if (hand[0] == hand[2]) {
            return hand[2] != hand[3] && hand[3] != hand[4];
        } else if (hand[4] == hand[2]) {
            return hand[2] != hand[1] && hand[1] != hand[0];
        } else return hand[1] == hand[3];
    }

    /**
     * Returnerar {@code true} om handen innehåller ett fyrtal.
     * @param hand lista med 5 tal
     * @return sant om listan har 4 likadana tal
     */
    private static boolean är_fyrtal(int[] hand) {
        return (hand[0] == hand[3] || hand[1] == hand[4]) && hand[0] != hand[4];
    }

    /**
     * Returnerar {@code true} om handen är en "kåk".
     * @param hand lista med 5 tal
     * @return sant eller falskt beroende på om listan representerar en "kåk"
     */
    private static boolean är_kåk(int[] hand) {
        return (hand[0] == hand[1] && hand[2] == hand[4] || (hand[0] == hand[2] && hand[3] == hand[4])) && hand[0] != hand[4];
    }

    /**
     * Returnerar {@code true} endast om alla talen är i stigande ordning med enbart 1 i skillnad mellan varje.
     * @param hand lista med 5 tal
     * @return sant eller falskt beroende på om listan representerar en "stege"
     */
    private static boolean är_stege(int[] hand) {
        for (int i = 1; i < 5; i++) {
            if (hand[i] != hand[0] + i) return false;
        }
        return true;
    }

    /**
     * Fyller listans 5 första index med tal i spannet [0,12]
     * @param hand lista med 5 index
     */
    private static void plockaFem(int[] hand) {
        hand[0] = generator.nextInt(52);
        hand[1] = generator.nextInt(51);
        hand[2] = generator.nextInt(50);
        hand[3] = generator.nextInt(49);
        hand[4] = generator.nextInt(48);

        if (hand[1] >= hand[0]) hand[1]++;

        if (hand[2] >= Math.min(hand[0],hand[1])) hand[2]++;
        if (hand[2] >= Math.max(hand[0],hand[1])) hand[2]++;

        if (hand[3] >= Math.min(hand[0],Math.min(hand[1],hand[2]))) hand[3]++;
        if (hand[3] >= Math.min(Math.max(hand[0],Math.min(hand[1],hand[2])),Math.max(hand[1],hand[2]))) hand[3]++;
        if (hand[3] >= Math.max(hand[0],Math.max(hand[1],hand[2]))) hand[3]++;

        if (hand[4] >= Math.min(Math.min(hand[0],hand[1]),Math.min(hand[2],hand[3]))) hand[4]++;
        if (hand[4] >= Math.min(Math.max(Math.min(hand[0],hand[1]),Math.min(hand[2],hand[3])),
                       Math.max(Math.min(hand[0],hand[2]),Math.min(hand[1],hand[3])))) hand[4]++;
        if (hand[4] >= Math.max(Math.min(Math.max(hand[0],hand[1]),Math.max(hand[2],hand[3])),
                       Math.min(Math.max(hand[0],hand[2]),Math.max(hand[1],hand[3])))) hand[4]++;
        if (hand[4] >= Math.max(Math.max(hand[0],hand[1]),Math.max(hand[2],hand[3]))) hand[4]++;

        hand[0] >>= 2; hand[1] >>= 2; hand[2] >>= 2; hand[3] >>= 2; hand[4] >>= 2;
        Arrays.sort(hand);
    }

    /**
     * Sort of binary search, but a rolled out loop, since the list has only 5 indices.
     * @param kort Kortet som sökes, en int i spannet [0,12].
     * @param hand Handen med 5 kort.
     * @return {@code true} om kortet finns på handen {@code false} om den inte gör det
     */
    private static boolean har_kort(int kort, int[] hand) {
        int i = 2;
        int jump = 2;

        if (hand[i] == kort) return true;
        i += hand[i] > kort ? jump : -jump;
        jump--;

        if (hand[i] == kort) return true;
        i += hand[i] > kort ? jump : -jump;

        if (i < 0 || i > 4) return false;

        return hand[i] == kort;
    }

    /**
     * @param lista kortleken (bör ha längd 52)
     */
    private static void fyll_lista(int[] lista) {
        for (int i = 1; i < 14; i++) lista[i-1] = lista[i + 12] = lista[i + 25] = lista[i + 38] = i;
    }
}
