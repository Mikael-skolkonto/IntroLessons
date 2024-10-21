package ProgrammeringsUppgifter.ProjectEuler;

import java.util.ArrayList;

/**<a href="https://projecteuler.net/problem=46">Problem 46 på projecteuler.net</a>
 */
public class Problem46 {

    private ArrayList<Long> primtalsLista = new ArrayList<>(100);

    public Problem46() {

        for (long sammansattaTalet = 3; sammansattaTalet < Long.MAX_VALUE; sammansattaTalet+=2) {

            long differens = sammansattaTalet;
            long kvadratTalDifferens = 1;

            while (!isPrime(differens)) {
                differens -= 2L * kvadratTalDifferens;

                //Ifall inget primtal hittades efter att ha testat alla dubbla kvadrattal mindre än sammansattaTalet
                if (differens < 0) {
                    System.out.println("Första sammansatta talet som motbevisar Goldbachs förmodan är: " + sammansattaTalet);
                    return;
                }
                kvadratTalDifferens += 2;
            }
            //while-slinga avbryter när differensen är ett primtal,
            //eller så körs den inte om "sammansattaTalet" råkar vara ett primtal


        }
    }

    private boolean isPrime(long p) {
        for (long primtal : primtalsLista) {
            if (p % primtal == 0) {
                return false;
            }
        }
        primtalsLista.add(p);
        return true;
    }
}
