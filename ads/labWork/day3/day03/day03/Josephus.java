/**
 * Day 3 - The Josephus problem with a circular linked list.
 * n people stand in a circle. Counting starts at person 1; every k-th person is removed.
 * Who is the last one standing?
 * With a circular list, "go round the circle" is just following next pointers.
 * Time O(n * k).
 */
public class Josephus {

    static class Node {
        int id; Node next;
        Node(int id) { this.id = id; }
    }

    static int solve(int n, int k, boolean trace) {
        // build the circle 1 -> 2 -> ... -> n -> back to 1
        Node first = new Node(1), prev = first;
        for (int i = 2; i <= n; i++) { prev.next = new Node(i); prev = prev.next; }
        prev.next = first;                       // close the ring; prev is now the node BEFORE person 1

        StringBuilder order = new StringBuilder();
        while (prev.next != prev) {              // more than one person left
            for (int c = 1; c < k; c++) prev = prev.next;   // move k-1 steps
            Node out = prev.next;                // this is the k-th person
            order.append(out.id).append(' ');
            prev.next = out.next;                // remove from the circle in O(1)
        }
        if (trace) System.out.println("  elimination order: " + order);
        return prev.id;
    }

    public static void main(String[] args) {
        System.out.println("n = 7, k = 3");
        System.out.println("  survivor: " + solve(7, 3, true));
        System.out.println("n = 41, k = 3 (the original story): survivor = " + solve(41, 3, false));
    }
}
