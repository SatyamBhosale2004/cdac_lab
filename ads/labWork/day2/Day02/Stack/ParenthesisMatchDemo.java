import java.util.Stack;

public class ParenthesisMatchDemo {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if (!isMatchingPair(top, ch)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }

    public static void main(String[] args) {
        String[] samples = {
            "(a+b)*(c+d)",
            "{[()]}",
            "(a+b]*c)",
            "((x+y)",
            "[(a+b) + {c-d}]"
        };

        for (String sample : samples) {
            System.out.println(sample + " -> " + (isBalanced(sample) ? "Balanced" : "Not Balanced"));
        }
    }
}