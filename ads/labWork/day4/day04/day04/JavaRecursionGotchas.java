import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Day 4 - Recursion you meet in everyday Java.
 */
public class JavaRecursionGotchas {

    // 1. Directory trees are recursive: a folder contains files and folders
    static long countFiles(File dir, int depth, int maxDepth) {
        File[] children = dir.listFiles();
        if (children == null || depth > maxDepth) return 0;   // not a folder / unreadable / too deep
        long count = 0;
        for (File f : children) count += f.isDirectory() ? countFiles(f, depth + 1, maxDepth) : 1;
        return count;
    }

    // 2. toString() that calls itself by accident
    static class Employee {
        String name; Employee manager;
        Employee(String name) { this.name = name; }
        @Override public String toString() { return name + " (manager: " + manager + ")"; }   // recursion via manager.toString()
    }

    public static void main(String[] args) {
        System.out.println("files under the current folder (max depth 3): " + countFiles(new File("."), 0, 3));

        // A list that contains itself: the JDK guards toString()...
        List<Object> self = new ArrayList<>();
        self.add("x");
        self.add(self);
        System.out.println("list containing itself, toString(): " + self);
        // ...but not hashCode()
        try {
            self.hashCode();
        } catch (StackOverflowError e) {
            System.out.println("list containing itself, hashCode(): StackOverflowError");
        }

        Employee a = new Employee("Asha"), b = new Employee("Ravi");
        a.manager = b;
        System.out.println(a);                    // fine: Ravi has no manager
        b.manager = a;                            // a cycle: Asha -> Ravi -> Asha
        try {
            System.out.println(a);
        } catch (StackOverflowError e) {
            System.out.println("Employee cycle in toString(): StackOverflowError (every recursion needs a way to stop)");
        }
    }
}
