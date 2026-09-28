import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Day 2 - The same ideas inside java.util.
 */
public class JavaQueuesDemo {
    public static void main(String[] args) {
        // 1. ArrayDeque as a STACK (push/pop/peek work on the FIRST end)
        Deque<String> stack = new ArrayDeque<>();
        stack.push("page1"); stack.push("page2"); stack.push("page3");
        System.out.println("Back button (stack): " + stack.pop() + " then " + stack.pop());

        // 2. ArrayDeque as a QUEUE (offer at the last end, poll from the first end)
        Queue<String> queue = new ArrayDeque<>();
        queue.offer("job1"); queue.offer("job2"); queue.offer("job3");
        System.out.println("Printer queue:       " + queue.poll() + " then " + queue.poll());

        // 3. Deque - both ends
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(2); dq.offerFirst(1); dq.offerLast(3);
        System.out.println("Deque: " + dq + "  pollLast=" + dq.pollLast() + "  pollFirst=" + dq.pollFirst());

        // 4. Two styles of the Queue contract: exception vs special value
        Queue<Integer> empty = new ArrayDeque<>();
        System.out.println("poll() on empty  -> " + empty.poll());
        System.out.println("peek() on empty  -> " + empty.peek());
        try { empty.remove(); } catch (NoSuchElementException e) { System.out.println("remove() on empty -> NoSuchElementException"); }

        // 5. ArrayDeque does not allow null (null is its "empty" signal from poll)
        try { dq.offer(null); } catch (NullPointerException e) { System.out.println("ArrayDeque.offer(null) -> NullPointerException"); }

        // 6. A BOUNDED circular queue in the JDK: ArrayBlockingQueue (fixed capacity)
        ArrayBlockingQueue<Integer> bounded = new ArrayBlockingQueue<>(2);
        System.out.println("offer 1: " + bounded.offer(1) + ", offer 2: " + bounded.offer(2) + ", offer 3 (full): " + bounded.offer(3));
    }
}
