// Day1 revision: Big O
public class BigORecap {

    static long q1(int n) { long c = 0; for (int i = 0; i < n; i += 2) c++; return c; }

    static long q2(int n) { long c = 0; for (int i = 0; i < n; i++) for (int j = 0; j < 1000; j++) c++; return c; }

    static long q3(int n) { long c = 0; while (n > 0) { n /= 10; c++; } return c; }

    static long q4(int n) { long c = 0; for (int i = 0; i < n; i++) for (int j = i; j < n; j++) c++; return c; }

    static long q5(int n) { long c = 0; for (int i = n; i > 0; i /= 2) for (int j = 0; j < n; j++) c++; return c; }

    static long q6(int n) { long c = 0; for (int i = 1; i < n; i *= 2) for (int j = 0; j < i; j++) c++; return c; }

    static long q7(int n) { long c = 0; for (int i = 0; i < n; i++) for (int j = 1; j * j <= n; j++) c++; return c; }

    static long q8(int n) { long c = 0; for (int i = 1; i <= n; i++) for (int j = i; j <= n; j += i) c++; return c; }

    static long calls;
    static int twoCalls(int n) { calls++; if (n <= 1) return 1; return twoCalls(n - 1) + twoCalls(n - 1); }
    static int oneCall(int n)  { calls++; if (n <= 1) return 1; return 2 * oneCall(n - 1); }

    public static void main(String[] args) {
        System.out.printf("%-6s %12s %12s %12s   %s%n", "", "n=1000", "n=2000", "n=4000", "ratio 2000/1000");
        row("Q1", BigORecap::q1);
        row("Q2", BigORecap::q2);
        row("Q3", BigORecap::q3);
        row("Q4", BigORecap::q4);
        row("Q5", BigORecap::q5);
        row("Q6", BigORecap::q6);
        row("Q7", BigORecap::q7);
        row("Q8", BigORecap::q8);

        System.out.println();
        System.out.printf("%-6s %8s %12s %12s%n", "n", "", "twoCalls", "oneCall");
        for (int n : new int[]{10, 11, 12, 20}) {
            calls = 0; twoCalls(n); long a = calls;
            calls = 0; oneCall(n);  long b = calls;
            System.out.printf("%-6d %8s %12d %12d%n", n, "", a, b);
        }
    }

    interface Counter { long count(int n); }

    static void row(String name, Counter f) {
        long a = f.count(1000), b = f.count(2000), c = f.count(4000);
        System.out.printf("%-6s %12d %12d %12d   %.2f%n", name, a, b, c, (double) b / a);
    }
}
