import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Day 2 - Stack applications:
 *   1) convert infix  "3 + 4 * 2"  to postfix  "3 4 2 * +"
 *   2) evaluate postfix with a stack
 * Tokens must be separated by spaces. Operators: + - * / ^  and parentheses.
 */
public class PostfixEvaluation {

    static int precedence(String op) {
        switch (op) {
            case "+": case "-": return 1;
            case "*": case "/": return 2;
            case "^": return 3;
            default: return -1;
        }
    }

    static boolean isOperator(String t) { return precedence(t) > 0; }

    // Infix -> postfix (operator stack). O(n)
    static String toPostfix(String infix) {
        StringBuilder out = new StringBuilder();
        Deque<String> ops = new ArrayDeque<>();
        for (String t : infix.trim().split("\\s+")) {
            if (t.equals("(")) {
                ops.push(t);
            } else if (t.equals(")")) {
                while (!ops.peek().equals("(")) out.append(ops.pop()).append(' ');
                ops.pop();                                            // discard "("
            } else if (isOperator(t)) {
                // pop operators of higher precedence (or equal, for left-associative ones)
                while (!ops.isEmpty() && isOperator(ops.peek())
                        && (precedence(ops.peek()) > precedence(t)
                            || (precedence(ops.peek()) == precedence(t) && !t.equals("^")))) {
                    out.append(ops.pop()).append(' ');
                }
                ops.push(t);
            } else {
                out.append(t).append(' ');                            // operand goes straight out
            }
        }
        while (!ops.isEmpty()) out.append(ops.pop()).append(' ');
        return out.toString().trim();
    }

    // Evaluate postfix (operand stack). O(n)
    static long evaluate(String postfix) {
        Deque<Long> st = new ArrayDeque<>();
        for (String t : postfix.trim().split("\\s+")) {
            if (isOperator(t)) {
                long b = st.pop(), a = st.pop();                      // NOTE the order: b is on top
                switch (t) {
                    case "+": st.push(a + b); break;
                    case "-": st.push(a - b); break;
                    case "*": st.push(a * b); break;
                    case "/": st.push(a / b); break;
                    case "^": st.push((long) Math.pow(a, b)); break;
                }
            } else {
                st.push(Long.parseLong(t));
            }
        }
        return st.pop();
    }

    public static void main(String[] args) {
        String[] exprs = { "3 + 4 * 2", "( 3 + 4 ) * 2", "10 - 4 - 3", "2 ^ 3 ^ 2", "( 5 + 3 ) * ( 12 / 4 ) - 7" };
        for (String e : exprs) {
            String pf = toPostfix(e);
            System.out.printf("%-28s postfix: %-22s = %d%n", e, pf, evaluate(pf));
        }
    }
}
