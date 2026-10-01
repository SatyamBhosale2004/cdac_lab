/**
 * Day 1 - A Java-specific Big O trap.
 * String is IMMUTABLE: s += x creates a NEW string and copies all old characters.
 * n appends copy 1 + 2 + ... + n characters -> O(n^2).
 * StringBuilder keeps a growable char array -> amortised O(1) per append -> O(n).
 */
public class StringConcatTrap {

    public static void main(String[] args) {
        for (int n = 10_000; n <= 80_000; n *= 2) {
            long t = System.nanoTime();
            String s = "";
            for (int i = 0; i < n; i++) s += 'x';              // O(n^2) total
            long slow = (System.nanoTime() - t) / 1_000_000;

            t = System.nanoTime();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < n; i++) sb.append('x');       // O(n) total
            String s2 = sb.toString();
            long fast = (System.nanoTime() - t) / 1_000_000;

            System.out.printf("n=%,7d   String +=: %5d ms   StringBuilder: %3d ms   (%d %d)%n",
                    n, slow, fast, s.length(), s2.length());
        }
    }
}
