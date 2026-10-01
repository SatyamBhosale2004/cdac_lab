/**
 * Day 1 LAB - Complexity of loops.
 * Each method counts how many times its innermost statement runs.
 * Guess the Big O first, then run and check how the count grows when n doubles.
 */
public class LoopComplexity {

    static long single(int n) {              // O(n)
        long c = 0;
        for (int i = 0; i < n; i++) c++;
        return c;
    }

    static long nested(int n) {              // O(n^2)
        long c = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) c++;
        return c;
    }

    static long triangle(int n) {            // n(n-1)/2  -> O(n^2)
        long c = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < i; j++) c++;
        return c;
    }

    static long halving(int n) {             // O(log n)
        long c = 0;
        for (int i = n; i > 1; i /= 2) c++;
        return c;
    }

    static long nLogN(int n) {               // O(n log n)
        long c = 0;
        for (int i = 0; i < n; i++)
            for (int j = 1; j < n; j *= 2) c++;
        return c;
    }

    static long sequential(int n) {          // O(n) + O(n) = O(n)
        long c = 0;
        for (int i = 0; i < n; i++) c++;
        for (int i = 0; i < n; i++) c++;
        return c;
    }

    static long sqrtLoop(int n) {            // O(sqrt n)
        long c = 0;
        for (long i = 1; i * i <= n; i++) c++;
        return c;
    }
    /**
     * i    n        c=0
     * 1    1000     1
     * 2             2
     * 3         3
     * 4        4
     * 5        5
     * 31
     */

    static long constant(int n) {            // O(1): does not depend on n
        long c = 0;
        for (int i = 0; i < 100; i++) c++;
        return c;
    }

    public static void main(String[] args) {
        System.out.printf("%8s %10s %14s %14s %8s %12s %12s %8s %8s%n",
                "n", "single", "nested", "triangle", "halving", "nLogN", "sequential", "sqrt", "const");
        for (int n = 1_000; n <= 16_000; n *= 2) {
            System.out.printf("%8d %10d %14d %14d %8d %12d %12d %8d %8d%n",
                    n, single(n), nested(n), triangle(n), halving(n), nLogN(n), sequential(n), sqrtLoop(n), constant(n));
        }
        System.out.println("\nWhen n doubles: O(n) doubles, O(n^2) becomes 4x, O(log n) adds just 1.");
    }
}
