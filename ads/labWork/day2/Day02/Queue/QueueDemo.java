import java.util.Scanner;

public class QueueDemo {

    int max = 5;
    int[] queue = new int[max];
    int front = -1;
    int rear = -1;

    void enqueue(int value) {
        if (rear == max - 1) {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        queue[++rear] = value;
        System.out.println(value + " inserted into queue");
    }

    int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int removed = queue[front++]; //10

        if (front > rear) {
            front = -1;
            rear = -1;
        }

        return removed;
    }

    boolean isEmpty() {
        return front == -1;   // 0 == -1
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueDemo queueDemo = new QueueDemo();

        while (true) {
            System.out.println("\nQueue Operations:");
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
                    queueDemo.enqueue(value);
                    break;
                case 2:
                    int removed = queueDemo.dequeue();
                    if (removed != -1) {
                        System.out.println(removed + " removed from queue");
                    }
                    break;
                case 3:
                    queueDemo.display();
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
