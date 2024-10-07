package ProgrammeringsUppgifter.ProjectEuler;

/**<a href="https://projecteuler.net/problem=45">Problem 45 på projecteuler.net</a>
 */
@SuppressWarnings("SpellCheckingInspection")
public class Problem45 {

    /*
     * I uppgiften är det givet att 285:e triangel-talet förekommer
     * bland pentagon-talen och hexagon-talen. Uppgiften är att hitta
     * nästa tal som förekommer i alla talserier och returnera n för
     * korresponderande triangel-talet.
     */
    private int nForTriangle = 286;
    //Givet att T(285)=40755 så är T(286)=41041 enligt rekursiva formeln: T(n+1)=T(n)+n+1
    private int Tn = 41041;

    private int nForPentagon = 166;
    //Givet att P(165)=40755 så är P(166)=41251 enligt rekursiva formeln: P(n+1)=P(n)+3n+1
    private int Pn = 41251;

    private int nForHexagon = 144;
    //Givet att H(143)=40755 så är H(144)=41328 enligt rekursiva formeln: H(n+1)=H(n)+4n+1
    private int Hn = 41328;

    public Problem45() {
        //while !(T(n) == P(n) && T(n) == H(n))
            //if (T(n) > P(n)) -> nextPentagon();
            //if (P(n) > H(n)) -> nextHexagon();
            //if (H(n) > T(n)) -> nextTriangle();
        while (Tn != Pn || Tn != Hn) {
            if (Tn > Pn) {nextPentagon();}
            if (Pn > Hn) {nextHexagon();}
            if (Hn > Tn) {nextTriangle();}
        }
        System.out.printf("nForTriangle: %d, nForPentagon: %d, nForHexagon: %d%nTrianglenumber: %d, Pentagonnumber: %d, Hexagonnumber: %d",
                nForTriangle, nForPentagon, nForHexagon, Tn, Pn, Hn);
    }

    private void nextTriangle() {
        this.Tn = this.Tn + nForTriangle++ + 1;
    }

    private void nextPentagon() {
        this.Pn = this.Pn + 3 * nForPentagon++ + 1;
    }

    private void nextHexagon() {
        this.Hn = this.Hn + 4 * nForHexagon++ + 1;
    }
}
