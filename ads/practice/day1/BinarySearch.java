
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter size of array");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int iTmp = 0; iTmp < n; iTmp++) {
			System.out.println("Enter value of element at index " + (iTmp));
			arr[iTmp] = sc.nextInt();
		}
		Arrays.sort(arr);
		System.out.println("Sorted array: ");
		for(int iTmp =0;iTmp < n;iTmp++) {
			System.out.println(arr[iTmp] + " ");
		}
		System.out.println("Enter value to search");
		int value = sc.nextInt();
		int index = binarySearch(arr, value);
		if (index != -1)
			System.out.println("Value found at " + index);
		else
			System.out.println("Value not found");
	}
	
	static int binarySearch(int arr[] , int value) {
		int left = 0 , right = arr.length-1 , mid;
		
		while(left <= right) {
			mid = ( left + right ) /2;
			if(arr[mid] == value)
				return mid;
			if(arr[mid] > value)
				right = mid - 1;
				
			else
				left = mid + 1;
		}
		return -1;
	}

}
