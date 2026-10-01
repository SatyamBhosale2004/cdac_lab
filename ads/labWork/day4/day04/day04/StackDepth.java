/**
 * Day 4 - How deep can recursion go in Java?
 * Every call uses a stack frame. The thread stack has a fixed size
 * (typically around 512 KB - 1 MB by default, set with -Xss).
 * When it is full: java.lang.StackOverflowError.
 */
public class StackDepth {

    static int depth;

    // No base case at all: always overflows
    static void noBaseCase() {
       // if (depth==10){return;}
        depth++;
        noBaseCase();
    }

    // Bigger frames (more local variables) -> fewer calls fit on the stack
    static long bigFrame(long a, long b, long c, long d, long e, long f) {
        depth++;
        long g = a + b, h = c + d, i = e + f, j = g * h, k = h * i, l = i * j;
        return bigFrame(g, h, i, j, k, l) + g + h + i + j + k + l;
    }

    // Base case that is never reached for negative n: a very common bug
    static long wrongBase(int n) {
        depth++;
        if (n == 0) return 1;          // factorial(-1) never hits 0
        return n * wrongBase(n - 1);
    }

    public static void main(String[] args) {
        depth = 0;
        try { noBaseCase(); } catch (StackOverflowError e) {
            System.out.println("no base case        : StackOverflowError after " + depth + " calls");
        }
        depth = 0;
        try { bigFrame(1, 2, 3, 4, 5, 6); } catch (StackOverflowError e) {
            System.out.println("bigger stack frames : StackOverflowError after " + depth + " calls");
        }
        depth = 0;
        try { wrongBase(-1); } catch (StackOverflowError e) {
            System.out.println("wrongBase(-1)       : StackOverflowError after " + depth + " calls (base case never reached)");
        }

        // More stack for a new thread: Thread(group, runnable, name, stackSize)
        Thread t = new Thread(null, () -> {
            depth = 0;
            try { noBaseCase(); } catch (StackOverflowError e) {
                System.out.println("thread with 64 MB   : StackOverflowError after " + depth + " calls");
            }
        }, "big-stack", 64L * 1024 * 1024);
        t.start();
        try { t.join(); } catch (InterruptedException ignored) { }
        System.out.println("(numbers vary with JVM, OS and -Xss; run with  java -Xss4m StackDepth  to see the change)");
    }
}
