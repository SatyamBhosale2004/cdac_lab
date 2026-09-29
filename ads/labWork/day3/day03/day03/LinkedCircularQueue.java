import java.util.NoSuchElementException;

/**
 * Day 3 LAB - Circular queue implemented with a linked list (syllabus lab).
 * The nodes form a ring: rear.next is always the front.
 * We keep ONE reference (rear) and an optional capacity limit,
 * so it behaves like the array circular queue of Day 2 - but no modulo arithmetic.
 *
 *   enqueue: insert a node after rear, then move rear to it   O(1)
 *   dequeue: remove rear.next (the front)                     O(1)
 */
public class LinkedCircularQueue<T> {

    private static class Node<T> {
        T data; Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> rear;           // rear.next == front
    private int size;
    private final int capacity;     // Integer.MAX_VALUE = unbounded

    public LinkedCircularQueue(int capacity) { this.capacity = capacity; }

    public boolean isEmpty() { return rear == null; }
    public boolean isFull() { return size == capacity; }
    public int size() { return size; }

    public void enqueue(T x) {
        if (isFull()) throw new IllegalStateException("Queue overflow (capacity " + capacity + ")");
        Node<T> n = new Node<>(x);
        if (rear == null) {
            n.next = n;                 // single node: points to itself
        } else {
            n.next = rear.next;         // new node points to the front
            rear.next = n;              // old rear points to the new node
        }
        rear = n;                       // new node becomes the rear
        size++;
    }

    public T dequeue() {
        if (rear == null) throw new NoSuchElementException("Queue underflow");
        Node<T> front = rear.next;
        if (front == rear) rear = null; // it was the only node
        else rear.next = front.next;    // bypass the old front
        size--;
        return front.data;
    }

    public T peek() {
        if (rear == null) throw new NoSuchElementException("Queue is empty");
        return rear.next.data;
    }

    @Override public String toString() {
        if (rear == null) return "(empty)";
        StringBuilder sb = new StringBuilder("front -> ");
        Node<T> c = rear.next;
        do { sb.append(c.data).append(' '); c = c.next; } while (c != rear.next);
        return sb.append("<- rear (rear.next = ").append(rear.next.data).append(")").toString();
    }

    public static void main(String[] args) {
        LinkedCircularQueue<Integer> q = new LinkedCircularQueue<>(4);
        q.enqueue(10); q.enqueue(20); q.enqueue(30);
        System.out.println(q);
        System.out.println("dequeue -> " + q.dequeue() + "   " + q);
        q.enqueue(40); q.enqueue(50);
        System.out.println("enqueue 40, 50 -> " + q + "  full=" + q.isFull());
        try { q.enqueue(60); } catch (IllegalStateException e) { System.out.println("enqueue 60 -> " + e.getMessage()); }
        while (!q.isEmpty()) System.out.print(q.dequeue() + " ");
        System.out.println("<- dequeued in FIFO order");
    }
}
