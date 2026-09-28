import java.util.Stack;
import java.util.Scanner;

public class ExpressionEvaluationDemo {

    public static int evaluatePostfix(String expression) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = expression.trim().split("\\s+");

        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }

            if (isOperator(token)) {
                int second = stack.pop();
                int first = stack.pop();

                switch (token.charAt(0)) {
                    case '+':
                        stack.push(first + second);
                        break;
                    case '-':
                        stack.push(first - second);
                        break;
                    case '*':
                        stack.push(first * second);
                        break;
                    case '/':
                        stack.push(first / second);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter postfix expression with spaces, for example: 2 3 1 * + 9 -");
        String expression = scanner.nextLine();

        System.out.println("Result: " + evaluatePostfix(expression));
        scanner.close();
    }
}