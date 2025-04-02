package ProgrammeringsUppgifter;

public class ComputePi {

    private static final long depth = 100000;

    public static void arctanAlgorithm() {
        double sum = 0.0;
        for (long i = 0; i < depth; i++) {
            if (i % 2 == 0) {
                sum += 1.0 / (2.0*i+1.0);
            } else {
                sum -= 1 / (2.0*i+1.0);
            }
        }
        System.out.println(sum * 4.0);
    }
}
