import java.util.Arrays;

/**
 * Day 2 - Linear queue on an array (FIFO) and its big problem.
 * enqueue at rear, dequeue at front - both O(1).
 * Problem: front only moves forward, so freed slots at the start are never reused.
 */
public class LinearQueue {

    private final int[] data;
    private int front = 0;      // index of the first element
    private int rear = -1;      // index of the last element

    public LinearQueue(int capacity) { data = new int[capacity]; }

    public boolean isEmpty() { return front > rear; }
    public boolean isFull()  { return rear == data.length - 1; }   // "full" = rear reached the end!

    public void enqueue(int x) {
        if (isFull()) throw new IllegalStateException("Queue overflow (rear is at the end)");
        data[++rear] = x;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue underflow");
        int x = data[front];
        data[front++] = 0;       // clear, just for display
        return x;
    }

    @Override public String toString() {
        return Arrays.toString(data) + "  front=" + front + " rear=" + rear;
    }

    public static void main(String[] args) {
        LinearQueue q = new LinearQueue(5);
        for (int x : new int[]{10, 20, 30, 40, 50}) q.enqueue(x);
        System.out.println("after 5 enqueues : " + q);
        System.out.println("dequeue -> " + q.dequeue() + ", " + q.dequeue() + ", " + q.dequeue());
        System.out.println("after 3 dequeues : " + q);
        try {
            q.enqueue(60);
        } catch (IllegalStateException e) {
            System.out.println("enqueue 60       : " + e.getMessage());
            System.out.println("...but 3 slots at the front are EMPTY. Fix: circular queue.");
        }
    }
}
