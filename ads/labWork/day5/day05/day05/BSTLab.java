import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Day 5 LAB (syllabus) - Binary search tree with a menu:
 *   Create(), traversals BFS, DFS, PreOrder, InOrder, PostOrder, and Delete().
 * Written with int keys and a plain Node class so every line is visible.
 */
public class BSTLab {

    static class Node {
        int key; Node left, right;
        Node(int key) { this.key = key; }
    }

    Node root;

    void insert(int key) { root = insert(root, key); }
    Node insert(Node n, int key) {
        if (n == null) return new Node(key);
        if (key < n.key) n.left = insert(n.left, key);
        else if (key > n.key) n.right = insert(n.right, key);
        else System.out.println("  " + key + " already exists");
        return n;
    }

    // Create(): build a tree from many keys at once
    void create(int[] keys) { root = null; for (int k : keys) insert(k); }

    void delete(int key) { root = delete(root, key); }
    Node delete(Node n, int key) {
        if (n == null) { System.out.println("  " + key + " not found"); return null; }
        if (key < n.key) n.left = delete(n.left, key);
        else if (key > n.key) n.right = delete(n.right, key);
        else {
            if (n.left == null) return n.right;          // leaf or only right child
            if (n.right == null) return n.left;          // only left child
            Node s = n.right;                            // two children: inorder successor
            while (s.left != null) s = s.left;
            n.key = s.key;
            n.right = delete(n.right, s.key);
        }
        return n;
    }

    void preorder(Node n)  { if (n == null) return; System.out.print(n.key + " "); preorder(n.left); preorder(n.right); }
    void inorder(Node n)   { if (n == null) return; inorder(n.left); System.out.print(n.key + " "); inorder(n.right); }
    void postorder(Node n) { if (n == null) return; postorder(n.left); postorder(n.right); System.out.print(n.key + " "); }

    void bfs() {                                          // level order with a queue
        if (root == null) return;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.key + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
    }

    void dfs() {                                          // depth first with an explicit stack (= preorder)
        if (root == null) return;
        Deque<Node> st = new ArrayDeque<>();
        st.push(root);
        while (!st.isEmpty()) {
            Node n = st.pop();
            System.out.print(n.key + " ");
            if (n.right != null) st.push(n.right);
            if (n.left != null) st.push(n.left);
        }
    }

    public static void main(String[] args) {
        BSTLab t = new BSTLab();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n1.Create  2.Insert  3.Delete  4.BFS  5.DFS  6.PreOrder  7.InOrder  8.PostOrder  9.Exit");
            System.out.print("choice: ");
            if (!sc.hasNextInt()) break;
            int ch = sc.nextInt();
            switch (ch) {
                case 1: {
                    System.out.print("how many keys? ");
                    int n = sc.nextInt(); int[] keys = new int[n];
                    System.out.print("keys: ");
                    for (int i = 0; i < n; i++) keys[i] = sc.nextInt();
                    t.create(keys);
                    break;
                }
                case 2: System.out.print("key: "); t.insert(sc.nextInt()); break;
                case 3: System.out.print("key: "); t.delete(sc.nextInt()); break;
                case 4: t.bfs(); break;
                case 5: t.dfs(); break;
                case 6: t.preorder(t.root); break;
                case 7: t.inorder(t.root); break;
                case 8: t.postorder(t.root); break;
                case 9: sc.close(); return;
                default: System.out.println("invalid choice");
            }
        }
    }
}
