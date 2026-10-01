import java.util.Arrays;
import java.util.Random;

/**
 * Day 1 LAB - Measure real running time and watch the growth rate.
 * Double n each time and look at the RATIO between rows:
 *   O(n)       -> about 2x
 *   O(n log n) -> a little more than 2x
 *   O(n^2)     -> about 4x
 * Note: the JVM "warms up" (JIT compiler), so the first rows can be noisy.
 */
public class GrowthExperiment {

    static long sink;   // stops the JIT from deleting "useless" loops

    static void linear(int[] a) {                 // O(n): sum
        long s = 0;
        for (int x : a) s += x;
        sink += s;
    }

    static void quadratic(int[] a) {              // O(n^2): count pairs with a[i] < a[j]
        long c = 0;
        for (int i = 0; i < a.length; i++)
            for (int j = i + 1; j < a.length; j++)
                if (a[i] < a[j]) c++;
        sink += c;
    }

    static void nLogN(int[] a) {                  // O(n log n): Arrays.sort on a copy
        int[] c = a.clone();
        Arrays.sort(c);
        sink += c[0];
    }

    static double timeMs(Runnable r) {
        long t = System.nanoTime();
        r.run();
        return (System.nanoTime() - t) / 1e6;
    }

    public static void main(String[] args) {
        Random rnd = new Random(1);
        // warm-up so the JIT compiles the methods before we measure
        int[] warm = rnd.ints(5_000).toArray();
        for (int i = 0; i < 5; i++) { linear(warm); quadratic(warm); nLogN(warm); }

        System.out.printf("%9s %12s %14s %12s%n", "n", "O(n) ms", "O(n log n) ms", "O(n^2) ms");
        for (int n = 5_000; n <= 80_000; n *= 2) {
            int[] a = rnd.ints(n).toArray();
            double t1 = timeMs(() -> linear(a));
            double t2 = timeMs(() -> nLogN(a));
            double t3 = timeMs(() -> quadratic(a));
            System.out.printf("%9d %12.3f %14.3f %12.1f%n", n, t1, t2, t3);
        }
        System.out.println("(ignore sink = " + (sink % 10) + ")");
    }
}
