import java.util.Arrays;

/**
 * Day 7 LAB (syllabus) - Insertion sort.
 * Like sorting playing cards in your hand: take the next card and slide it left
 * into its place among the cards already sorted.
 *   best (already sorted) : n-1 comparisons      -> O(n)
 *   worst (reverse sorted): n(n-1)/2 comparisons -> O(n^2)
 * In-place, STABLE, adaptive (fast on nearly sorted data). Java's TimSort uses it for small runs.
 */
public class InsertionSort {

    static long comparisons, shifts;

    static void sort(int[] a, boolean trace) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];                      // the card we pick up
            int j = i - 1;
            while (j >= 0) {
                comparisons++;
                if (a[j] <= key) break;          // <= keeps equal keys in order: stable
                a[j + 1] = a[j];                 // shift the bigger element right
                shifts++;
                j--;
            }
            a[j + 1] = key;                      // drop the card into the gap
            if (trace) System.out.println("  i=" + i + " insert " + key + ": " + Arrays.toString(a));
        }
    }
/*i = 1
Key = 11     j = 0          new array: 12 12 13 5 6
             j = -1
                            array : 11 12 13 5 6
i = 2
key=13   j = 1
             j = 0
                            array : 11 12 13 5 6
i = 3
key=5    j = 2          new array: 11 12 13 13 6
             j = 1          new array: 11 12 12 13 6
             j = 0          new array: 11 11 12 13 6
             j = -1
                            array : 5 11 12 13 6   
i = 4
key=6    j = 3          new array: 5 11 12 13 13
             j = 2          new array: 5 11 12 12 13
             j = 1          new array: 5 11 11 12 13
             j = 0
                            array : 5 6 11 12 13   


*/

    public static void main(String[] args) {
        int[] a = {12, 11, 13, 5, 6};
        System.out.println("start : " + Arrays.toString(a));
        sort(a, true);

        for (String kind : new String[]{"sorted", "random", "reversed"}) {
            int n = 1000;
            int[] b = new int[n];
            for (int i = 0; i < n; i++) b[i] = kind.equals("sorted") ? i : kind.equals("reversed") ? n - i : (int) (Math.random() * n);
            comparisons = shifts = 0;
            sort(b, false);
            System.out.printf("n=1000 %-8s : comparisons = %,7d   shifts = %,7d%n", kind, comparisons, shifts);
        }
    }
}
