import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Day 2 LAB - Deque (double-ended queue): insert and delete at BOTH ends in O(1).
 * Covers the syllabus lab "queue with inserting element at different location (First, Last)".
 * Circular array + growth - this is essentially how java.util.ArrayDeque works.
 *
 *   addFirst : front = (front - 1 + cap) % cap      (step back, wrapping to the end)
 *   addLast  : put at (front + size) % cap
 */
public class CircularDeque<T> {

    private Object[] data;
    private int front = 0;
    private int size = 0;

    public CircularDeque(int capacity) { data = new Object[Math.max(1, capacity)]; }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public void addFirst(T item) {
        if (size == data.length) grow();
        front = (front - 1 + data.length) % data.length;   // + length keeps it non-negative
        data[front] = item;
        size++;
    }

    public void addLast(T item) {
        if (size == data.length) grow();
        data[(front + size) % data.length] = item;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("deque empty");
        T item = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T removeLast() {
        if (isEmpty()) throw new NoSuchElementException("deque empty");
        int last = (front + size - 1) % data.length;
        T item = (T) data[last];
        data[last] = null;
        size--;
        return item;
    }

    @SuppressWarnings("unchecked") public T peekFirst() { return isEmpty() ? null : (T) data[front]; }
    @SuppressWarnings("unchecked") public T peekLast()  { return isEmpty() ? null : (T) data[(front + size - 1) % data.length]; }

    // Copy into a bigger array IN ORDER, so the ring starts again at index 0. O(n), rare -> amortised O(1)
    private void grow() {
        Object[] bigger = new Object[data.length * 2];
        for (int k = 0; k < size; k++) bigger[k] = data[(front + k) % data.length];
        data = bigger;
        front = 0;
    }

    public String raw() { return Arrays.toString(data) + " front=" + front + " size=" + size; }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder("first [ ");
        for (int k = 0; k < size; k++) sb.append(data[(front + k) % data.length]).append(' ');
        return sb.append("] last").toString();
    }

    public static void main(String[] args) {
        CircularDeque<String> d = new CircularDeque<>(4);
        d.addLast("B");  System.out.println("addLast B    " + d + "     raw " + d.raw());
        d.addLast("C");  System.out.println("addLast C    " + d + "   raw " + d.raw());
        d.addFirst("A"); System.out.println("addFirst A   " + d + " raw " + d.raw());
        d.addFirst("Z"); System.out.println("addFirst Z   " + d + " raw " + d.raw());
        d.addLast("D");  System.out.println("addLast D    " + d + " (grew) raw " + d.raw());
        System.out.println("removeFirst -> " + d.removeFirst() + ",  removeLast -> " + d.removeLast() + "   " + d);

        // One structure, two ADTs:
        CircularDeque<Integer> stack = new CircularDeque<>(2);   // use only one end  -> stack
        stack.addFirst(1); stack.addFirst(2); stack.addFirst(3);
        System.out.println("as a stack : " + stack.removeFirst() + " " + stack.removeFirst() + " " + stack.removeFirst());
        CircularDeque<Integer> queue = new CircularDeque<>(2);   // add at one end, remove at the other -> queue
        queue.addLast(1); queue.addLast(2); queue.addLast(3);
        System.out.println("as a queue : " + queue.removeFirst() + " " + queue.removeFirst() + " " + queue.removeFirst());
    }
}
