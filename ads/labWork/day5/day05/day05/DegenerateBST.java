import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Day 5 - The shape of a BST depends on the INSERTION ORDER.
 * Random order  -> height about 2-3 x log2 n  -> fast
 * Sorted order  -> every node has only a right child: a linked list! height = n - 1 -> slow
 * (Iterative insert/search so the degenerate tree does not overflow the stack.)
 */
public class DegenerateBST {

    static class Node { int key; Node left, right; Node(int k) { key = k; } }

    static Node insert(Node root, int key) {
        Node n = new Node(key);
        if (root == null) return n;
        Node cur = root;
        while (true) {
            if (key < cur.key) { if (cur.left == null) { cur.left = n; break; } cur = cur.left; }
            else { if (cur.right == null) { cur.right = n; break; } cur = cur.right; }
        }
        return root;
    }

    static int searchSteps(Node root, int key) {
        int steps = 0;
        for (Node cur = root; cur != null; cur = key < cur.key ? cur.left : cur.right) {
            steps++;
            if (cur.key == key) break;
        }
        return steps;
    }

    static int height(Node root) {                     // iterative BFS height (no recursion)
        if (root == null) return -1;
        java.util.ArrayDeque<Node> q = new java.util.ArrayDeque<>();
        q.add(root); int h = -1;
        while (!q.isEmpty()) {
            h++;
            for (int i = q.size(); i > 0; i--) {
                Node n = q.poll();
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
        }
        return h;
    }

    public static void main(String[] args) {
        int n = 20_000;
        List<Integer> keys = new ArrayList<>();
        for (int i = 0; i < n; i++) keys.add(i);

        Node sorted = null;
        long t = System.nanoTime();
        for (int k : keys) sorted = insert(sorted, k);
        long ts = (System.nanoTime() - t) / 1_000_000;

        Collections.shuffle(keys, new java.util.Random(42));
        Node random = null;
        t = System.nanoTime();
        for (int k : keys) random = insert(random, k);
        long tr = (System.nanoTime() - t) / 1_000_000;

        System.out.printf("n = %,d   log2 n = %.1f%n", n, Math.log(n) / Math.log(2));
        System.out.printf("random order: height = %5d   build time = %4d ms   steps to find %d = %d%n", height(random), tr, n - 1, searchSteps(random, n - 1));
        System.out.printf("sorted order: height = %5d   build time = %4d ms   steps to find %d = %d%n", height(sorted), ts, n - 1, searchSteps(sorted, n - 1));
        System.out.println("Fix: a SELF-BALANCING tree (AVL, red-black) keeps height O(log n) for any order -> Day 6.");
    }
}
