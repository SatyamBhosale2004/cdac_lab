import java.util.Scanner;

public class StackUsingLinkedListIntDemo {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;
    private int size;

    void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    Integer pop() {
        if (isEmpty()) {
            return null;
        }

        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

    Integer peek() {
        return isEmpty() ? null : top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    int size() {
        return size;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.print("Stack elements (top to bottom): ");
        Node current = top;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    private static int readInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }

            System.out.println("Please enter a valid integer.");
            scanner.next();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackUsingLinkedListIntDemo stack = new StackUsingLinkedListIntDemo();

        while (true) {
            System.out.println();
            System.out.println("Int Stack Using Linked List");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Exit");

            int choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    int value = readInt(scanner, "Enter value to push: ");
                    stack.push(value);
                    System.out.println(value + " pushed onto stack");
                    break;
                case 2:
                    Integer removed = stack.pop();
                    if (removed == null) {
                        System.out.println("Stack Underflow");
                    } else {
                        System.out.println(removed + " popped from stack");
                    }
                    break;
                case 3:
                    Integer topValue = stack.peek();
                    if (topValue == null) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Top element: " + topValue);
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Size: " + stack.size());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}