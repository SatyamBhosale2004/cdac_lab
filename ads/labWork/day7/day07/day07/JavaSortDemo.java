import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Day 7 - Sorting in java.util.
 *   Arrays.sort(int[])          : Dual-Pivot Quicksort  (primitives: stability does not matter)
 *   Arrays.sort(Object[]), List.sort, Collections.sort : TimSort (merge sort + insertion sort) - STABLE
 * Comparable = the natural order of a class. Comparator = any order you want.
 */
public class JavaSortDemo {

    record Student(String name, String city, int marks) implements Comparable<Student> {
        public int compareTo(Student o) { return Integer.compare(marks, o.marks); }   // natural order: by marks
        public String toString() { return name + "(" + city + "," + marks + ")"; }
    }

    // A deliberately UNSTABLE sort (selection sort) for comparison
    static <T> void selectionSort(List<T> list, Comparator<T> c) {
        for (int i = 0; i < list.size() - 1; i++) {
            int m = i;
            for (int j = i + 1; j < list.size(); j++) if (c.compare(list.get(j), list.get(m)) < 0) m = j;
            T t = list.get(i); list.set(i, list.get(m)); list.set(m, t);
        }
    }

    public static void main(String[] args) {
        int[] nums = {42, 7, 19, 3, 88, 25};
        Arrays.sort(nums);
        System.out.println("Arrays.sort(int[])          : " + Arrays.toString(nums));

        List<Student> list = new ArrayList<>(List.of(
                new Student("Asha", "Pune", 82), new Student("Ravi", "Mumbai", 75),
                new Student("Neha", "Mumbai", 82), new Student("Omar", "Pune", 75),
                new Student("Isha", "Delhi", 91)));

        List<Student> byMarks = new ArrayList<>(list);
        java.util.Collections.sort(byMarks);                                   // uses compareTo
        System.out.println("natural order (Comparable)  : " + byMarks);

        List<Student> desc = new ArrayList<>(list);
        desc.sort(Comparator.comparingInt(Student::marks).reversed().thenComparing(Student::name));
        System.out.println("marks desc, then name       : " + desc);

        // STABILITY: sort by name first, then by city. A stable sort keeps names in order inside each city.
        List<Student> s1 = new ArrayList<>(list);
        s1.sort(Comparator.comparing(Student::name));
        s1.sort(Comparator.comparing(Student::city));                          // TimSort: stable
        System.out.println("\nby name, then by city (stable TimSort)  : " + s1);

        List<Student> s2 = new ArrayList<>(list);
        s2.sort(Comparator.comparing(Student::name));
        selectionSort(s2, Comparator.comparing(Student::city));               // unstable
        System.out.println("by name, then by city (selection sort)  : " + s2 + "   <- names inside a city may lose their order");

        int[] big = new java.util.Random(9).ints(20_000_000).toArray();
        int[] big2 = big.clone();
        long t = System.nanoTime(); Arrays.sort(big); long seq = (System.nanoTime() - t) / 1_000_000;
        t = System.nanoTime(); Arrays.parallelSort(big2); long par = (System.nanoTime() - t) / 1_000_000;
        System.out.println("\n2 crore ints: Arrays.sort " + seq + " ms, Arrays.parallelSort " + par + " ms (" + Runtime.getRuntime().availableProcessors() + " cores)");
    }
}
