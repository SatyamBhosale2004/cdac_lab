import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Day 3 - Where java.util.LinkedList really wins: removing WHILE iterating.
 * Remove every even number from a list of n numbers using an Iterator.
 *   LinkedList: iterator.remove() just relinks neighbours -> O(1) each -> O(n) total
 *   ArrayList : iterator.remove() shifts the tail left    -> O(n) each -> O(n^2) total
 * (For ArrayList the right tool is list.removeIf(...), which does one compacting pass.)
 */
public class ListIteratorDemo {

    static long removeEvens(List<Integer> list) {
        long t = System.nanoTime();
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) if (it.next() % 2 == 0) it.remove();
        return (System.nanoTime() - t) / 1_000_000;
    }

    public static void main(String[] args) {
        for (int n = 50_000; n <= 200_000; n *= 2) {
            List<Integer> a = new ArrayList<>(), l = new LinkedList<>(), r = new ArrayList<>();
            for (int i = 0; i < n; i++) { a.add(i); l.add(i); r.add(i); }
            long ta = removeEvens(a);
            long tl = removeEvens(l);
            long t = System.nanoTime();
            r.removeIf(x -> x % 2 == 0);
            long tr = (System.nanoTime() - t) / 1_000_000;
            System.out.printf("n=%,8d   ArrayList iterator.remove: %5d ms   LinkedList iterator.remove: %3d ms   ArrayList.removeIf: %3d ms%n",
                    n, ta, tl, tr);
        }
    }
}
