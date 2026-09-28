import java.util.Scanner;

public class QueueUsingLinkedListGenericDemo<T> {

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private Node<T> front;
    private Node<T> rear;
    private int size;

    void enqueue(T value) {
        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }

        size++;
        System.out.println(value + " inserted into queue");
    }

    T dequeue() {
        if (isEmpty()) {
            return null;
        }

        T removed = front.data;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        return removed;
    }

    T peek() {
        return isEmpty() ? null : front.data;
    }

    boolean isEmpty() {
        return front == null;
    }

    int size() {
        return size;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements (front to rear): ");
        Node<T> current = front;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    private static String readText(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueUsingLinkedListGenericDemo<String> queue = new QueueUsingLinkedListGenericDemo<>();

        while (true) {
            System.out.println();
            System.out.println("Generic Queue Using Linked List");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid integer choice.");
                scanner.next();
                System.out.print("Enter your choice: ");
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String value = readText(scanner, "Enter value to enqueue: ");
                    queue.enqueue(value);
                    break;
                case 2:
                    String removed = queue.dequeue();
                    if (removed == null) {
                        System.out.println("Queue Underflow");
                    } else {
                        System.out.println(removed + " removed from queue");
                    }
                    break;
                case 3:
                    String frontValue = queue.peek();
                    if (frontValue == null) {
                        System.out.println("Queue is empty");
                    } else {
                        System.out.println("Front element: " + frontValue);
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Size: " + queue.size());
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