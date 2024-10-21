package ProgrammeringsUppgifter.ProjectEuler;

import java.util.ArrayList;

/**<a href="https://projecteuler.net/problem=46">Problem 46 på projecteuler.net</a>
 */
public class Problem46 {

    private ArrayList<Integer> primtalsLista = new ArrayList<>(100);

    public Problem46() {

        for (int sammansattaTalet = 3; sammansattaTalet < Integer.MAX_VALUE; sammansattaTalet+=2) {

            int differens = sammansattaTalet;
            int kvadratTalDifferens = 1;

            while (!isPrime(differens)) {
                differens -= 2 * kvadratTalDifferens;

                //Ifall inget primtal hittades efter att ha testat alla dubbla kvadrattal mindre än sammansattaTalet
                if (differens < 0) {
                    System.out.println("Första sammansatta talet som motbevisar Goldbachs förmodan är: " + sammansattaTalet);
                    System.out.println(primtalsLista.size() + " primtal hittade:" + primtalsLista.toString());
                    return;
                }
                kvadratTalDifferens += 2;
            }
            //while-slinga avbryter när differensen är ett primtal,
            //eller så körs den inte om "sammansattaTalet" råkar vara ett primtal
            kvadratTalDifferens -= 2;
            System.out.println("Sammansatt tal och dess kvadrattals ordinal:" + Integer.toString(sammansattaTalet) + ' ' + Integer.toString((kvadratTalDifferens+1)>>1));

        }
    }

    private boolean isPrime(int p) {
        for (int primtal : primtalsLista) {
            if (p == primtal) {
                return true;
            }
            if (p % primtal == 0) {
                return false;
            }
        }
        primtalsLista.add(p);
        return true;
    }
}
