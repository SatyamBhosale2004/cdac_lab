package in.ads.practice.day2;

import java.util.Scanner;

public class DynamicArray<T> {
	private static final Scanner sc = new Scanner(System.in);
	private Object data[];
	private int size;

	DynamicArray(int initialCapacity) {
		data = new Object[initialCapacity];
	}

	public int size() {
		return size;
	}

	public int capacity() {
		return data.length;
	}

	public static void main(String[] args) {
		System.out.println("Enter array's capacity");
		DynamicArray<Integer> obj = new DynamicArray<>(sc.nextInt());

		int choice;

		do {
			System.out.println("\n----- Dynamic Array Menu -----");
			System.out.println("1. Add");
			System.out.println("2. Insert At");
			System.out.println("3. Get");
			System.out.println("4. Set");
			System.out.println("5. Remove At");
			System.out.println("6. Display");
			System.out.println("7. Size");
			System.out.println("8. Capacity");
			System.out.println("0. Exit");

			System.out.print("Enter choice: ");
			choice = sc.nextInt();

			try {
				switch (choice) {

				case 1:
					System.out.print("Enter element: ");
					int elem = sc.nextInt();
					obj.add(elem);
					System.out.println("Element added.");
					break;

				case 2:
					System.out.print("Enter element: ");
					elem = sc.nextInt();

					System.out.print("Enter index: ");
					int index = sc.nextInt();

					obj.insertAt(elem, index);
					System.out.println("Element inserted.");
					break;

				case 3:
					System.out.print("Enter index: ");
					index = sc.nextInt();

					System.out.println("Element: " + obj.get(index));
					break;

				case 4:
					System.out.print("Enter element: ");
					elem = sc.nextInt();

					System.out.print("Enter index: ");
					index = sc.nextInt();

					obj.set(elem, index);
					System.out.println("Element updated.");
					break;

				case 5:
					System.out.print("Enter index: ");
					index = sc.nextInt();

					obj.removeAt(index);
					System.out.println("Element removed.");
					break;

				case 6:
					obj.display();
					break;

				case 7:
					System.out.println("Size: " + obj.size());
					break;

				case 8:
					System.out.println("Capacity: " + obj.capacity());
					break;

				case 0:
					System.out.println("Exiting...");
					break;

				default:
					System.out.println("Invalid choice.");
				}

			} catch (IndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}

		} while (choice != 0);
	}

	public void display() {
		System.out.print("Array: ");

		for (int iTmp = 0; iTmp < size; iTmp++) {
			System.out.print(data[iTmp] + " ");
		}

		System.out.println();
	}

	public void add(T elem) {
		if (size == data.length)
			grow();

		data[size] = elem;
		size++;
	}

	public void grow() {
		// new capacity
		int newCap = data.length * 2;
		Object newData[] = new Object[newCap];

		for (int iTmp = 0; iTmp < size; iTmp++) {
			newData[iTmp] = data[iTmp];
		}

		data = newData;// data points to new array now

	}

	public T get(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Invalid index");

		return (T) data[index];
	}

	public void set(T elem, int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Invalid index");
		data[index] = elem;
	}

	public void insertAt(T elem, int index) {
		if (index > size || index < 0)
			throw new IndexOutOfBoundsException("Invalid index");
		if (size == data.length)
			grow();
		for (int iTmp = size; iTmp > index; iTmp--) {
			data[iTmp] = data[iTmp - 1];
		}
		data[index] = elem;
		size++;
	}

	public void removeAt(int index) {
		if (index >= size || index < 0)
			throw new IndexOutOfBoundsException("Invalid index");
		for (int iTmp = index; iTmp < size - 1; iTmp++) {
			data[iTmp] = data[iTmp + 1];
		}
		data[size] = null;
		size--;
	}

}
