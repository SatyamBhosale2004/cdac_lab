package in.ads.practice.day7;

import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter array size");
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int iTmp = 0; iTmp < n; iTmp++) {
			System.out.println("Enter element for index " + iTmp);
			arr[iTmp] = sc.nextInt();
		}

		System.out.println("Selection sort : ");
		selectionSorting(arr);
		System.out.println("Bubble sort : ");
		bubbleSorting(arr);
		System.out.println("Insertion sort : ");
		insertionSorting(arr);
		System.out.println("Heap sort : ");
		heapSorting(arr);
		System.out.println("Merge sort : ");
		mergeSorting(arr);
	}

	public static void selectionSorting(int arr[]) {
		for (int iTmp = 0; iTmp < arr.length - 1; iTmp++) {
			for (int jTmp = iTmp + 1; jTmp < arr.length; jTmp++) {
				if (arr[iTmp] > arr[jTmp]) {
					int temp = arr[iTmp];
					arr[iTmp] = arr[jTmp];
					arr[jTmp] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	static void bubbleSorting(int arr[]) { // 6 4 2 8 3 1 n-1 for inner loop of check swap thwn swap outer also n-1
		// n-1 * n-1 so n^2 times basically here 25 times but like first 5 then 5 and so
		// but last elements are in there place so like it should be 5 then 4 then 3 6 -
		// 1 - 0 then -1 then -2 so - i
		// so with - i 5-4-3---1 so 15 but if array already sorted so in one full
		// iteration it should be enough since no swaps in even oneiter so its sorted so
		// we take swap flag
		for (int iTmp = 0; iTmp < arr.length - 1; iTmp++) {
			boolean swapFlag = false;
			for (int jTmp = 0; jTmp < arr.length - 1 - iTmp; jTmp++) {
				if (arr[jTmp] > arr[jTmp + 1]) {
					int temp = arr[jTmp];
					arr[jTmp] = arr[jTmp + 1];
					arr[jTmp + 1] = temp;

					swapFlag = true;
				}
			}
			if (!swapFlag)
				break;
		}
		System.out.println(Arrays.toString(arr));

	}

	static void insertionSorting(int arr[]) {
		// 6 4 2 8 3 1 insertion is like in sorted arr one elem is added for eg 1 3 4 6
		// 8 2 (added)
		// so 8-2 now 1 3 4 6 8 8 /2 will be in temp till then 3-2 so now
		// 1 2 3 4 6 8 yjis is insertion not sorting will work with sorted array only
		// b=now sorting 6 4 2 8 3 1 we take only two here 6-4 so 4 as last elem like
		// breaking it into two elem arr not technically but just for comparaision so
		// basically one outer loop so to sort the array

		for (int jTmp = 1; jTmp < arr.length; jTmp++) {
			int iTmp, temp = arr[jTmp];
			for (iTmp = jTmp - 1; iTmp >= 0 && arr[iTmp] > temp; iTmp--) {
				arr[iTmp + 1] = arr[iTmp];
			}
			arr[iTmp + 1] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}

	static void heapSorting(int arr[]) {
		// make arr into max heap for ascending sort
		int size = arr.length;
		for (int iTmp = size / 2 - 1; iTmp >= 0; iTmp--) {
			heapify(arr, size, iTmp); // not written if and all here becuz if we swap like upper level aprent and
										// child the lower level might get f'ed and then another if and all for all
										// specific cases usse accha recursion
		}
		// now heap sort after we get max heap we swap lagest with last and after that
		// make that heap into max heap so heapfiy call
		for (int iTmp = size - 1; iTmp >= 0; iTmp--) {
			int temp = arr[0];
			arr[0] = arr[iTmp];
			arr[iTmp] = temp;

			heapify(arr, iTmp, 0);
		}
		System.out.println(Arrays.toString(arr));
	}

	static void heapify(int arr[], int heapSize, int currParentIndex) {
		int largest = currParentIndex;
		int leftChild = 2 * currParentIndex + 1;
		int rightChild = 2 * currParentIndex + 2;

		if (leftChild < heapSize && arr[leftChild] > arr[largest]) {
			largest = leftChild;
		}

		if (rightChild < heapSize && arr[rightChild] > arr[largest]) {
			largest = rightChild;
		}

		// now we swap the parent and child since we just swapped indexes
		if (largest != currParentIndex) {
			int temp = arr[currParentIndex];
			arr[currParentIndex] = arr[largest];
			arr[largest] = temp;

			heapify(arr, heapSize, largest);
		}
	}

	static void mergeSorting(int arr[]) {
		int left = 0;
		int right = arr.length - 1;
		mergeSort(arr, left, right);
		System.out.println(Arrays.toString(arr));
	}

	static void mergeSort(int arr[], int left, int right) {
		// base condn for recusrion is if only one elem or invalid partition
		if (left >= right)
			return;
		// divide array into 2 equal parts
		int mid = (left + right) / 2;
		// sort left side
		mergeSort(arr, left, mid);
		// sort right side
		mergeSort(arr, mid + 1, right);
		// make a temp array to accomodate both parition not like one half and another half basically one array is divided into mult smallpartition until we get one elem only  then we merge not fully one hald one half merge
//        [7 2 9 2 5 0 -3 8]
//        /                  \
//   [7 2 9 2]          [5 0 -3 8]
//   /      \            /       \
//[7 2]   [9 2]       [5 0]   [-3 8]
/// \      / \         / \      / \
//[7][2]   [9][2]      [5][0]  [-3][8]
		int temp[] = new int[right - left + 1];
		// merge sorted partitions in temp
		int i = left, j = mid + 1, k = 0;
		// compare elem from both paratition compare them and put smaller in temp until

		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else
				temp[k++] = arr[j++];
		}
		// one part is exhausted and copy rem like that only
		while (i <= mid)
			temp[k++] = arr[i++];
		while (j <= right)
			temp[k++] = arr[j++];
		// overwrite arr with temp
		for (int iTmp = 0; iTmp < temp.length; iTmp++) {
			arr[left + iTmp] = temp[iTmp];
		}
	}
	
	static void quickSorting(int arr[]) {
		
	}
}
