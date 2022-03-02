import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
    public static void main(String[] args) {
        int index = 0;
        String champion = "";
        while (!StdIn.isEmpty()) {
            index++;
            String newRead = StdIn.readString();
            if (StdRandom.bernoulli(1.0 / index)) {
                champion = newRead;
            }
        }
        StdOut.println(champion);
    }
}
