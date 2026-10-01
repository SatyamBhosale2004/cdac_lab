/**
 * Day 1 - A first look at the cost of recursive algorithms
 * (recursion is covered fully on Day 4).
 * We count CALLS to see the growth.
 */
public class RecursionCost {

    static long calls;

    // T(n) = T(n-1) + c            -> O(n) time, O(n) stack space
    static long factorial(int n) {
        calls++;
        if (n <= 1) return 1;                 // base case
        return n * factorial(n - 1);
    }

    // T(n) = T(n/2) + c            -> O(log n)
    static int binarySearch(int[] a, int key, int lo, int hi) {
        calls++;
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;         // avoids int overflow of (lo+hi)
        if (a[mid] == key) return mid;
        if (key < a[mid]) return binarySearch(a, key, lo, mid - 1);
        return binarySearch(a, key, mid + 1, hi);
    }

    // T(n) = T(n-1) + T(n-2) + c   -> O(2^n)  (exponential!)
    static long fib(int n) {
        calls++;
        if (n < 2) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        for (int n : new int[]{10, 20}) {
            calls = 0; factorial(n);
            System.out.println("factorial(" + n + ")  calls = " + calls);
        }

        int[] a = new int[1 << 20];               // 1,048,576 sorted values
        for (int i = 0; i < a.length; i++) a[i] = i;
        calls = 0; binarySearch(a, -1, 0, a.length - 1);
        System.out.println("binarySearch in 1,048,576 items: calls = " + calls + "  (log2 n = 20)");

        for (int n = 10; n <= 30; n += 5) {
            calls = 0;
            long t = System.nanoTime();
            long v = fib(n);
            long ms = (System.nanoTime() - t) / 1_000_000;
            System.out.printf("fib(%d) = %-8d calls = %,12d   time = %d ms%n", n, v, calls, ms);
        }
        System.out.println("Each +5 in n multiplies the calls by about 11 (1.618^5). Fix on Day 8: memoization.");
    }
}
