import java.util.Scanner;

public class StackArrayIntDemo {

    private final int[] stack;
    private int top = -1;

    StackArrayIntDemo(int capacity) {
        stack = new int[capacity];
    }

    void push(int value) {
        if (top == stack.length - 1) {  
            System.out.println("Stack Overflow");
            return;
        }
        //top++;
        //stack[top++];
        stack[++top] = value; 
        System.out.println(value + " pushed onto stack");
    }

    int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return stack[top--]; 
    }

    int peek() {
        if (isEmpty()) {
            return -1;
        }

        return stack[top];
    }

    boolean isEmpty() {
        return top == -1;
    }

    boolean isFull() {
        return top == stack.length - 1;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Stack elements (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter stack capacity: ");
        int capacity = scanner.nextInt();

        if (capacity <= 0) {
            System.out.println("Capacity must be greater than zero");
            scanner.close();
            return;
        }

        StackArrayIntDemo stack = new StackArrayIntDemo(capacity);

        while (true) {
            System.out.println();
            System.out.println("Integer Stack Using Array");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    stack.push(scanner.nextInt());
                    break;
                case 2:
                    if (!stack.isEmpty()) {
                        System.out.println(stack.pop() + " popped from stack");
                    } else {
                        stack.pop();
                    }
                    break;
                case 3:
                    if (stack.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Top element: " + stack.peek());
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
