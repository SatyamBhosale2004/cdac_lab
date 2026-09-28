import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Day 2 LAB - Stack implemented with an array (syllabus lab).
 * LIFO: Last In, First Out. All operations O(1).
 *
 * Design choices (compare with Day 1 StackADT contract):
 *  - generic type T
 *  - fixed capacity: push on a full stack throws IllegalStateException (overflow)
 *  - pop / peek on an empty stack throw NoSuchElementException (underflow)
 */
public class ArrayStack<T> {

    private final T[] data;
    private int top = -1;           // index of the top element; -1 means empty

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        data = (T[]) new Object[capacity];   // Java cannot do "new T[capacity]" (type erasure)
    }

    public void push(T item) {
        if (isFull()) throw new IllegalStateException("Stack overflow: capacity " + data.length);
        data[++top] = item;                  // move top up, then store
    }

    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        T item = data[top];
        data[top--] = null;                  // avoid "loitering": let the GC reclaim the object
        return item;
    }

    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack is empty");
        return data[top];
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull()  { return top == data.length - 1; }
    public int size()        { return top + 1; }

    @Override
    public String toString() {                // bottom ... top
        return Arrays.toString(Arrays.copyOf(data, top + 1)) + "  <- top";
    }

    public static void main(String[] args) {
        ArrayStack<Integer> s = new ArrayStack<>(4);
        s.push(10); System.out.println("push 10   " + s);
        s.push(20); System.out.println("push 20   " + s);
        s.push(30); System.out.println("push 30   " + s);
        System.out.println("peek -> " + s.peek());
        System.out.println("pop  -> " + s.pop() + "   " + s);
        s.push(40); s.push(50);
        System.out.println("push 40, 50  " + s + "  full? " + s.isFull());
        try { s.push(60); } catch (IllegalStateException e) { System.out.println(e.getMessage()); }
        while (!s.isEmpty()) System.out.print(s.pop() + " ");
        System.out.println(" <- popped in LIFO order");
        try { s.pop(); } catch (NoSuchElementException e) { System.out.println(e.getMessage()); }
    }
}
