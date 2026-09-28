import java.util.NoSuchElementException;

/**
 * Day 2 LAB - Circular queue on an array (syllabus lab).
 * The array is treated as a ring: after the last index comes index 0.
 *     next = (i + 1) % capacity
 * We keep front and a COUNT (size). This avoids the classic "is it full or empty?"
 * confusion when front == rear. (java.util.concurrent.ArrayBlockingQueue does the same:
 * takeIndex, putIndex, count.)
 */
public class CircularQueue<T> {

    private final Object[] data;
    private int front = 0;    // index of the first element
    private int size = 0;     // number of elements

    public CircularQueue(int capacity) { data = new Object[capacity]; }

    public boolean isEmpty() { return size == 0; }
    public boolean isFull()  { return size == data.length; }
    public int size()        { return size; }

    // O(1)
    public void enqueue(T item) {
        if (isFull()) throw new IllegalStateException("Queue overflow");
        int rear = (front + size) % data.length;   // first free slot after the last element
        data[rear] = item;
        size++;
    }

    // O(1)
    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
        T item = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;           // wrap around
        size--;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Queue is empty");
        return (T) data[front];
    }

    /** Shows the raw array with F (front) and R (rear) markers - useful on the board. */
    public String dump() {
        StringBuilder sb = new StringBuilder("[");
        int rear = (front + size - 1 + data.length) % data.length;
        for (int i = 0; i < data.length; i++) {
            String v = data[i] == null ? "  ." : String.format("%3s", data[i]);
            String mark = (!isEmpty() && i == front ? "F" : "") + (!isEmpty() && i == rear ? "R" : "");
            sb.append(v).append(String.format("%-2s", mark)).append(i < data.length - 1 ? "|" : "");
        }
        return sb.append("]  size=").append(size).toString();
    }

    /** Elements in FIFO order. */
    @Override public String toString() {
        StringBuilder sb = new StringBuilder("front -> ");
        for (int k = 0; k < size; k++) sb.append(data[(front + k) % data.length]).append(' ');
        return sb.append("<- rear").toString();
    }

    public static void main(String[] args) {
        CircularQueue<Integer> q = new CircularQueue<>(5);
        for (int x : new int[]{10, 20, 30, 40, 50}) q.enqueue(x);
        System.out.println("enqueue 10..50    " + q.dump());
        q.dequeue(); q.dequeue(); q.dequeue();
        System.out.println("dequeue x3        " + q.dump());
        q.enqueue(60); System.out.println("enqueue 60 (wrap) " + q.dump());
        q.enqueue(70); System.out.println("enqueue 70        " + q.dump());
        q.enqueue(80); System.out.println("enqueue 80        " + q.dump() + "  full=" + q.isFull());
        System.out.println(q);
        try { q.enqueue(90); } catch (IllegalStateException e) { System.out.println("enqueue 90 -> " + e.getMessage()); }
    }
}
