import java.util.NoSuchElementException;

/**
 * Day 3 - Circular singly linked list.
 * The last node points back to the first: tail.next == head.
 * We keep ONLY a tail reference - the head is always tail.next.
 * That gives O(1) addFirst, addLast and removeFirst with one pointer.
 */
public class CircularLinkedList<T> {

    private static class Node<T> {
        T data; Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> tail;      // tail.next is the head
    private int size;

    public int size() { return size; }
    public boolean isEmpty() { return tail == null; }

    public void addFirst(T x) {                 // O(1): insert right after tail
        Node<T> n = new Node<>(x);
        if (tail == null) { n.next = n; tail = n; }  // one node points to itself
        else { n.next = tail.next; tail.next = n; }
        size++;
    }

    public void addLast(T x) {                  // O(1): addFirst, then move tail forward
        addFirst(x);
        tail = tail.next;
    }

    public T removeFirst() {                    // O(1)
        if (tail == null) throw new NoSuchElementException("list empty");
        Node<T> head = tail.next;
        if (head == tail) tail = null;          // it was the only node
        else tail.next = head.next;
        size--;
        return head.data;
    }

    public T first() { if (tail == null) throw new NoSuchElementException(); return tail.next.data; }

    // Move the first element to the end: round-robin in O(1)
    public void rotate() { if (tail != null) tail = tail.next; }

    @Override public String toString() {
        if (tail == null) return "(empty)";
        StringBuilder sb = new StringBuilder();
        Node<T> cur = tail.next;
        do {                                    // do-while: we must stop when we come back to the start
            sb.append(cur.data).append(" -> ");
            cur = cur.next;
        } while (cur != tail.next);
        return sb.append("(back to ").append(tail.next.data).append(")").toString();
    }

    public static void main(String[] args) {
        CircularLinkedList<String> tasks = new CircularLinkedList<>();
        tasks.addLast("P1"); tasks.addLast("P2"); tasks.addLast("P3"); tasks.addFirst("P0");
        System.out.println("ring: " + tasks);

        System.out.println("\nRound-robin CPU scheduling, 7 time slices:");
        for (int slice = 1; slice <= 7; slice++) {
            System.out.println("  slice " + slice + ": run " + tasks.first());
            tasks.rotate();
        }
        System.out.println("\nremoveFirst -> " + tasks.removeFirst() + "   ring: " + tasks);
    }
}
