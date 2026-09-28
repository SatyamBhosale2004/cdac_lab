import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Day 2 - Stack application: are the brackets balanced?
 * Push every opening bracket; on a closing bracket the top MUST be its partner.
 * O(n) time, O(n) space in the worst case.
 * (We use ArrayDeque as the stack - the recommended Java way.
 *  Try replacing it with your own ArrayStack.)
 */
public class BalancedBrackets {

    static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return false;          // closing with nothing open
                char open = stack.pop();
                if (!matches(open, ch)) return false;         // wrong partner
            }
        }
        return stack.isEmpty();                               // something left open?
    }

    static boolean matches(char open, char close) {
        return (open == '(' && close == ')') || (open == '[' && close == ']') || (open == '{' && close == '}');
    }

    public static void main(String[] args) {
        String[] tests = { "a[i] = (b + c) * {d}", "{[()()]}", "([)]", "((a + b)", "a + b)" , "" };
        for (String t : tests)
            System.out.printf("%-24s -> %s%n", "\"" + t + "\"", isBalanced(t) ? "balanced" : "NOT balanced");
    }
}
