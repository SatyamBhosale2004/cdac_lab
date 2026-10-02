import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Day 5 - Binary Search Tree (generic).
 * BST property: for every node, keys in the LEFT subtree are smaller and keys in the RIGHT subtree are larger.
 * search / insert / delete follow ONE path from the root: O(h), where h = height.
 *   balanced tree: h ~ log2 n   -> O(log n)
 *   degenerate   : h ~ n        -> O(n)   (insert keys in sorted order and see)
 */
public class BST<K extends Comparable<K>> {

    private class Node {
        K key; Node left, right;
        Node(K key) { this.key = key; }
    }

    private Node root;
    private int size;

    public int size() { return size; }

    // ---------- search: O(h)
    public boolean contains(K key) {
        Node cur = root;
        while (cur != null) {
            int c = key.compareTo(cur.key);
            if (c == 0) return true;
            cur = c < 0 ? cur.left : cur.right;      // discard half of the tree at each step
        }
        return false;
    }

    // ---------- insert: O(h). Recursive version returns the (possibly new) subtree root
    public void insert(K key) { root = insert(root, key); }

    private Node insert(Node n, K key) {
        if (n == null) { size++; return new Node(key); }   // found the empty spot
        int c = key.compareTo(n.key);
        if (c < 0) n.left = insert(n.left, key);
        else if (c > 0) n.right = insert(n.right, key);
        // c == 0: duplicate - ignored (a set). TreeMap would replace the value.
        return n;
    }

    // ---------- min / max: walk left / right
    public K min() { Node n = root; while (n.left != null) n = n.left; return n.key; }
    public K max() { Node n = root; while (n.right != null) n = n.right; return n.key; }

    // ---------- delete: O(h), three cases
    public void delete(K key) { root = delete(root, key); }

    private Node delete(Node n, K key) {
        if (n == null) return null;                          // not found
        int c = key.compareTo(n.key);
        if (c < 0) { n.left = delete(n.left, key); return n; }
        if (c > 0) { n.right = delete(n.right, key); return n; }
        // found n
        if (n.left == null && n.right == null) { size--; return null; }   // case 1: leaf -> just remove
        if (n.left == null) { size--; return n.right; }                    // case 2: one child -> child takes its place
        if (n.right == null) { size--; return n.left; }
        // case 3: two children -> copy the inorder SUCCESSOR (min of right subtree), then delete it there
        Node succ = n.right;
        while (succ.left != null) succ = succ.left;
        n.key = succ.key;
        n.right = delete(n.right, succ.key);                // the successor has no left child: case 1 or 2
        return n;
    }

    // ---------- traversals
    public List<K> inorder() { List<K> out = new ArrayList<>(); inorder(root, out); return out; }
    private void inorder(Node n, List<K> out) { if (n == null) return; inorder(n.left, out); out.add(n.key); inorder(n.right, out); }

    public List<K> preorder() { List<K> out = new ArrayList<>(); preorder(root, out); return out; }
    private void preorder(Node n, List<K> out) { if (n == null) return; out.add(n.key); preorder(n.left, out); preorder(n.right, out); }

    public List<K> postorder() { List<K> out = new ArrayList<>(); postorder(root, out); return out; }
    private void postorder(Node n, List<K> out) { if (n == null) return; postorder(n.left, out); postorder(n.right, out); out.add(n.key); }

    public List<K> levelOrder() {
        List<K> out = new ArrayList<>();
        if (root == null) return out;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.poll(); out.add(n.key);
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
        return out;
    }

    public int height() { return height(root); }
    private int height(Node n) { return n == null ? -1 : 1 + Math.max(height(n.left), height(n.right)); }

    public void printSideways() { printSideways(root, ""); }
    private void printSideways(Node n, String ind) {
        if (n == null) return;
        printSideways(n.right, ind + "     ");
        System.out.println(ind + n.key);
        printSideways(n.left, ind + "     ");
    }

    public static void main(String[] args) {
        BST<Integer> t = new BST<>();
        for (int k : new int[]{50, 30, 70, 20, 40, 60, 80, 35, 45, 65}) t.insert(k);
        System.out.println("inserted 50 30 70 20 40 60 80 35 45 65 (tree printed sideways, root on the left):");
        t.printSideways();
        System.out.println("inorder    : " + t.inorder() + "   <- always SORTED");
        System.out.println("preorder   : " + t.preorder());
        System.out.println("postorder  : " + t.postorder());
        System.out.println("level order: " + t.levelOrder());
        System.out.println("min = " + t.min() + ", max = " + t.max() + ", height = " + t.height() + ", contains 65? " + t.contains(65) + ", contains 66? " + t.contains(66));

        t.delete(20); System.out.println("\ndelete 20 (leaf)          -> " + t.inorder());
        t.delete(60); System.out.println("delete 60 (one child)     -> " + t.inorder());
        t.delete(30); System.out.println("delete 30 (two children)  -> " + t.inorder() + "  (35, the successor, took its place)");
        t.delete(50); System.out.println("delete 50 (the root)      -> " + t.inorder());
        t.printSideways();
    }
}
