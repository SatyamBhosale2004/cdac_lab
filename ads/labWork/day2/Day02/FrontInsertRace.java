import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Day 2 - Insert n items at the FRONT.
 *   ArrayList.add(0, x)    -> shifts everything right: O(n) each, O(n^2) total
 *   LinkedList.addFirst(x) -> relink the head:          O(1) each
 *   ArrayDeque.addFirst(x) -> move the front index back: O(1) each (circular array)
 */
public class FrontInsertRace {
    public static void main(String[] args) {
        for (int n = 25_000; n <= 200_000; n *= 2) {
            long t = System.nanoTime();
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < n; i++) al.add(0, i);
            long a = (System.nanoTime() - t) / 1_000_000;

            t = System.nanoTime();
            LinkedList<Integer> ll = new LinkedList<>();
            for (int i = 0; i < n; i++) ll.addFirst(i);
            long b = (System.nanoTime() - t) / 1_000_000;

            t = System.nanoTime();
            ArrayDeque<Integer> ad = new ArrayDeque<>();
            for (int i = 0; i < n; i++) ad.addFirst(i);
            long c = (System.nanoTime() - t) / 1_000_000;

            System.out.printf("n=%,8d   ArrayList.add(0,x): %5d ms   LinkedList.addFirst: %3d ms   ArrayDeque.addFirst: %3d ms%n", n, a, b, c);
        }
    }
}
