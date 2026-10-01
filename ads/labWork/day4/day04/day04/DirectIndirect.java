/**
 * Day 4 - Kinds of recursion.
 *   direct   : a method calls ITSELF            (factorial)
 *   indirect : A calls B, B calls A (a cycle)   (isEven / isOdd)
 *   head     : the recursive call comes FIRST, work is done while returning
 *   tail     : the recursive call is the LAST thing the method does
 */
public class DirectIndirect {

    // ---- indirect (mutual) recursion
    static boolean isEven(int n) { return n == 0 ? true  : isOdd(n - 1); }
    static boolean isOdd(int n)  { return n == 0 ? false : isEven(n - 1); }

    // ---- head recursion: call first, print while returning -> prints 1 2 3 4 5
    static void head(int n) {
        if (n == 0) return;
        head(n - 1);
        System.out.print(n + " ");
    }

    // ---- tail recursion: print first, call last -> prints 5 4 3 2 1
    static void tail(int n) {
        if (n == 0) return;
        System.out.print(n + " ");
        tail(n - 1);
    }

    // Tail-recursive factorial with an accumulator...
    static long factTail(int n, long acc) {
        if (n <= 1) return acc;
        return factTail(n - 1, acc * n);          // nothing left to do after the call
    }

    // ...is trivially a loop. (The JVM does NOT do this conversion for you.)
    static long factLoop(int n) {
        long acc = 1;
        while (n > 1) { acc *= n; n--; }
        return acc;
    }

    // ---- tree (multiple) recursion: more than one recursive call per level
    static int calls;
    static long fib(int n) {
        calls++;
        if (n < 2) return n;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("indirect: isEven(10) = " + isEven(10) + ", isOdd(7) = " + isOdd(7));
        System.out.print("head(5): "); head(5); System.out.println();
        System.out.print("tail(5): "); tail(5); System.out.println();
        System.out.println("factTail(20, 1) = " + factTail(20, 1) + "   factLoop(20) = " + factLoop(20));
        calls = 0; fib(20);
        System.out.println("tree recursion: fib(20) made " + calls + " calls");
    }
}
