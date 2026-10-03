import java.util.Arrays;

/**
 * Day 7 - Bubble sort.
 * Compare neighbours and swap if out of order; after pass k the k largest elements have "bubbled" to the end.
 * With the "swapped" flag it stops early when a pass makes no swaps:
 *   best (sorted) : one pass, n-1 comparisons -> O(n)
 *   worst         : n(n-1)/2 comparisons and swaps -> O(n^2)
 * In-place, stable. Mostly of teaching value - it does the most swaps of all.
 */
public class BubbleSort {

    static long comparisons, swaps;

    static void sort(int[] a, boolean trace) {
        int n = a.length;
        for (int pass = 1; pass < n; pass++) {
            boolean swapped = false;
            for (int j = 0; j < n - pass; j++) {         // the last (pass-1) elements are already in place
                comparisons++;
                if (a[j] > a[j + 1]) {
                    int t = a[j]; 
                    a[j] = a[j + 1]; 
                    a[j + 1] = t;
                    swaps++; swapped = true;
                }
            }
            if (trace) System.out.println("  pass " + pass + ": " + Arrays.toString(a));
            if (!swapped) { if (trace) System.out.println("  no swaps -> already sorted, stop"); break; }
        }
    }

    public static void main(String[] args) {
        int[] a = {5, 1, 4, 2, 8};
        System.out.println("start : " + Arrays.toString(a));
        sort(a, true);
        System.out.println("comparisons = " + comparisons + ", swaps = " + swaps);
        int[] sorted = {1, 2, 3, 4, 5, 6, 7, 8};
        comparisons = swaps = 0; sort(sorted, false);
        System.out.println("already sorted 8 elements: comparisons = " + comparisons + " (one pass), swaps = " + swaps);
    }
}
