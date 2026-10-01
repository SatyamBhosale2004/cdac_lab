/**
 * Day 4 - Recursion basics.
 * Every recursive method has:
 *   1. a BASE CASE      - small enough to answer directly (stops the recursion)
 *   2. a RECURSIVE CASE - solves the problem using a SMALLER version of itself
 */
public class RecursionBasics {

    // Countdown: the simplest recursion. O(n) time, O(n) stack
    static void countdown(int n) {
        if (n == 0) { System.out.println("Go!"); return; }   // base case
        System.out.print(n + " ");
        countdown(n - 1);                                    // smaller problem
    }

    // n! = n * (n-1)!, 0! = 1
    static long factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // Sum of a[0..n-1] = sum of a[0..n-2] + a[n-1]
    static int sum(int[] a, int n) {
        if (n == 0) return 0;
        return sum(a, n - 1) + a[n - 1];
    }

    // Sum of the digits of n: 4721 -> 4 + 7 + 2 + 1 = 14
    static int sumDigits(int n) {
        if (n < 10) return n;
        return n % 10 + sumDigits(n / 10);
    }

    // x^n the slow way: n multiplications -> O(n)
    static long powerSlow(long x, int n) {
        if (n == 0) return 1;
        return x * powerSlow(x, n - 1);
    }

    // x^n the fast way: x^n = (x^(n/2))^2  -> O(log n)
    static long powerFast(long x, int n) {
        if (n == 0) return 1;
        long half = powerFast(x, n / 2);      // compute ONCE, use twice
        return (n % 2 == 0) ? half * half : half * half * x;
    }

    // Reverse a string: reverse(rest) + first char
    static String reverse(String s) {
        if (s.length() <= 1) return s;
        return reverse(s.substring(1)) + s.charAt(0);
    }

    // Palindrome: first == last and the middle is a palindrome
    static boolean isPalindrome(String s, int lo, int hi) {
        if (lo >= hi) return true;
        if (s.charAt(lo) != s.charAt(hi)) return false;
        return isPalindrome(s, lo + 1, hi - 1);
    }

    // Euclid's GCD: gcd(a, b) = gcd(b, a mod b), gcd(a, 0) = a   -> O(log min(a,b))
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // Binary search (array must be sorted): O(log n)
    static int binarySearch(int[] a, int key, int lo, int hi) {
        if (lo > hi) return -1;                      // base case: empty range
        int mid = lo + (hi - lo) / 2;
        if (a[mid] == key) return mid;               // base case: found
        return key < a[mid] ? binarySearch(a, key, lo, mid - 1)
                            : binarySearch(a, key, mid + 1, hi);
    }

    // Decimal to binary: print binary of n/2, then the last bit
    static String toBinary(int n) {
        if (n < 2) return String.valueOf(n);
        return toBinary(n / 2) + (n % 2);
    }

    public static void main(String[] args) {
        countdown(5);
        System.out.println("factorial(10)        = " + factorial(10));
        System.out.println("sum {3,1,4,1,5}      = " + sum(new int[]{3, 1, 4, 1, 5}, 5));
        System.out.println("sumDigits(4721)      = " + sumDigits(4721));
        System.out.println("powerSlow(2, 30)     = " + powerSlow(2, 30));
        System.out.println("powerFast(2, 62)     = " + powerFast(2, 62));
        System.out.println("reverse(\"RECURSION\") = " + reverse("RECURSION"));
        System.out.println("isPalindrome(MALAYALAM) = " + isPalindrome("MALAYALAM", 0, 8));
        System.out.println("gcd(252, 105)        = " + gcd(252, 105));
        int[] sorted = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        System.out.println("binarySearch 23      = index " + binarySearch(sorted, 23, 0, sorted.length - 1));
        System.out.println("toBinary(37)         = " + toBinary(37));
    }
}
