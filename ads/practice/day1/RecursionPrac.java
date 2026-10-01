
import java.util.Scanner;
public class RecursionPrac {
	public static void main(String args[]) {
	    Scanner sc = new Scanner(System.in);

	    System.out.println("Enter n for factorial:");
	    int n = sc.nextInt();

	    calls = 0;
	    System.out.println("Factorial = " + factorial(n));
	    System.out.println("Calls = " + calls);

	    System.out.println("Enter n for fibonacci:");
	    n = sc.nextInt();

	    calls = 0;
	    System.out.println("Fibonacci = " + fibonacci(n));
	    System.out.println("Calls = " + calls);

	    int a[] = {10, 20, 30, 40, 50};

	    System.out.println("Enter value to search:");
	    int value = sc.nextInt();

	    calls = 0;
	    System.out.println("Index = " + binarySearch(a, value, 0, a.length - 1));
	    System.out.println("Calls = " + calls);
	    
	    sc.close();
	}
	
	static long calls;
	
	static long factorial(int n) {
		calls++;
		if(n<=1) return 1;
		return n * factorial(n-1);
	}
	
	static long binarySearch(int a[], int value, int left, int right) {
		calls++;
		int mid = (left + right) /2;
		if(left > right) return -1;
		
		if(value == a[mid])
			return mid;
		if(value > a[mid])
			return binarySearch(a , value, mid+1, right);
		else
			return binarySearch(a, value, left, mid-1);
	}
	
	static long fibonacci(int n) {
		calls++;
		if(n < 2) return n;
		return fibonacci(n-1) + fibonacci(n-2);
	}
	
	
}
