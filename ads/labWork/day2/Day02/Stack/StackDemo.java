import java.util.Scanner;

public class StackDemo {

    int max = 100;
    char[] stack = new char[max];
    int top = -1;

    void push(char value) {
        if (top == max - 1) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = value;
        }
    }

    char pop() {
        if (top == -1) {
            return '\0';
        }
        return stack[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }

    boolean isBalanced(String expression) {
        top = -1;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (isEmpty()) {
                    return false;
                }

                char open = pop();
                if (!isMatchingPair(open, ch)) {
                    return false;
                }
            }
        }

        return isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackDemo stackDemo = new StackDemo();

        System.out.print("Enter an expression: ");
        String expression = scanner.nextLine();

        System.out.println(expression + " -> " + (stackDemo.isBalanced(expression) ? "Balanced" : "Not Balanced"));
        scanner.close();
    }
}