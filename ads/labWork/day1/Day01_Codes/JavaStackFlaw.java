import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Day 1 - An OO design lesson from the JDK itself.
 * java.util.Stack (Java 1.0) EXTENDS Vector, so it inherits list operations
 * that break the stack ADT (you can insert or read in the middle!).
 * Inheritance was used where composition was needed.
 * The Javadoc itself recommends Deque / ArrayDeque instead.
 */
public class JavaStackFlaw {
    public static void main(String[] args) {
        Stack<String> s = new Stack<>();
        s.push("A"); s.push("B"); s.push("C");
        s.add(0, "SNEAKY");                 // insert at the BOTTOM - not a stack operation
        s.remove(2);                         // remove from the middle
        System.out.println("java.util.Stack : " + s + "   get(1) = " + s.get(1));

        Deque<String> d = new ArrayDeque<>();   // use this as a stack
        d.push("A"); d.push("B"); d.push("C");
        System.out.println("ArrayDeque stack: pop = " + d.pop() + ", peek = " + d.peek());
    }
}
