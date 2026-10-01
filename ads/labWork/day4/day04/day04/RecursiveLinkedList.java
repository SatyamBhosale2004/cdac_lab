/**
 * Day 4 - Recursion on a linked list: a list is either EMPTY (null)
 * or a node followed by a SMALLER list. That definition is itself recursive.
 * (Includes the Day 2 home challenge: reverse a linked list recursively.)
 */
public class RecursiveLinkedList {

    static class Node {
        int data; Node next;
        Node(int data, Node next) { this.data = data; this.next = next; }
    }

    static int length(Node n) {                  // O(n) time, O(n) stack
        if (n == null) return 0;
        return 1 + length(n.next);
    }

    static void printForward(Node n) {
        if (n == null) { System.out.println("null"); return; }
        System.out.print(n.data + " -> ");
        printForward(n.next);
    }

    static void printBackward(Node n) {          // head recursion: print while returning
        if (n == null) return;
        printBackward(n.next);
        System.out.print(n.data + " ");
    }

    static boolean contains(Node n, int x) {
        if (n == null) return false;
        return n.data == x || contains(n.next, x);
    }

    // Reverse: reverse the REST, then hang the current node at its end
    static Node reverse(Node head) {
        if (head == null || head.next == null) return head;   // 0 or 1 node: already reversed
        Node newHead = reverse(head.next);                    // trust the recursion
        head.next.next = head;                                // the node after me now points back to me
        head.next = null;                                     // I am the new last node
        return newHead;
    }

    public static void main(String[] args) {
        Node list = new Node(10, new Node(20, new Node(30, new Node(40, null))));
        System.out.print("forward : "); printForward(list);
        System.out.print("backward: "); printBackward(list); System.out.println();
        System.out.println("length = " + length(list) + ", contains 30? " + contains(list, 30));
        list = reverse(list);
        System.out.print("reversed: "); printForward(list);

        // Recursion depth = list length. Very long lists overflow the stack:
        Node big = null;
        for (int i = 0; i < 1_000_000; i++) big = new Node(i, big);
        try {
            System.out.println("length of 1,000,000-node list = " + length(big));
        } catch (StackOverflowError e) {
            System.out.println("length() of a 1,000,000-node list -> StackOverflowError. Use a loop for long lists!");
        }
    }
}
