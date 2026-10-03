import java.util.Arrays;
import java.util.Random;

/**
 * Day 7 - All six sorts on random, sorted and reversed data. Self-contained (compact copies of each sort).
 */
public class SortBenchmark {

    static void selection(int[] a) { for (int i = 0; i < a.length - 1; i++) { int m = i; for (int j = i + 1; j < a.length; j++) if (a[j] < a[m]) m = j; swap(a, i, m); } }
    static void insertion(int[] a) { for (int i = 1; i < a.length; i++) { int k = a[i], j = i - 1; while (j >= 0 && a[j] > k) { a[j + 1] = a[j]; j--; } a[j + 1] = k; } }
    static void bubble(int[] a) { for (int p = 1; p < a.length; p++) { boolean s = false; for (int j = 0; j < a.length - p; j++) if (a[j] > a[j + 1]) { swap(a, j, j + 1); s = true; } if (!s) return; } }
    static void merge(int[] a) { int[] t = new int[a.length]; ms(a, t, 0, a.length - 1); }
    static void ms(int[] a, int[] t, int lo, int hi) { if (lo >= hi) return; int m = (lo + hi) >>> 1; ms(a, t, lo, m); ms(a, t, m + 1, hi);
        int i = lo, j = m + 1, k = lo; while (i <= m && j <= hi) t[k++] = a[i] <= a[j] ? a[i++] : a[j++]; while (i <= m) t[k++] = a[i++]; while (j <= hi) t[k++] = a[j++]; System.arraycopy(t, lo, a, lo, hi - lo + 1); }
    static final Random R = new Random(5);
    static void quick(int[] a) { qs(a, 0, a.length - 1); }
    static void qs(int[] a, int lo, int hi) { while (lo < hi) { swap(a, lo + R.nextInt(hi - lo + 1), hi); int p = a[hi], i = lo - 1; for (int j = lo; j < hi; j++) if (a[j] < p) swap(a, ++i, j); swap(a, i + 1, hi);
        int q = i + 1; if (q - lo < hi - q) { qs(a, lo, q - 1); lo = q + 1; } else { qs(a, q + 1, hi); hi = q - 1; } } }   // recurse on the smaller side: O(log n) stack
    static void heap(int[] a) { int n = a.length; for (int i = n / 2 - 1; i >= 0; i--) sift(a, i, n); for (int e = n - 1; e > 0; e--) { swap(a, 0, e); sift(a, 0, e); } }
    static void sift(int[] a, int i, int n) { while (true) { int b = i, l = 2 * i + 1, r = l + 1; if (l < n && a[l] > a[b]) b = l; if (r < n && a[r] > a[b]) b = r; if (b == i) return; swap(a, i, b); i = b; } }
    static void swap(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }

    interface Sorter { void sort(int[] a); }

    static long time(Sorter s, int[] data) {
        int[] a = data.clone();
        long t = System.nanoTime(); s.sort(a); long ms = (System.nanoTime() - t) / 1_000_000;
        for (int i = 1; i < a.length; i++) if (a[i - 1] > a[i]) throw new AssertionError("not sorted!");
        return ms;
    }

    public static void main(String[] args) {
        String[] names = {"selection", "insertion", "bubble", "merge", "quick", "heap", "Arrays.sort"};
        Sorter[] sorters = {SortBenchmark::selection, SortBenchmark::insertion, SortBenchmark::bubble, SortBenchmark::merge, SortBenchmark::quick, SortBenchmark::heap, Arrays::sort};
        int[] warm = new Random(1).ints(3000).toArray();
        for (Sorter s : sorters) time(s, warm);                        // JIT warm-up

        for (int n : new int[]{20_000, 1_000_000}) {
            int[] random = new Random(2).ints(n).toArray();
            int[] sorted = random.clone(); Arrays.sort(sorted);
            int[] reversed = new int[n]; for (int i = 0; i < n; i++) reversed[i] = sorted[n - 1 - i];
            System.out.printf("%nn = %,d%n%-12s %10s %10s %10s%n", n, "algorithm", "random", "sorted", "reversed");
            for (int k = 0; k < sorters.length; k++) {
                if (n > 50_000 && k < 3) { System.out.printf("%-12s %10s %10s %10s%n", names[k], "(skip)", "", ""); continue; }   // O(n^2): minutes
                System.out.printf("%-12s %8d ms %7d ms %7d ms%n", names[k], time(sorters[k], random), time(sorters[k], sorted), time(sorters[k], reversed));
            }
        }
    }
}
