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
 boolean har_kort(int[],int)

 Returnerar:
 chansen att en hand på 5 kort är något av ovanstående i ordingen ovan
 (1 sortering per hand, 1000 oberoende händer)
 */

public class PokerProv {

    /**
     * Prov-uppgiften i en metod
     * @return lista med chanserna att få: stege [0], tvåpar [1], par [2], fyrtal [3], tretal [4], kåk [5]
     */
    public static double[] chanser() {
        int[] kortlek = new int[52];
        fyll_lista(kortlek);
        return new double[]{0.0};
    }

    /**
     * @param lista kortleken (bör ha längd 52)
     */
    private static void fyll_lista(int[] lista) {
        for (int i = 1; i < 14; i++) lista[i-1] = lista[i + 12] = lista[i + 25] = lista[i + 38] = i;
    }
}
