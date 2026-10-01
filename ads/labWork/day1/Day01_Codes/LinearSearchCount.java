/**
 * Day 1 - Best, average and worst case of linear search.
 * We COUNT comparisons instead of measuring time.
 */
public class LinearSearchCount {

    static int comparisons;   // global counter for the demo

    static int linearSearch(int[] a, int key) {
        comparisons = 0;
        for (int i = 0; i < a.length; i++) {
            comparisons++;
            if (a[i] == key) return i;     // found
        }
        return -1;                          // not found
    }

    public static void main(String[] args) {
        int n = 1_000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = i * 3;          // 0, 3, 6, ...

        linearSearch(a, 0);
        System.out.println("Best case    (key at index 0)   : " + comparisons + " comparison(s)");

        linearSearch(a, a[n / 2]);
        System.out.println("Middle       (key at index n/2) : " + comparisons);

        linearSearch(a, a[n - 1]);
        System.out.println("Worst case   (key at the end)   : " + comparisons);

        linearSearch(a, -7);
        System.out.println("Worst case   (key not present)  : " + comparisons);

        // Average over every possible position of the key
        long total = 0;
        for (int i = 0; i < n; i++) { linearSearch(a, a[i]); total += comparisons; }
        System.out.println("Average (key present, uniform)  : " + (double) total / n + "  ~ n/2  -> still O(n)");
    }
}
