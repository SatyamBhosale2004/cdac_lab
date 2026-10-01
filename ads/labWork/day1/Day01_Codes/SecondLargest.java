import java.util.Arrays;

/**
 * Day 1 - Problem solving walk-through: find the SECOND largest value.
 *
 * Step 1  Understand : input int[], output the 2nd largest DISTINCT value.
 * Step 2  Edge cases : fewer than 2 elements? all equal? negatives? duplicates of max?
 * Step 3  Brute force: sort, then walk back from the end      -> O(n log n)
 * Step 4  Improve    : one pass, remember top two values      -> O(n), O(1) extra space
 */
public class SecondLargest {

    // Approach 1: sort a copy (do not disturb the caller's array)
    static Integer bySorting(int[] a) {
        int[] c = Arrays.copyOf(a, a.length);   // O(n) extra space
        Arrays.sort(c);                          // O(n log n)
        for (int i = c.length - 2; i >= 0; i--) {
            if (c[i] != c[c.length - 1]) return c[i];
        }
        return null;                             // no second distinct value
    }

    // Approach 2: single pass - keep the best and the second best seen so far
    static Integer onePass(int[] a) {
        if (a.length < 2) return null;
        long first = Long.MIN_VALUE, second = Long.MIN_VALUE;  // long: so Integer.MIN_VALUE is a valid answer
        for (int x : a) {                        // n iterations
            if (x > first) {                     // new maximum: old max becomes second
                second = first;
                first = x;
            } else if (x < first && x > second) {
                second = x;                      // between second and first
            }
        }
        return second == Long.MIN_VALUE ? null : (int) second;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {12, 35, 1, 10, 34, 1},     // normal         -> 34
            {10, 10, 10},               // all equal      -> none
            {-5, -2, -9},               // negatives      -> -5
            {7, 7, 3},                  // duplicate max  -> 3
            {42},
            {},                         // too short      -> none
        };
        for (int[] t : tests) {
            System.out.printf("%-22s sort: %-5s onePass: %s%n",
                    Arrays.toString(t), bySorting(t), onePass(t));
        }
    }
}
