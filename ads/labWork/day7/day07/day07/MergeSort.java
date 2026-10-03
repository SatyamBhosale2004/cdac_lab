import java.util.Arrays;

/**
 * Day 7 - Merge sort (divide and conquer).
 *   1. split the array into two halves
 *   2. sort each half recursively
 *   3. MERGE the two sorted halves in one linear pass
 * T(n) = 2T(n/2) + n -> O(n log n) in EVERY case. Stable. Needs O(n) extra space (not in-place).
 * Java's TimSort (for objects) is a highly tuned merge sort.
 */
public class MergeSort {

    static long comparisons;

    static void sort(int[] a) {
        int[] tmp = new int[a.length];          // one buffer, reused by every merge
        sort(a, tmp, 0, a.length - 1, 0);
    }

    static void sort(int[] a, int[] tmp, int lo, int hi, int depth) {
        if (lo >= hi) return;                    // 0 or 1 element: already sorted
        int mid = lo + (hi - lo) / 2;
        sort(a, tmp, lo, mid, depth + 1);
        sort(a, tmp, mid + 1, hi, depth + 1);
        merge(a, tmp, lo, mid, hi);
        if (a.length <= 16) System.out.println("  ".repeat(depth) + "merged [" + lo + ".." + hi + "] -> " + Arrays.toString(Arrays.copyOfRange(a, lo, hi + 1)));
    }

    static void merge(int[] a, int[] tmp, int lo, int mid, int hi) {
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid && j <= hi) {
            comparisons++;
            if (a[i] <= a[j]) tmp[k++] = a[i++];   // <= takes from the LEFT on ties: stable
            else tmp[k++] = a[j++];
        }
        while (i <= mid) tmp[k++] = a[i++];       // copy leftovers (only one of these loops runs)
        while (j <= hi) tmp[k++] = a[j++];
        System.arraycopy(tmp, lo, a, lo, hi - lo + 1);
    }

    public static void main(String[] args) {
        int[] a = {38, 27, 43, 3};
        System.out.println("start : " + Arrays.toString(a));
        sort(a);
        System.out.println("result: " + Arrays.toString(a) + "   comparisons = " + comparisons);

        for (int n = 1 << 14; n <= 1 << 20; n <<= 3) {
            int[] b = new java.util.Random(1).ints(n).toArray();
            comparisons = 0; sort(b);
            System.out.printf("n = %,9d   comparisons = %,11d   n log2 n = %,11.0f%n", n, comparisons, n * (Math.log(n) / Math.log(2)));
        }
    }
}
