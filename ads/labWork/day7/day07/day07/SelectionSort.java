import java.util.Arrays;

/**
 * Day 7 - Selection sort.
 * Pass i: find the SMALLEST element in a[i..n-1] and swap it into position i.
 * Comparisons: always n(n-1)/2 -> O(n^2) in every case.  Swaps: at most n-1 (fewest of all simple sorts).
 * In-place. NOT stable (a long-distance swap can jump over an equal key).
 */
public class SelectionSort {

    static long comparisons, swaps;

    static void sort(int[] a, boolean trace) {
        int n = a.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                comparisons++;
                if (a[j] < a[min]) min = j;
            }
            if (min != i) { 
                int t = a[i]; 
                a[i] = a[min]; 
                a[min] = t; 
                swaps++; 
            }
            if (trace) System.out.println("  pass " + (i + 1) + ": " + Arrays.toString(a) + "   (a[0.." + i + "] sorted)");
        }
    }

    public static void main(String[] args) {
        int[] a = {64, 25, 12, 22, 11};
        System.out.println("start : " + Arrays.toString(a));
        sort(a, true);
        System.out.println("comparisons = " + comparisons + " (n(n-1)/2 = 10), swaps = " + swaps);
    }
}
/*
n=5
i = 0    j = 1    min=0     comparisons=0 1
                  min=1
         j=2       min=2
         j=3    min=2
         j=4   min=4
         j=5

i=1

*/