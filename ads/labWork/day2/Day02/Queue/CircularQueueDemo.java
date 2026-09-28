import java.util.Scanner;

public class CircularQueueDemo {

    int max = 5;
    int[] queue = new int[max];
    int front = -1;
    int rear = -1;

    boolean isFull() {
        return (front == 0 && rear == max - 1) || (rear + 1 == front);
    }

    boolean isEmpty() {
        return front == -1;
    }

    void enqueue(int value) {
        if (isFull()) {
            System.out.println("Circular Queue Overflow");
            return;
        }

        if (isEmpty()) {
            front = 0;
            rear = 0;
        } else if (rear == max - 1) {
            rear = 0;
        } else {
            rear++;
        }

        queue[rear] = value;
        System.out.println(value + " inserted into circular queue");
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Circular Queue Underflow");
            return -1;
        }

        int removed = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == max - 1) {
            front = 0;
        } else {
            front++;
        }

        return removed;
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Circular queue is empty");
            return;
        }

        System.out.print("Circular queue elements: ");
        int i = front;

        while (true) {
            System.out.print(queue[i] + " ");
            if (i == rear) {
                break;
            }
            i = (i + 1) % max;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CircularQueueDemo circularQueue = new CircularQueueDemo();

        while (true) {
            System.out.println("\nCircular Queue Operations:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = scanner.nextInt();
                    circularQueue.enqueue(value);
                    break;
                case 2:
                    int removed = circularQueue.dequeue();
                    if (removed != -1) {
                        System.out.println(removed + " removed from circular queue");
                    }
                    break;
                case 3:
                    circularQueue.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
