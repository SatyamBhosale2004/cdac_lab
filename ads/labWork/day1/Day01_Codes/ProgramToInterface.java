import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Day 1 - ADT vs implementation.
 * List is the ADT (an interface: WHAT you can do).
 * ArrayList and LinkedList are data structures (HOW it is done).
 * The SAME client code has DIFFERENT complexity depending on the implementation.
 */
public class ProgramToInterface {

    // Client code only knows the ADT
    static long sumByIndex(List<Integer> list) {
        long s = 0;
        for (int i = 0; i < list.size(); i++) s += list.get(i);   // get(i): ArrayList O(1), LinkedList O(n)
        return s;
    }

    static long sumByIterator(List<Integer> list) {
        long s = 0;
        Iterator<Integer> it = list.iterator();                   // each next() is O(1) for both
        while (it.hasNext()) s += it.next();
        return s;
    }

    static void run(String name, List<Integer> list, int n) {
        for (int i = 0; i < n; i++) list.add(i);
        long t = System.nanoTime();
        long a = sumByIndex(list);
        long byIndex = (System.nanoTime() - t) / 1_000_000;
        t = System.nanoTime();
        long b = sumByIterator(list);
        long byIter = (System.nanoTime() - t) / 1_000_000;
        System.out.printf("%-10s n=%,7d   get(i) loop: %6d ms   iterator: %3d ms   (%d)%n",
                name, n, byIndex, byIter, a - b);
    }

    public static void main(String[] args) {
        for (int n = 20_000; n <= 80_000; n *= 2) {
            run("ArrayList", new ArrayList<>(), n);
            run("LinkedList", new LinkedList<>(), n);
        }
        System.out.println("Lesson: know the complexity of every operation your ADT's implementation gives you.");
    }
}
