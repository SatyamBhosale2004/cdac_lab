import java.util.Arrays;

/**
 * Day 7 - Heap sort.
 * Uses a binary MAX-heap stored in the array itself (the complete-tree-in-an-array idea from Day 5:
 * children of i at 2i+1 and 2i+2).
 *   1. BUILD a max-heap from the array: O(n)
 *   2. repeat: swap the root (largest) with the last element, shrink the heap, sift the new root down: O(log n) each
 * O(n log n) in EVERY case, in-place (O(1) extra space). Not stable.
 */
public class HeapSort {

    static long comparisons;

    static void sort(int[] a, boolean trace) {
        int n = a.length;
        for (int i = n / 2 - 1; i >= 0; i--) siftDown(a, i, n);        // build heap: start at the last internal node
        if (trace) System.out.println("  max-heap built : " + Arrays.toString(a));
        for (int end = n - 1; end > 0; end--) {
            swap(a, 0, end);                                            // largest goes to its final place
            siftDown(a, 0, end);                                        // restore the heap in a[0..end-1]
            if (trace) System.out.println("  move " + a[end] + " to index " + end + ": " + Arrays.toString(a));
        }
    }

    // Push a[i] down until it is larger than both children (within a[0..size-1])
    static void siftDown(int[] a, int i, int size) {
        while (true) {
            int largest = i, l = 2 * i + 1, r = 2 * i + 2;
            if (l < size) { comparisons++; if (a[l] > a[largest]) largest = l; }
            if (r < size) { comparisons++; if (a[r] > a[largest]) largest = r; }
            if (largest == i) return;
            swap(a, i, largest);
            i = largest;
        }
    }

    static void swap(int[] a, int i, int j) { int t = a[i]; a[i] = a[j]; a[j] = t; }

    public static void main(String[] args) {
        int[] a = {4, 10, 3, 5, 1};
        System.out.println("start : " + Arrays.toString(a));
        sort(a, true);
        System.out.println("result: " + Arrays.toString(a));
    }
}
