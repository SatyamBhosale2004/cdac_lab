import java.util.ArrayList;
import java.util.List;

/**
 * Day 4 - Recursion that explores choices (a preview of backtracking, Day 11).
 *   subsets      : for each item choose IN or OUT       -> 2^n results
 *   permutations : choose which item goes first, recurse -> n! results
 */
public class SubsetsPermutations {

    static void subsets(String items, int i, String chosen, List<String> out) {
        if (i == items.length()) { out.add("{" + chosen + "}"); return; }   // all decisions made
        subsets(items, i + 1, chosen + items.charAt(i), out);               // include items[i]
        subsets(items, i + 1, chosen, out);                                  // exclude items[i]
    }

    static void permutations(String prefix, String remaining, List<String> out) {
        if (remaining.isEmpty()) { out.add(prefix); return; }
        for (int i = 0; i < remaining.length(); i++) {
            char c = remaining.charAt(i);
            permutations(prefix + c, remaining.substring(0, i) + remaining.substring(i + 1), out);
        }
    }

    public static void main(String[] args) {
        List<String> s = new ArrayList<>();
        subsets("ABC", 0, "", s);
        System.out.println("subsets of ABC (" + s.size() + " = 2^3): " + s);

        List<String> p = new ArrayList<>();
        permutations("", "ABC", p);
        System.out.println("permutations of ABC (" + p.size() + " = 3!): " + p);

        List<String> p5 = new ArrayList<>();
        permutations("", "ABCDEFGH", p5);
        System.out.println("permutations of 8 letters: " + p5.size() + " (8! = 40,320). 15 letters would be 1.3 trillion.");
    }
}
