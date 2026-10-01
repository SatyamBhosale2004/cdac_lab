/**
 * Day 4 - Same function, three algorithms.
 *   naive recursion : O(2^n) time (actually ~1.618^n), O(n) stack
 *   memoised        : O(n) time, O(n) space  - remember answers we already computed
 *   iterative       : O(n) time, O(1) space
 * (Day 8 does memoisation with a HashMap; Day 11 calls the idea "dynamic programming".)
 */
public class FibonacciCompare {

    static long calls;

    static long naive(int n) {
        calls++;
        if (n < 2) return n;
        return naive(n - 1) + naive(n - 2);
    }

    static long memo(int n, long[] cache) {
        calls++;
        if (n < 2) return n;
        if (cache[n] != 0) return cache[n];                 // already computed: O(1)
        return cache[n] = memo(n - 1, cache) + memo(n - 2, cache);
    }

    static long iterative(int n) {
        long a = 0, b = 1;                                  // fib(0), fib(1)
        for (int i = 0; i < n; i++) {
             long t = a + b;
              a = b;
               b = t; 
            }
        return a;
    }
    // 0 1 1 2 3 5 8 13 21 34 55 89 144 233 377 610 987 1597 2584 4181 6765

    public static void main(String[] args) {
        System.out.printf("%4s %14s %16s %10s %12s %10s%n", "n", "fib(n)", "naive calls", "naive ms", "memo calls", "iter");
        for (int n = 5; n <= 10; n += 2) {
            calls = 0;
            long t = System.nanoTime();
            long v = naive(n);
            long ms = (System.nanoTime() - t) / 1_000_000;
            long naiveCalls = calls;
            calls = 0;
            long m = memo(n, new long[n + 1]);
            System.out.printf("%4d %,14d %,16d %10d %,12d %10d%n", n, v, naiveCalls, ms, calls, iterative(n));
            if (m != v) throw new AssertionError();
        }
        System.out.println("fib(90) iterative = " + iterative(90) + "  (naive would need ~10^19 calls)");
    }
}
