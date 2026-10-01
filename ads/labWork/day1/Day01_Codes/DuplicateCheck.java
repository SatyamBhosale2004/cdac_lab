import java.util.HashSet;
import java.util.Random;
import java.util.Set;


public class DuplicateCheck {

    // Compare every pair: n(n-1)/2 comparisons -> O(n^2)
    static boolean hasDuplicateNested(int[] a) {
        for (int i = 0; i < a.length; i++) // 10
            for (int j = i + 1; j < a.length; j++) //9 , 8, 7,6....
                if (a[i] == a[j]) return true;
        return false;
    }

    // Remember what we have seen in a hash set: n inserts, each O(1) on average -> O(n)
    static boolean hasDuplicateSet(int[] a) {
        Set<Integer> seen = new HashSet<>();
        for (int x : a)
            if (!seen.add(x)) return true;   // add() returns false if x was already there
        return false;
    }

    public static void main(String[] args) {
        for (int n = 10; n <= 200; n *= 2) {
            int[] a = new Random(7).ints(n, 0, Integer.MAX_VALUE).distinct().toArray(); // no duplicates = worst case
            long t = System.nanoTime();
            boolean r1 = hasDuplicateNested(a);
            long nested = (System.nanoTime() - t) / 1_000_000;
            t = System.nanoTime();
            boolean r2 = hasDuplicateSet(a);
            long set = (System.nanoTime() - t) / 1_000_000;
            System.out.printf("n=%,8d  nested loops: %6d ms   HashSet: %4d ms   (%b %b)%n", a.length, nested, set, r1, r2);
        }
    }
}
