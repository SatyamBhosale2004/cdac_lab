import java.util.Scanner;

public class QueueUsingLinkedListIntDemo {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    void enqueue(int value) {
        Node newNode = new Node(value);

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

    Integer dequeue() {
        if (isEmpty()) {
            return null;
        }

        int removed = front.data;
        front = front.next;
        size--;

        if (front == null) {
            rear = null;
        }

        return removed;
    }

    Integer peek() {
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
        Node current = front;

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
        QueueUsingLinkedListIntDemo queue = new QueueUsingLinkedListIntDemo();

        while (true) {
            System.out.println();
            System.out.println("Int Queue Using Linked List");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Peek");
            System.out.println("4. Display");
            System.out.println("5. Size");
            System.out.println("6. Exit");

            int choice = readInt(scanner, "Enter your choice: ");

            switch (choice) {
                case 1:
                    int value = readInt(scanner, "Enter value to enqueue: ");
                    queue.enqueue(value);
                    break;
                case 2:
                    Integer removed = queue.dequeue();
                    if (removed == null) {
                        System.out.println("Queue Underflow");
                    } else {
                        System.out.println(removed + " removed from queue");
                    }
                    break;
                case 3:
                    Integer frontValue = queue.peek();
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