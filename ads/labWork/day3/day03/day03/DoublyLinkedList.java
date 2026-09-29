import java.util.NoSuchElementException;

/**
 * Day 3 - Doubly linked list (generic).
 *
 *   null <- [prev|10|next] <-> [prev|20|next] <-> [prev|30|next] -> null
 *            ^ head                                 ^ tail
 * Every node knows BOTH neighbours, so we can walk backwards and
 * remove the last node in O(1). This is how java.util.LinkedList is built.
 */
public class DoublyLinkedList<T> {

    private static class Node<T> {
        T data;
        Node<T> prev, next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head, tail;
    private int size;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // O(1)
    public void addFirst(T x) {
        Node<T> n = new Node<>(x);
        if (head == null) { head = tail = n; }
        else { n.next = head; head.prev = n; head = n; }
        size++;
    }

    // O(1)
    public void addLast(T x) {
        Node<T> n = new Node<>(x);
        if (tail == null) { head = tail = n; }
        else { n.prev = tail; tail.next = n; tail = n; }
        size++;
    }

    // O(n) - but walks from the NEARER end, like java.util.LinkedList.node(index)
    public void add(int index, T x) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("index " + index);
        if (index == 0) { addFirst(x); return; }
        if (index == size) { addLast(x); return; }
        Node<T> after = nodeAt(index);          // new node goes BEFORE this one
        Node<T> before = after.prev;
        Node<T> n = new Node<>(x);
        n.prev = before;                        // 1
        n.next = after;                         // 2
        before.next = n;                        // 3
        after.prev = n;                         // 4
        size++;
    }

    // O(1)
    public T removeFirst() {
        if (head == null) throw new NoSuchElementException("list empty");
        T x = head.data;
        head = head.next;
        if (head == null) tail = null; else head.prev = null;
        size--;
        return x;
    }

    // O(1) - the big improvement over a singly linked list
    public T removeLast() {
        if (tail == null) throw new NoSuchElementException("list empty");
        T x = tail.data;
        tail = tail.prev;
        if (tail == null) head = null; else tail.next = null;
        size--;
        return x;
    }

    // Unlink a node we already hold: O(1)
    private T unlink(Node<T> n) {
        if (n.prev == null) head = n.next; else n.prev.next = n.next;
        if (n.next == null) tail = n.prev; else n.next.prev = n.prev;
        n.prev = n.next = null;                 // help the GC
        size--;
        return n.data;
    }

    // O(n) to find, O(1) to unlink
    public boolean remove(T x) {
        for (Node<T> cur = head; cur != null; cur = cur.next) {
            if (x == null ? cur.data == null : x.equals(cur.data)) { unlink(cur); return true; }
        }
        return false;
    }

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index " + index);
        return nodeAt(index).data;
    }

    static int steps;   // how many links we followed in the last nodeAt()

    private Node<T> nodeAt(int index) {
        steps = 0;
        if (index < size / 2) {                 // first half: walk forward from head
            Node<T> cur = head;
            for (int i = 0; i < index; i++) { cur = cur.next; steps++; }
            return cur;
        } else {                                // second half: walk backward from tail
            Node<T> cur = tail;
            for (int i = size - 1; i > index; i--) { cur = cur.prev; steps++; }
            return cur;
        }
    }

    public String forward() {
        StringBuilder sb = new StringBuilder("head: ");
        for (Node<T> c = head; c != null; c = c.next) sb.append(c.data).append(c.next != null ? " <-> " : "");
        return sb.toString();
    }

    public String backward() {
        StringBuilder sb = new StringBuilder("tail: ");
        for (Node<T> c = tail; c != null; c = c.prev) sb.append(c.data).append(c.prev != null ? " <-> " : "");
        return sb.toString();
    }

    public static void main(String[] args) {
        DoublyLinkedList<Integer> d = new DoublyLinkedList<>();
        d.addLast(20); d.addLast(40); d.addFirst(10);
        System.out.println("addLast 20, 40; addFirst 10 -> " + d.forward());
        d.add(2, 30);
        System.out.println("add(2, 30)                   -> " + d.forward());
        System.out.println("walk backwards               -> " + d.backward());
        System.out.println("removeLast -> " + d.removeLast() + "   removeFirst -> " + d.removeFirst() + "   " + d.forward());
        d.remove(20);
        System.out.println("remove(20)                   -> " + d.forward());

        DoublyLinkedList<Integer> big = new DoublyLinkedList<>();
        for (int i = 0; i < 1000; i++) big.addLast(i);
        big.get(10);  System.out.println("get(10)  on 1000 nodes: followed " + steps + " links (from head)");
        big.get(990); System.out.println("get(990) on 1000 nodes: followed " + steps + " links (from tail)");
        big.get(500); System.out.println("get(500) on 1000 nodes: followed " + steps + " links (worst case ~ n/2)");
    }
}
