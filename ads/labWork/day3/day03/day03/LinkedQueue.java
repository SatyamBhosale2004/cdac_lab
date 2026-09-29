import java.util.NoSuchElementException;

/**
 * Day 3 - Queue implemented with a singly linked list.
 * enqueue at the TAIL (O(1) thanks to the tail reference),
 * dequeue at the HEAD (O(1)).
 * Why not the other way round? Removing the tail of a singly linked list is O(n).
 */
public class LinkedQueue<T> {

    private static class Node<T> {
        T data; Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> front, rear;
    private int size;

    public void enqueue(T x) {
        Node<T> n = new Node<>(x);
        if (rear == null) front = rear = n;
        else { rear.next = n; rear = n; }
        size++;
    }

    public T dequeue() {
        if (front == null) throw new NoSuchElementException("Queue underflow");
        T x = front.data;
        front = front.next;
        if (front == null) rear = null;     // queue became empty: fix rear too!
        size--;
        return x;
    }

    public T peek() { if (front == null) throw new NoSuchElementException(); return front.data; }
    public boolean isEmpty() { return front == null; }
    public int size() { return size; }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder("front -> ");
        for (Node<T> c = front; c != null; c = c.next) sb.append(c.data).append(' ');
        return sb.append("<- rear").toString();
    }

    public static void main(String[] args) {
        LinkedQueue<Integer> q = new LinkedQueue<>();
        q.enqueue(10); q.enqueue(20); q.enqueue(30);
        System.out.println(q);
        System.out.println("dequeue -> " + q.dequeue() + "   " + q);
        q.dequeue(); q.dequeue();
        System.out.println("after emptying: " + q + "  isEmpty=" + q.isEmpty());
        q.enqueue(40);
        System.out.println("enqueue 40 (rear was reset correctly): " + q);
    }
}
