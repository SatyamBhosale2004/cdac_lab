import java.util.Arrays;

/**
 * Day 3 - Node-based storage with arrays (a "cursor" linked list).
 * No Node objects at all: node i is  data[i]  plus  next[i]  (the index of the next node).
 * -1 plays the role of null.
 * Free slots are themselves kept in a linked list (the "free list"), so allocate and free are O(1).
 * Used where objects/pointers are unavailable or too costly: memory pools, embedded code,
 * and file systems such as FAT, whose File Allocation Table is exactly a next[] array.
 */
public class ArrayLinkedList {

    private final int[] data;
    private final int[] next;
    private int head = -1;      // first node of the list
    private int free = 0;       // first free slot
    private int size;

    public ArrayLinkedList(int capacity) {
        data = new int[capacity];
        next = new int[capacity];
        for (int i = 0; i < capacity - 1; i++) next[i] = i + 1;   // chain all slots into the free list
        next[capacity - 1] = -1;
    }

    private int allocate() {                        // take a slot from the free list: O(1)
        if (free == -1) throw new IllegalStateException("no free slots");
        int slot = free;
        free = next[slot];
        return slot;
    }

    private void release(int slot) {                // give a slot back: O(1)
        next[slot] = free;
        free = slot;
    }

    public void addFirst(int x) {
        int s = allocate();
        data[s] = x;
        next[s] = head;
        head = s;
        size++;
    }

    public void addAfter(int target, int x) {       // insert x after the first node holding target
        for (int i = head; i != -1; i = next[i]) {
            if (data[i] == target) {
                int s = allocate();
                data[s] = x;
                next[s] = next[i];
                next[i] = s;
                size++;
                return;
            }
        }
        throw new IllegalArgumentException(target + " not found");
    }

    public boolean remove(int x) {
        int prev = -1;
        for (int i = head; i != -1; prev = i, i = next[i]) {
            if (data[i] == x) {
                if (prev == -1) head = next[i]; else next[prev] = next[i];
                release(i);
                size--;
                return true;
            }
        }
        return false;
    }

    public void dump(String title) {
        StringBuilder list = new StringBuilder();
        for (int i = head; i != -1; i = next[i]) list.append(data[i]).append(" -> ");
        System.out.println(title);
        System.out.println("  list : " + list + "null      head=" + head + " free=" + free);
        System.out.println("  index: " + Arrays.toString(java.util.stream.IntStream.range(0, data.length).toArray()));
        System.out.println("  data : " + Arrays.toString(data));
        System.out.println("  next : " + Arrays.toString(next));
    }

    public static void main(String[] args) {
        ArrayLinkedList l = new ArrayLinkedList(6);
        l.dump("empty (all slots on the free list):");
        l.addFirst(30); l.addFirst(10);
        l.addAfter(10, 20);
        l.dump("\nafter addFirst 30, addFirst 10, addAfter(10, 20):");
        l.remove(10);
        l.dump("\nafter remove(10) - slot 1 goes back to the free list:");
        l.addFirst(5);
        l.dump("\nafter addFirst 5 - slot 1 is reused:");
    }
}
