import java.util.Scanner;

public class QueueUsingStackDemo {

    private static class IntStack {
        private int[] data;
        private int top;

        IntStack(int capacity) {
            data = new int[capacity];
            top = -1;
        }

        boolean push(int value) {
            if (isFull()) {
                return false;
            }
            data[++top] = value;
            return true;
        }

        Integer pop() {
            if (isEmpty()) {
                return null;
            }
            return data[top--];
        }

        Integer peek() {
            if (isEmpty()) {
                return null;
            }
            return data[top];
        }

        boolean isEmpty() {
            return top == -1;
        }

        boolean isFull() {
            return top == data.length - 1;
        }

        int size() {
            return top + 1;
        }
    }

    private IntStack stackNewest;
    private IntStack stackOldest;

    QueueUsingStackDemo(int capacity) {
        stackNewest = new IntStack(capacity);
        stackOldest = new IntStack(capacity);
    }

    void enqueue(int value) {
        if (!stackNewest.push(value)) {
            System.out.println("Queue Overflow");
            return;
        }
        System.out.println(value + " inserted into queue");
    }

    Integer dequeue() {
        shiftStacksIfNeeded();
        Integer removed = stackOldest.pop();
        if (removed == null) {
            System.out.println("Queue Underflow");
        }
        return removed;
    }

    Integer peek() {
        shiftStacksIfNeeded();
        return stackOldest.peek();
    }

    boolean isEmpty() {
        return stackNewest.isEmpty() && stackOldest.isEmpty();
    }

    int size() {
        return stackNewest.size() + stackOldest.size();
    }

    void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        shiftStacksIfNeeded();
        System.out.print("Queue elements (front to rear): ");

        IntStack buffer = new IntStack(size());

        while (!stackOldest.isEmpty()) {
            Integer value = stackOldest.pop();
            if (value != null) {
                System.out.print(value + " ");
                buffer.push(value);
            }
        }

        while (!buffer.isEmpty()) {
            Integer value = buffer.pop();
            if (value != null) {
                stackOldest.push(value);
            }
        }

        System.out.println();
    }

    private void shiftStacksIfNeeded() {
        if (!stackOldest.isEmpty()) {
            return;
        }

        while (!stackNewest.isEmpty()) {
            Integer value = stackNewest.pop();
            if (value != null) {
                stackOldest.push(value);
            }
        }
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
        int capacity = readInt(scanner, "Enter queue capacity: ");

        if (capacity <= 0) {
            System.out.println("Capacity must be greater than 0");
            scanner.close();
            return;
        }

        QueueUsingStackDemo queue = new QueueUsingStackDemo(capacity);

        while (true) {
            System.out.println();
            System.out.println("Queue Using Two Stacks");
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
                    if (removed != null) {
                        System.out.println(removed + " removed from queue");
                    }
                    break;
                case 3:
                    Integer front = queue.peek();
                    if (front == null) {
                        System.out.println("Queue is empty");
                    } else {
                        System.out.println("Front element: " + front);
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

/*
Each method in QueueUsingStackDemo.java does this:

QueueUsingStackDemo.java:9
Creates one internal stack with a fixed array size and sets top to -1 (empty state).

QueueUsingStackDemo.java:14
Pushes a value onto the stack if there is space. Returns false on overflow, true on success.

QueueUsingStackDemo.java:22
Removes and returns the top value of that stack. Returns null if the stack is empty.

QueueUsingStackDemo.java:29
Returns the current top value without removing it. Returns null if empty.

QueueUsingStackDemo.java:36
Checks whether the stack has no elements (top == -1).

QueueUsingStackDemo.java:40
Checks whether the stack array is full (top at last index).

QueueUsingStackDemo.java:44
Returns number of elements currently in that stack.

QueueUsingStackDemo.java:52
Queue constructor. Creates two stacks of the same capacity:

stackNewest: receives all new enqueue values
stackOldest: serves dequeue/peek in correct queue order
QueueUsingStackDemo.java:57
Adds value to queue by pushing into stackNewest.
If stackNewest is full, prints Queue Overflow.

QueueUsingStackDemo.java:65
Removes front element of queue.
First calls shiftStacksIfNeeded so oldest element is at top of stackOldest, then pops from stackOldest.
If both stacks are empty, prints Queue Underflow and returns null.

QueueUsingStackDemo.java:74
Returns queue front without removing it.
Also depends on shiftStacksIfNeeded to ensure correct element order.

QueueUsingStackDemo.java:79
Queue is empty only when both stacks are empty.

QueueUsingStackDemo.java:83
Total queue size = size of stackNewest + size of stackOldest.

QueueUsingStackDemo.java:87
Prints queue from front to rear.
It first ensures queue order is in stackOldest (via shiftStacksIfNeeded), then:

pops stackOldest one by one to print
stores popped values in temporary buffer stack
pushes back from buffer to restore original queue state
So display does not permanently change queue contents.
QueueUsingStackDemo.java:116
Core helper for queue behavior using two stacks.
Only when stackOldest is empty, it moves all elements from stackNewest to stackOldest.
This reversal makes FIFO possible:
newest stack has reverse-insertion order
moving reverses again, putting oldest at top of stackOldest
QueueUsingStackDemo.java:129
Utility for safe integer input. Keeps asking until user enters a valid int.

public static void main(String[] args)
Interactive driver:

asks capacity
exits if capacity <= 0
creates queue
runs menu loop for enqueue, dequeue, peek, display, size, exit
Quick behavior summary:

Enqueue is O(1) normally.
Dequeue/peek are amortized O(1), with occasional O(n) shift when stackOldest is empty.
No collection framework is used; everything is custom array stack logic.
*/