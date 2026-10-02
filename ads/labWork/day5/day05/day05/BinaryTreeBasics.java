import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Day 5 - Binary tree basics: node class, the four traversals, and simple recursive properties.
 *
 *              F
 *            /   \
 *           B     G
 *          / \     \
 *         A   D     I
 *            / \   /
 *           C   E H
 */
public class BinaryTreeBasics {

    static class Node {
        char data;
        Node left, right;
        Node(char data) { this.data = data; }
        Node(char data, Node left, Node right) { this.data = data; this.left = left; this.right = right; }
    }

    // ---- depth-first traversals: the only difference is WHEN we visit the root
    static void preorder(Node n) {          // Root, Left, Right
        if (n == null) return;
        System.out.print(n.data + " ");
        preorder(n.left);
        preorder(n.right);
    }

    static void inorder(Node n) {           // Left, Root, Right
        if (n == null) return;
        inorder(n.left);
        System.out.print(n.data + " ");
        inorder(n.right);
    }

    static void postorder(Node n) {         // Left, Right, Root
        if (n == null) return;
        postorder(n.left);
        postorder(n.right);
        System.out.print(n.data + " ");
    }

    // ---- breadth-first (level-order) traversal: a QUEUE, not recursion
    static void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node n = q.poll();
            System.out.print(n.data + " ");
            if (n.left != null) q.add(n.left);
            if (n.right != null) q.add(n.right);
        }
    }

    // Level by level, one line per level
    static void printLevels(Node root) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);
        int level = 0;
        while (!q.isEmpty()) {
            int count = q.size();                 // nodes on this level
            StringBuilder sb = new StringBuilder("  level " + level++ + ": ");
            for (int i = 0; i < count; i++) {
                Node n = q.poll();
                sb.append(n.data).append(' ');
                if (n.left != null) q.add(n.left);
                if (n.right != null) q.add(n.right);
            }
            System.out.println(sb);
        }
    }

    // ---- recursive properties: answer = combine(answer for left, answer for right)
    static int size(Node n)   { return n == null ? 0 : 1 + size(n.left) + size(n.right); }
    static int height(Node n) { return n == null ? -1 : 1 + Math.max(height(n.left), height(n.right)); }  // edges; empty tree = -1
    static int leaves(Node n) {
        if (n == null) return 0;
        if (n.left == null && n.right == null) return 1;
        return leaves(n.left) + leaves(n.right);
    }

    // Print the tree turned 90 degrees (root on the left) - handy for debugging
    static void printSideways(Node n, String indent) {
        if (n == null) return;
        printSideways(n.right, indent + "    ");
        System.out.println(indent + n.data);
        printSideways(n.left, indent + "    ");
    }

    public static void main(String[] args) {
        Node root = new Node('F',
                new Node('B', new Node('A'), new Node('D', new Node('C'), new Node('E'))),
                new Node('G', null, new Node('I', new Node('H'), null)));

        System.out.print("preorder   (Root L R): "); preorder(root);   System.out.println();
        System.out.print("inorder    (L Root R): "); inorder(root);    System.out.println();
        System.out.print("postorder  (L R Root): "); postorder(root);  System.out.println();
        System.out.print("level order (BFS)    : "); levelOrder(root); System.out.println();
        System.out.println("levels:"); printLevels(root);
        System.out.println("size = " + size(root) + ", height = " + height(root) + ", leaves = " + leaves(root));
        System.out.println("sideways (root on the left):");
        printSideways(root, "  ");
    }
}
