// Day 5 warm-up: run each snippet from the Day 4 (recursion) revision quiz (day05-warmup.html)
public class Day4Recap {

    static void down(int n) { if (n == 0) return; System.out.print(n + " "); down(n - 1); }
    static void up(int n)   { if (n == 0) return; up(n - 1); System.out.print(n + " "); }
    static void both(int n) { if (n == 0) return; System.out.print(n + " "); both(n - 1); System.out.print(n + " "); }
    static void skip(int n) { if (n <= 0) return; skip(n - 2); System.out.print(n + " "); }

    static int digitSum(int n) { if (n == 0) return 0; return n % 10 + digitSum(n / 10); }

    static int noBase(int n) { return n + noBase(n - 1); }

    static int calls;
    static int power(int x, int n) { calls++; if (n == 0) return 1; return x * power(x, n - 1); }

    static int fact(int n) {
        if (n <= 1) { System.out.println("fact(" + n + ") returns 1"); return 1; }
        int r = n * fact(n - 1);
        System.out.println("fact(" + n + ") returns " + r);
        return r;
    }

    static int mystery(int n) { if (n == 0) return 0; return n % 2 + 10 * mystery(n / 2); }

    static String rev(String s) { if (s.length() <= 1) return s; return rev(s.substring(1)) + s.charAt(0); }

    static boolean isEven(int n) { if (n == 0) return true;  return isOdd(n - 1); }
    static boolean isOdd(int n)  { if (n == 0) return false; return isEven(n - 1); }

    static int fibCalls;
    static int fib(int n) { fibCalls++; if (n <= 1) return n; return fib(n - 1) + fib(n - 2); }

    static long moves;
    static void hanoi(int n, char from, char to, char via) {
        if (n == 0) return;
        hanoi(n - 1, from, via, to);
        moves++;
        hanoi(n - 1, via, to, from);
    }

    static class Node { int data; Node next; Node(int d, Node n) { data = d; next = n; } }
    static void printReverse(Node p) { if (p == null) return; printReverse(p.next); System.out.print(p.data + " "); }
    static int length(Node p) { if (p == null) return 0; return 1 + length(p.next); }

    public static void main(String[] args) {
        System.out.print("Q1  "); down(3); System.out.println();
        System.out.print("Q2  "); up(3); System.out.println();
        System.out.print("Q3  "); both(3); System.out.println();
        System.out.print("Q4  "); skip(5); System.out.println();
        System.out.println("Q5  " + digitSum(1234));
        System.out.print("Q6  ");
        try { noBase(5); } catch (StackOverflowError e) { System.out.println(e); }
        calls = 0; int p = power(2, 5);
        System.out.println("Q7  " + p + " in " + calls + " calls");
        System.out.println("Q8");
        System.out.println(fact(4));
        System.out.println("Q9  " + mystery(12) + "  " + mystery(5));
        System.out.println("Q10 " + rev("java"));
        System.out.println("Q11 isEven(4)=" + isEven(4) + " isOdd(3)=" + isOdd(3) + " isEven(3)=" + isEven(3));
        fibCalls = 0; int f = fib(5);
        System.out.println("Q12 fib(5)=" + f + " calls=" + fibCalls);
        for (int n : new int[]{3, 10, 20}) { moves = 0; hanoi(n, 'A', 'C', 'B'); System.out.println("Q13 n=" + n + " moves=" + moves); }
        Node list = new Node(1, new Node(2, new Node(3, null)));
        System.out.print("Q14 "); printReverse(list); System.out.println(" length=" + length(list));
    }
}
