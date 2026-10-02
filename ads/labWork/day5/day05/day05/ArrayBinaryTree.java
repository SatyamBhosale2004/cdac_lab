/**
 * Day 5 - A complete (almost complete) binary tree stored in an ARRAY.
 * No Node objects, no references - positions are computed:
 *     left(i)   = 2i + 1
 *     right(i)  = 2i + 2
 *     parent(i) = (i - 1) / 2
 * Works because a complete tree has no gaps when read level by level.
 * java.util.PriorityQueue stores its binary heap exactly like this.
 */
public class ArrayBinaryTree {

    private final char[] tree;
    private final int size;

    ArrayBinaryTree(String levelOrder) { tree = levelOrder.toCharArray(); size = tree.length; }

    static int left(int i)   { return 2 * i + 1; }
    static int right(int i)  { return 2 * i + 2; }
    static int parent(int i) { return (i - 1) / 2; }

    void preorder(int i) {
        if (i >= size) return;                 // "null child" = index outside the array
        System.out.print(tree[i] + " ");
        preorder(left(i));
        preorder(right(i));
    }

    void inorder(int i) {
        if (i >= size) return;
        inorder(left(i));
        System.out.print(tree[i] + " ");
        inorder(right(i));
    }

    int height() { return size == 0 ? -1 : 31 - Integer.numberOfLeadingZeros(size); }  // floor(log2 size)

    public static void main(String[] args) {
        //            A(0)
        //         /       \
        //      B(1)        C(2)
        //     /   \       /   \
        //   D(3)  E(4)  F(5)  G(6)
        //   /  \
        // H(7) I(8)
        ArrayBinaryTree t = new ArrayBinaryTree("ABCDEFGHI");
        System.out.println("index : 0 1 2 3 4 5 6 7 8");
        System.out.println("tree  : A B C D E F G H I   (level order)");
        for (int i = 0; i < t.size; i++) {
            String l = left(i) < t.size ? String.valueOf(t.tree[left(i)]) : "-";
            String r = right(i) < t.size ? String.valueOf(t.tree[right(i)]) : "-";
            String p = i == 0 ? "-" : String.valueOf(t.tree[parent(i)]);
            System.out.printf("  %c at %d: parent=%s left=%s right=%s%n", t.tree[i], i, p, l, r);
        }
        System.out.print("preorder: "); t.preorder(0); System.out.println();
        System.out.print("inorder : "); t.inorder(0);  System.out.println();
        System.out.println("height = floor(log2 9) = " + t.height());
    }
}
