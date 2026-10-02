/**
 * Day 5 - Recursive checks for the types of binary trees.
 */
public class TreeTypesCheck {

    static class Node {
        int key; Node left, right;
        Node(int k) { key = k; }
        Node(int k, Node l, Node r) { key = k; left = l; right = r; }
    }

    static int height(Node n) { return n == null ? -1 : 1 + Math.max(height(n.left), height(n.right)); }
    static int size(Node n)   { return n == null ? 0 : 1 + size(n.left) + size(n.right); }

    // FULL: every node has 0 or 2 children
    static boolean isFull(Node n) {
        if (n == null) return true;
        if ((n.left == null) != (n.right == null)) return false;      // exactly one child
        return isFull(n.left) && isFull(n.right);
    }

    // PERFECT: all internal nodes have 2 children and all leaves are on the same level  <=> size = 2^(h+1) - 1
    static boolean isPerfect(Node n) { return size(n) == (1 << (height(n) + 1)) - 1; }

    // COMPLETE: in array numbering (children of i at 2i+1, 2i+2) no index reaches size
    static boolean isComplete(Node n, int index, int size) {
        if (n == null) return true;
        if (index >= size) return false;                               // a gap before this node
        return isComplete(n.left, 2 * index + 1, size) && isComplete(n.right, 2 * index + 2, size);
    }

    // BALANCED (height-balanced): at every node the two subtree heights differ by at most 1. Returns -2 if not.
    static int balancedHeight(Node n) {
        if (n == null) return -1;
        int l = balancedHeight(n.left), r = balancedHeight(n.right);
        if (l == -2 || r == -2 || Math.abs(l - r) > 1) return -2;
        return 1 + Math.max(l, r);
    }

    // BST: every key within (min, max) allowed by its ancestors - checking only parent/child is a classic bug
    static boolean isBST(Node n, long min, long max) {
        if (n == null) return true;
        if (n.key <= min || n.key >= max) return false;
        return isBST(n.left, min, n.key) && isBST(n.right, n.key, max);
    }

    static void report(String name, Node t) {
        System.out.printf("%-28s full=%-5b complete=%-5b perfect=%-5b balanced=%-5b BST=%b%n", name,
                isFull(t), isComplete(t, 0, size(t)), isPerfect(t), balancedHeight(t) != -2, isBST(t, Long.MIN_VALUE, Long.MAX_VALUE));
    }

    public static void main(String[] args) {
        Node perfect = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(6, new Node(5), new Node(7)));
        Node complete = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(6, new Node(5), null));
        Node fullNotComplete = new Node(1, new Node(2), new Node(3, new Node(4), new Node(5)));
        Node degenerate = new Node(1, null, new Node(2, null, new Node(3, null, new Node(4))));
        Node trickyNotBST = new Node(10, new Node(5, null, new Node(12)), new Node(15));   // 12 is in the LEFT subtree of 10!
        report("perfect", perfect);
        report("complete (last level partial)", complete);
        report("full but not complete", fullNotComplete);
        report("degenerate (linked list)", degenerate);
        report("looks like BST, is not", trickyNotBST);
    }
}
