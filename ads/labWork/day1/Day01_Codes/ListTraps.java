import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Day 1 - Using a List as a queue: remove(0) on ArrayList shifts EVERY element left.
 * n removals x O(n) shift = O(n^2).  ArrayDeque.poll() is O(1) (circular array - Day 2).
 */
public class ListTraps {

    public static void main(String[] args) {
        for (int n = 25_000; n <= 200_000; n *= 2) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) list.add(i);
            long t = System.nanoTime();
            while (!list.isEmpty()) list.remove(0);                // shifts n-1, n-2, ... elements
            long slow = (System.nanoTime() - t) / 1_000_000;

            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < n; i++) dq.add(i);
            t = System.nanoTime();
            while (!dq.isEmpty()) dq.poll();                         // just moves the head index
            long fast = (System.nanoTime() - t) / 1_000_000;

            System.out.printf("n=%,8d   ArrayList.remove(0): %5d ms   ArrayDeque.poll(): %3d ms%n", n, slow, fast);
        }
    }
}
