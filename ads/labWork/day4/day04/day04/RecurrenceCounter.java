/**
 * Day 4 - Measure the work done by typical recurrences and compare with the formulas.
 *   T(n) = T(n-1) + 1     -> n                (linear recursion)
 *   T(n) = T(n/2) + 1     -> log2 n           (binary search)
 *   T(n) = 2T(n/2) + n    -> n log2 n         (merge sort, Day 7)
 *   T(n) = 2T(n-1) + 1    -> 2^n - 1          (Tower of Hanoi)
 */
public class RecurrenceCounter {

    static long work;

    static void linear(int n)  { if (n == 0) return; work++; linear(n - 1); }
    static void halving(int n) { if (n <= 1) return; work++; halving(n / 2); }
    static void divideAndConquer(int n) {
        if (n <= 1) return;
        work += n;                                   // "merge" step touches all n elements
        divideAndConquer(n / 2);
        divideAndConquer(n - n / 2);
    }
    static void doubling(int n) { if (n == 0) return; work++; doubling(n - 1); doubling(n - 1); }

    public static void main(String[] args) {
        System.out.printf("%8s %10s %10s %14s %14s%n", "n", "T(n-1)+1", "T(n/2)+1", "2T(n/2)+n", "n log2 n");
        for (int n = 1024; n <= 8192; n *= 2) {
            work = 0; linear(n);           long a = work;
            work = 0; halving(n);          long b = work;
            work = 0; divideAndConquer(n); long c = work;
            System.out.printf("%8d %10d %10d %14d %14.0f%n", n, a, b, c, n * (Math.log(n) / Math.log(2)));
        }
        System.out.println();
        for (int n = 10; n <= 25; n += 5) {
            work = 0; doubling(n);
            System.out.printf("2T(n-1)+1 with n=%d: %,d  (2^n - 1 = %,d)%n", n, work, (1L << n) - 1);
        }
    }
}
