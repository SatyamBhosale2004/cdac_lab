import java.util.Arrays;

/**
 * Day 2 - Arrays: the most basic data structure.
 * - Fixed size, contiguous block, index -> element in O(1)
 * - Insert / delete in the middle needs SHIFTING -> O(n)
 */
public class ArrayBasics {

    static int shifts;   // counts element moves

    // Insert value at index, shifting everything after it one step right. O(n)
    static void insertAt(int[] a, int size, int index, int value) {
        for (int i = size; i > index; i--) {   // walk from the end towards index
            a[i] = a[i - 1];
            shifts++;
        }
        a[index] = value;
    }

    // Delete element at index, shifting everything after it one step left. O(n)
    static void deleteAt(int[] a, int size, int index) {
        for (int i = index; i < size - 1; i++) {
            a[i] = a[i + 1];
            shifts++;
        }
        a[size - 1] = 0;                        // optional: clear the freed slot
    }

    public static void main(String[] args) {
        // 1. Java arrays are objects with a fixed length and default values
        int[] marks = new int[5];
        String[] names = new String[3];
        System.out.println("int defaults    : " + Arrays.toString(marks));
        System.out.println("String defaults : " + Arrays.toString(names));
        System.out.println("length is fixed : " + marks.length);

        // 2. Random access: a[i] is O(1) - the JVM computes base + i * elementSize
        int[] a = {10, 20, 30, 40, 0, 0, 0, 0};     // capacity 8, 4 used
        int size = 4;
        System.out.println("\na[2] = " + a[2] + "   (one step, no loop)");

        // 3. Insert in the middle: shifting
        shifts = 0;
        insertAt(a, size, 1, 15); size++;
        System.out.println("insert 15 at 1  : " + Arrays.toString(a) + "  shifts = " + shifts);

        shifts = 0;
        insertAt(a, size, size, 50); size++;
        System.out.println("insert 50 at end: " + Arrays.toString(a) + "  shifts = " + shifts);

        shifts = 0;
        deleteAt(a, size, 0); size--;
        System.out.println("delete index 0  : " + Arrays.toString(a) + "  shifts = " + shifts);

        // 4. Bounds are always checked in Java (unlike C)
        try {
            a[8] = 99;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\nBounds check    : " + e.getMessage());
        }

        // 5. 2-D arrays are arrays of arrays - rows can have different lengths (jagged)
        int[][] triangle = new int[4][];
        for (int r = 0; r < triangle.length; r++) {
            triangle[r] = new int[r + 1];
            triangle[r][0] = triangle[r][r] = 1;
            for (int c = 1; c < r; c++) triangle[r][c] = triangle[r - 1][c - 1] + triangle[r - 1][c];
        }
        System.out.println("\nJagged 2-D array (Pascal's triangle):");
        for (int[] row : triangle) System.out.println("  " + Arrays.toString(row));

        // 6. Growing an array = make a bigger one and copy (O(n))
        int[] bigger = Arrays.copyOf(a, a.length * 2);
        System.out.println("\nArrays.copyOf to grow: " + Arrays.toString(bigger));
    }
}
