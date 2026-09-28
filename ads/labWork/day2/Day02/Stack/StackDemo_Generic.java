import java.util.Scanner;

public class StackDemo_Generic<T> {

    int max;
    Object[] stack;
    int top = -1;

    StackDemo_Generic() {
        this(100);
    }

    StackDemo_Generic(int capacity) {
        max = capacity;
        stack = new Object[max];
    }

    void push(T value) {
        if (top == max - 1) {
            System.out.println("Stack Overflow");
        } else {
            stack[++top] = value;
        }
    }

    @SuppressWarnings("unchecked")
    T pop() {
        if (top == -1) {
            return null;
        }
        return (T) stack[top--];
    }

    boolean isEmpty() {
        return top == -1;
    }

    static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }

    static boolean isBalanced(String expression) {
        StackDemo_Generic<Character> stackDemo = new StackDemo_Generic<>(expression.length());

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                stackDemo.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stackDemo.isEmpty()) {
                    return false;
                }

                Character open = stackDemo.pop();
                if (open == null) {
                    return false;
                }
                if (!isMatchingPair(open, ch)) {
                    return false;
                }
            }
        }

        return stackDemo.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        // Generic usage examples
        StackDemo_Generic<Integer> numberStack = new StackDemo_Generic<>();
        numberStack.push(10);
        numberStack.push(20);
        System.out.println("Popped Integer: " + numberStack.pop());

        StackDemo_Generic<String> textStack = new StackDemo_Generic<>();
        textStack.push("Hello");
        textStack.push("World");
        System.out.println("Popped String: " + textStack.pop());

        System.out.print("Enter an expression: ");
        String expression = scanner.nextLine();

        System.out.println(expression + " -> " + (isBalanced(expression) ? "Balanced" : "Not Balanced"));
        scanner.close();
    }
}
