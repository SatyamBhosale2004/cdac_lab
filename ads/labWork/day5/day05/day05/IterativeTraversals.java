import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Day 5 LAB - DFS traversals WITHOUT recursion, using an explicit stack.
 * Recursion uses the JVM call stack; here we manage our own stack on the heap,
 * so very deep trees cannot cause StackOverflowError.
 */
public class IterativeTraversals {

    static class Node {
        int data; Node left, right;
        Node(int d, Node l, Node r) { data = d; left = l; right = r; }
        Node(int d) { this(d, null, null); }
    }

    static void preorder(Node root) {
        Deque<Node> st = new ArrayDeque<>();
        if (root != null) st.push(root);
        while (!st.isEmpty()) {
            Node n = st.pop();
            System.out.print(n.data + " ");
            if (n.right != null) st.push(n.right);   // push RIGHT first so LEFT is processed first
            if (n.left != null) st.push(n.left);
        }
    }

    static void inorder(Node root) {
        Deque<Node> st = new ArrayDeque<>();
        Node cur = root;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) { st.push(cur); cur = cur.left; }   // go as far left as possible
            cur = st.pop();                                          // visit
            System.out.print(cur.data + " ");
            cur = cur.right;                                         // then the right subtree
        }
    }

    static void postorder(Node root) {                // two-stack method
        Deque<Node> s1 = new ArrayDeque<>(), s2 = new ArrayDeque<>();
        if (root != null) s1.push(root);
        while (!s1.isEmpty()) {
            Node n = s1.pop();
            s2.push(n);                               // s2 collects Root, Right, Left ...
            if (n.left != null) s1.push(n.left);
            if (n.right != null) s1.push(n.right);
        }
        while (!s2.isEmpty()) System.out.print(s2.pop().data + " ");   // ... reversed = Left, Right, Root
    }

    public static void main(String[] args) {
        //        50
        //      /    \
        //    30      70
        //   /  \    /  \
        //  20  40  60  80
        Node root = new Node(50, new Node(30, new Node(20), new Node(40)), new Node(70, new Node(60), new Node(80)));
        System.out.print("preorder : "); preorder(root);  System.out.println();
        System.out.print("inorder  : "); inorder(root);   System.out.println();
        System.out.print("postorder: "); postorder(root); System.out.println();

        // A very deep (degenerate) tree: 1,000,000 levels
        Node deep = null;
        for (int i = 0; i < 1_000_000; i++) deep = new Node(i, deep, null);
        long t = System.nanoTime();
        Deque<Node> st = new ArrayDeque<>();
        Node cur = deep; long count = 0;
        while (cur != null || !st.isEmpty()) {
            while (cur != null) { st.push(cur); cur = cur.left; }
            cur = st.pop(); count++; cur = cur.right;
        }
        System.out.println("iterative inorder on a 1,000,000-deep tree visited " + count + " nodes, no StackOverflowError ("
                + (System.nanoTime() - t) / 1_000_000 + " ms)");
    }
}
