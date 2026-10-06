package in.ads.practice.day2;

import java.util.Scanner;

public class ArrayPrac {
	static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size, capacity;
		System.out.println("Enter capacity of array ");
		capacity = sc.nextInt();
		System.out.println("Enter size of array ");
		size = sc.nextInt();
		int arr[] = new int[capacity];
		for (int iTmp = 0; iTmp < size; iTmp++) {
			System.out.println("Enter elem at index " + iTmp);
			arr[iTmp] = sc.nextInt();
		}
		System.out.println("Array: ");
		for (int iTmp = 0; iTmp < capacity; iTmp++) {
			System.out.print(arr[iTmp] + ", ");
		}
		System.out.println();
		System.out.println("Enter element which you want to insert");
		int value = sc.nextInt();
		System.out.println("Enter index at which you want to insert");
		int indexI = sc.nextInt();
		if (indexI > capacity) {
			System.out.println("Invalid index");
		}
		insertAt(arr, size, indexI, value);
		size++;
		System.out.println("Array: ");
		for (int iTmp = 0; iTmp < capacity; iTmp++) {
			System.out.print(arr[iTmp] + ", ");
		}
		System.out.println();
		System.out.println("Enter index whose value u want to delete");
		int indexD = sc.nextInt();
		deleteAt(arr, size, indexD);
		size--;
		System.out.println("Array: ");
		for (int iTmp = 0; iTmp < capacity; iTmp++) {
			System.out.print(arr[iTmp] + ", ");
		}
		System.out.println();
	}

	public static void insertAt(int arr[], int size, int index, int value) {
		// to got the last elem plus one as we will shift all
		for (int iTmp = size; iTmp > index; iTmp--) {
			arr[iTmp] = arr[iTmp - 1];
			// arr[size] = arr[size-1]
		}
		// at the index enter value
		arr[index] = value;
		
	}

	public static void deleteAt(int arr[], int size, int index) {

		for (int iTmp = index; iTmp < size-1; iTmp++) {
			arr[iTmp] = arr[iTmp + 1];

		}
		arr[size - 1] = 0;
		
	}

}
