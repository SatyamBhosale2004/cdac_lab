import java.util.Arrays;
import java.util.Random;

/**
 * Day 7 LAB (syllabus) - Quick sort (divide and conquer).
 *   1. choose a PIVOT
 *   2. PARTITION: smaller elements to its left, larger to its right -> the pivot is now in its final place
 *   3. quick sort the left part and the right part recursively
 * Average O(n log n), in-place (O(log n) stack), NOT stable.
 * Worst case O(n^2) when the pivot is always the smallest/largest (e.g. last-element pivot on sorted data).
 * A RANDOM pivot makes the worst case extremely unlikely.
 */
public class QuickSort {

    static long comparisons;
    static final Random RND = new Random();
    static boolean randomPivot = true;
    static boolean trace = false;

    static void sort(int[] a) { sort(a, 0, a.length - 1); }

    static void sort(int[] a, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(a, lo, hi);
        if (trace) System.out.println("  pivot " + a[p] + " placed at " + p + ": " + Arrays.toString(a));
        sort(a, lo, p - 1);
        sort(a, p + 1, hi);
    }

    // Lomuto partition with the pivot at a[hi]
    static int partition(int[] a, int lo, int hi) {
        if (randomPivot) swap(a, lo + RND.nextInt(hi - lo + 1), hi);   // move a random element to the end
        int pivot = a[hi];
        int i = lo - 1;                           // a[lo..i] holds elements < pivot
        for (int j = lo; j < hi; j++) {
            comparisons++;
            if (a[j] < pivot) swap(a, ++i, j);
        }
        swap(a, i + 1, hi);                       // put the pivot between the two parts
        return i + 1;
    }

    static void swap(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }

    public static void main(String[] args) {
        int[] a = {10, 80, 30, 90, 40, 50, 70};
        System.out.println("start : " + Arrays.toString(a) + "   (last element as pivot)");
        randomPivot = false; trace = true;
        sort(a);
        trace = false;

        int n = 2000;                               // bigger n with a last-element pivot can overflow the stack: depth = n!
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) sorted[i] = i;
        randomPivot = false; comparisons = 0; sort(sorted.clone());
        System.out.printf("%nsorted input, LAST element pivot  : comparisons = %,10d   (~n^2/2 = %,d)  worst case!%n", comparisons, (long) n * n / 2);
        randomPivot = true; comparisons = 0; sort(sorted.clone());
        System.out.printf("sorted input, RANDOM pivot        : comparisons = %,10d   (~1.39 n log2 n = %,.0f)%n", comparisons, 1.39 * n * Math.log(n) / Math.log(2));
    }
}
