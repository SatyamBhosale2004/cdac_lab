import java.util.Arrays;

/**
 * Day 2 - Build our own ArrayList: a dynamic (resizable) array.
 * When the array is full we allocate a bigger one and copy everything.
 * Growth by a FACTOR (x1.5, like java.util.ArrayList) keeps add() amortised O(1).
 */
public class DynamicArray<T> {

    private Object[] data;      // ArrayList calls this elementData
    private int size;           // how many slots are really used
    long copies;                // how many element copies we have made in total
    boolean verbose = true;     // print a line on every grow (turned off for big runs)

    public DynamicArray(int initialCapacity) {
        data = new Object[initialCapacity];
    }

    public int size() { return size; }
    public int capacity() { return data.length; }

    // Amortised O(1)
    public void add(T item) {
        if (size == data.length) grow();
        data[size++] = item;
    }

    // O(1) random access
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return (T) data[index];
    }

    public void set(int index, T item) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        data[index] = item;
    }

    // O(n): shift left
    @SuppressWarnings("unchecked")
    public T removeAt(int index) {
        T old = get(index);
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;            // clear the last slot so the GC can reclaim the object
        return old;
    }

    private void grow() {
        int oldCap = data.length;
        int newCap = Math.max(oldCap + (oldCap >> 1), oldCap + 1);   // same formula as ArrayList: old + old/2
        data = Arrays.copyOf(data, newCap);                             // O(n) copy
        copies += oldCap;
        if (verbose) System.out.printf("   grow: capacity %d -> %d (copied %d elements)%n", oldCap, newCap, oldCap);
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(data, size)) + "  size=" + size + " capacity=" + data.length;
    }

    public static void main(String[] args) {
        DynamicArray<Integer> list = new DynamicArray<>(4);
        for (int i = 1; i <= 20; i++) list.add(i * 10);
        System.out.println(list);
        System.out.println("removeAt(0) -> " + list.removeAt(0) + "   " + list);

        // Amortised analysis: total copies stay proportional to n
        System.out.println("\nAmortised cost check (growth x1.5):");
        for (int n = 1_000; n <= 1_000_000; n *= 10) {
            DynamicArray<Integer> d = new DynamicArray<>(4);
            d.verbose = false;
            for (int i = 0; i < n; i++) d.add(i);
            System.out.printf("n = %,9d   total copies = %,9d   copies per add = %.2f%n", n, d.copies, (double) d.copies / n);
        }
        System.out.println("Copies per add stays a small constant (~2-3) -> add() is amortised O(1).");
    }
}
