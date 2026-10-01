/**
 * Day 4 - Tower of Hanoi: the classic problem that is EASY with recursion.
 * Move n disks from peg A to peg C using B, never putting a big disk on a small one.
 *   1. move n-1 disks A -> B   (using C)
 *   2. move the biggest disk A -> C
 *   3. move n-1 disks B -> C   (using A)
 * T(n) = 2T(n-1) + 1  ->  2^n - 1 moves  ->  O(2^n)
 */
public class TowerOfHanoi {

    static long moves;

    static void hanoi(int n, char from, char to, char via, boolean print) {
        if (n == 0) return;                          // nothing to move
        hanoi(n - 1, from, via, to, print);          // 1
        moves++;
        if (print) System.out.println("  move disk " + n + " : " + from + " -> " + to);   // 2
        hanoi(n - 1, via, to, from, print);          // 3
    }

    public static void main(String[] args) {
        System.out.println("n = 3:");
        moves = 0; hanoi(3, 'A', 'C', 'B', true);
        System.out.println("  total moves = " + moves + "  (2^3 - 1 = 7)\n");

        for (int n = 5; n <= 25; n += 5) {
            moves = 0; hanoi(n, 'A', 'C', 'B', false);
            System.out.printf("n = %2d   moves = %,12d   (2^n - 1 = %,d)%n", n, moves, (1L << n) - 1);
        }
        System.out.println("n = 64 (the legend): 18,446,744,073,709,551,615 moves - at one per second, ~585 billion years.");
    }
}
