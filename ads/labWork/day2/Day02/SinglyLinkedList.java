import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Day 2 - Singly linked list (generic) with head, tail and size.
 *
 *   head -> [10|*] -> [20|*] -> [30|null]
 *                                  ^ tail
 * Each node stores data + a reference to the next node.
 * Implements Iterable<T>, so the for-each loop works - just like java.util collections.
 */
public class SinglyLinkedList<T> implements Iterable<T> {

    private static class Node<T> {     // static nested class: a node does not need the outer list
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // O(1)
    public void addFirst(T x) {
        Node<T> n = new Node<>(x);
        n.next = head;                 // 1. new node points to old head
        head = n;                      // 2. head moves to new node
        if (tail == null) tail = n;    // list was empty
        size++;
    }

    // O(1) because we keep a tail reference (O(n) without it)
    public void addLast(T x) {
        Node<T> n = new Node<>(x);
        if (tail == null) { head = tail = n; }
        else { tail.next = n; tail = n; }
        size++;
    }

    // O(n): walk to the node BEFORE the position
    public void add(int index, T x) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException("index " + index);
        if (index == 0) { addFirst(x); return; }
        if (index == size) { addLast(x); return; }
        Node<T> prev = nodeAt(index - 1);
        Node<T> n = new Node<>(x);
        n.next = prev.next;            // ORDER MATTERS: link the new node first...
        prev.next = n;                 // ...then redirect prev. Swap these and the rest of the list is lost!
        size++;
    }

    // O(1)
    public T removeFirst() {
        if (head == null) throw new NoSuchElementException("list empty");
        T x = head.data;
        head = head.next;              // the old head has no references left -> garbage collected
        if (head == null) tail = null;
        size--;
        return x;
    }

    // O(n): a singly linked list cannot go backwards, so we must find the node before tail
    public T removeLast() {
        if (head == null) throw new NoSuchElementException("list empty");
        if (head == tail) return removeFirst();
        Node<T> prev = head;
        while (prev.next != tail) prev = prev.next;
        T x = tail.data;
        prev.next = null;
        tail = prev;
        size--;
        return x;
    }

    // O(n): remove the first occurrence of x
    public boolean remove(T x) {
        if (head == null) return false;
        if (equal(head.data, x)) { removeFirst(); return true; }
        Node<T> prev = head;
        while (prev.next != null && !equal(prev.next.data, x)) prev = prev.next;
        if (prev.next == null) return false;           // not found
        if (prev.next == tail) tail = prev;
        prev.next = prev.next.next;                     // bypass the node
        size--;
        return true;
    }

    // O(n): linear search - no random access in a linked list
    public int indexOf(T x) {
        int i = 0;
        for (Node<T> cur = head; cur != null; cur = cur.next, i++)
            if (equal(cur.data, x)) return i;
        return -1;
    }

    // O(n)
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("index " + index);
        return nodeAt(index).data;
    }

    // O(n) time, O(1) space - classic interview question
    public void reverse() {
        Node<T> prev = null, cur = head;
        tail = head;
        while (cur != null) {
            Node<T> next = cur.next;   // 1. remember the rest of the list
            cur.next = prev;           // 2. turn this arrow around
            prev = cur;                // 3. move prev forward
            cur = next;                // 4. move cur forward
        }
        head = prev;
    }

    private Node<T> nodeAt(int index) {
        Node<T> cur = head;
        for (int i = 0; i < index; i++) cur = cur.next;
        return cur;
    }

    private static boolean equal(Object a, Object b) { return a == null ? b == null : a.equals(b); }

    @Override public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> cur = head;
            public boolean hasNext() { return cur != null; }
            public T next() {
                if (cur == null) throw new NoSuchElementException();
                T x = cur.data; cur = cur.next; return x;
            }
        };
    }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder("head -> ");
        for (T x : this) sb.append(x).append(" -> ");
        return sb.append("null").toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(20); list.addLast(30); list.addFirst(10);
        System.out.println("addLast 20, 30; addFirst 10 : " + list);
        list.add(2, 25);              System.out.println("add(2, 25)                  : " + list);
        list.addLast(40);             System.out.println("addLast 40                  : " + list);
        System.out.println("indexOf(30) = " + list.indexOf(30) + ",  get(3) = " + list.get(3) + ",  size = " + list.size());
        list.remove(Integer.valueOf(25)); System.out.println("remove 25                   : " + list);
        System.out.println("removeFirst -> " + list.removeFirst() + ", removeLast -> " + list.removeLast() + "   " + list);
        list.addLast(50); list.addLast(60);
        list.reverse();               System.out.println("reverse                     : " + list);
        int sum = 0;
        for (int x : list) sum += x;  // works because we implement Iterable
        System.out.println("for-each sum = " + sum);
    }
}
