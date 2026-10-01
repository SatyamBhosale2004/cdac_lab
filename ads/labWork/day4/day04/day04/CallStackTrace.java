/**
 * Day 4 - Watch the call stack grow and shrink.
 * Each level of indentation is one stack frame.
 */
public class CallStackTrace {

    static int depth = 0;

    static long factorial(int n) {
        String pad = "  ".repeat(depth);
        System.out.println(pad + "-> factorial(" + n + ")   frame pushed, stack depth = " + (depth + 1));
        depth++;
        long result;
        if (n <= 1) {
            result = 1;                                   // base case: start returning
        } else {
            result = n * factorial(n - 1);                // this frame WAITS here
        }
        depth--;
        System.out.println(pad + "<- factorial(" + n + ") returns " + result + "   frame popped");
        return result;
    }

    public static void main(String[] args) {
        System.out.println("main calls factorial(4)");
        long r = factorial(4);
        System.out.println("main receives " + r);

        System.out.println("\nThe JVM shows the same stack in an exception stack trace:");
        try {
            broken(3);
        } catch (IllegalStateException e) {
            for (StackTraceElement el : e.getStackTrace()) System.out.println("  at " + el);
        }
    }

    static void broken(int n) {
        if (n == 0) throw new IllegalStateException("look at the stack");
        broken(n - 1);
    }
}
