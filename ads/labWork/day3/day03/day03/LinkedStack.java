import java.util.NoSuchElementException;

/**
 * Day 3 LAB - Stack implemented with a linked list (syllabus lab).
 * push and pop both work at the HEAD, so both are O(1).
 * No fixed capacity -> no overflow (until the JVM runs out of memory).
 */
public class LinkedStack<T> {

    private static class Node<T> {
        T data; Node<T> next;
        Node(T data, Node<T> next) { this.data = data; this.next = next; }
    }

    private Node<T> top;       // the head of the list is the top of the stack
    private int size;

    public void push(T x) {
        top = new Node<>(x, top);          // new node points to the old top
        size++;
    }

    public T pop() {
        if (top == null) throw new NoSuchElementException("Stack underflow");
        T x = top.data;
        top = top.next;
        size--;
        return x;
    }

    public T peek() {
        if (top == null) throw new NoSuchElementException("Stack is empty");
        return top.data;
    }

    public boolean isEmpty() { return top == null; }
    public int size() { return size; }

    @Override public String toString() {
        StringBuilder sb = new StringBuilder("top -> ");
        for (Node<T> c = top; c != null; c = c.next) sb.append(c.data).append(" -> ");
        return sb.append("null").toString();
    }

    public static void main(String[] args) {
        LinkedStack<String> s = new LinkedStack<>();
        s.push("A"); s.push("B"); s.push("C");
        System.out.println(s);
        System.out.println("pop -> " + s.pop() + ", peek -> " + s.peek() + "   " + s);
        for (int i = 0; i < 100_000; i++) s.push("x");          // no overflow: grows as needed
        System.out.println("after 100,000 more pushes, size = " + s.size());
        try { new LinkedStack<Integer>().pop(); } catch (NoSuchElementException e) { System.out.println(e.getMessage()); }
    }
}
