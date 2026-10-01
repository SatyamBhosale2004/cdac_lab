
import java.util.Scanner;
public class LinearSearchPrac {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter size of array");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int iTmp = 0; iTmp < n; iTmp++) {
			System.out.println("Enter value of element at index " +(iTmp));
			arr[iTmp] = sc.nextInt();
		}
		System.out.println("Enter value to search");
		int value = sc.nextInt();
		int index = linearSearch(arr, value);
		if(index != - 1)
			System.out.println("Value found at " + index);
		else System.out.println("Value not found");
	}
	
	static int linearSearch(int arr[], int value) {
		for(int iTmp=0 ; iTmp < arr.length; iTmp++) {
			if(arr[iTmp] == value)
				return iTmp;
		}
		return -1;
	}
	
}
