import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Day 1 - Designing an ADT in Java.
 *
 * The ADT is an INTERFACE with a clear contract (what each operation does,
 * what happens on an empty stack, expected complexity).
 * Implementations are hidden behind it. Client code depends only on the interface.
 *
 * (On Day 2 we write our OWN array-based implementation from scratch.)
 */
interface StackADT<T> {
    /** Adds item on top. Expected O(1). */
    void push(T item);

    /** Removes and returns the top item. Throws NoSuchElementException if empty. Expected O(1). */
    T pop();

    /** Returns the top item without removing it. Throws NoSuchElementException if empty. */
    T peek();

    boolean isEmpty();

    int size();
}

/** Implementation 1: wraps a java.util.ArrayDeque (adapter pattern). */
class DequeStack<T> implements StackADT<T> {
    private final ArrayDeque<T> data = new ArrayDeque<>();
    public void push(T item) { data.push(item); }
    public T pop()  { if (data.isEmpty()) throw new NoSuchElementException("stack empty"); return data.pop(); }
    public T peek() { if (data.isEmpty()) throw new NoSuchElementException("stack empty"); return data.peek(); }
    public boolean isEmpty() { return data.isEmpty(); }
    public int size() { return data.size(); }
}

/** Implementation 2: uses the END of an ArrayList as the top (add/remove at end are O(1) amortised). */
class ListStack<T> implements StackADT<T> {
    private final ArrayList<T> data = new ArrayList<>();
    public void push(T item) { data.add(item); }
    public T pop()  { if (data.isEmpty()) throw new NoSuchElementException("stack empty"); return data.remove(data.size() - 1); }
    public T peek() { if (data.isEmpty()) throw new NoSuchElementException("stack empty"); return data.get(data.size() - 1); }
    public boolean isEmpty() { return data.isEmpty(); }
    public int size() { return data.size(); }
}

public class StackAdtDemo {

    // CLIENT code: written once, against the ADT only
    static String reverse(String s, StackADT<Character> stack) {
        for (char c : s.toCharArray()) stack.push(c);
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }   

    public static void main(String[] args) {
        System.out.println(reverse("ALGORITHM", new DequeStack<>()));
        System.out.println(reverse("ALGORITHM", new ListStack<>()));   // swap implementation: client unchanged

        StackADT<Integer> st = new DequeStack<>();
        try {
            st.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Contract respected: " + e.getMessage());
        }
    }
}
