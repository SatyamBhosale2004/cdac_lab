import java.util.Scanner;

public class QDemoGeneric<T> {

    int max = 100;
    Object[] queue = new Object[max];
    int front = -1;
    int rear = -1;

    void enqueue(T value) {
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

    @SuppressWarnings("unchecked")
    T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return null;
        }

        T removed = (T) queue[front++];

        if (front > rear) {
            front = -1;
            rear = -1;
        }

        return removed;
    }

    boolean isEmpty() {
        return front == -1;
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
        QDemoGeneric<Integer> queueDemo = new QDemoGeneric<>();
        QDemoGeneric<String> textQueue = new QDemoGeneric<>();

        textQueue.enqueue("A");
        textQueue.enqueue("B");
        System.out.println("String queue demo:");
        textQueue.display();
        System.out.println("Dequeued from String queue: " + textQueue.dequeue());

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
                    Integer removed = queueDemo.dequeue();
                    if (removed != null) {
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
