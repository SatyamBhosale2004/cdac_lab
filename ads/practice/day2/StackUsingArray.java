package in.ads.practice.day2;

import java.util.Scanner;
import java.util.NoSuchElementException;
public class StackUsingArray<T> {
	private static final Scanner sc = new Scanner(System.in);
	private int top = -1;
	private Object data[];

	StackUsingArray(int initialCapacity) {
		data = new Object[initialCapacity];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter stack's array capacity");
		StackUsingArray<Integer> s = new StackUsingArray<>(sc.nextInt());

		int choice;

		do {
			System.out.println("\n----- Stack Using Array Menu -----");
			System.out.println("1. push");
			System.out.println("2. pop");
			System.out.println("3. peek");
			System.out.println("4. isEmpty");
			System.out.println("5. isFull");
			System.out.println("6. size");
			System.out.println("7. Display");
			System.out.println("0. Exit");

			System.out.print("Enter choice: ");
			choice = sc.nextInt();

			try {
				switch (choice) {

				case 1:
					System.out.print("Enter element: ");
					int elem = sc.nextInt();
					s.push(elem);
					System.out.println("Element pushed.");
					break;

				case 2:
					System.out.println("Element poped  is " + s.pop());
					break;

				case 3:
					System.out.println("Element at top is " + s.peek());
					break;

				case 4:
					System.out.println("Stack is empty? " + s.isEmpty());
					break;

				case 5:
					System.out.println("Stack is full? " + s.isFull());
					break;

				case 6:
					System.out.println("Size of stack is " + s.size());
					break;

				case 7:
					s.display();
					break;

				case 0:
					System.out.println("Exiting...");
					break;

				default:
					System.out.println("Invalid choice.");
				}

			} catch (IllegalStateException | NoSuchElementException e) {
				System.out.println(e.getMessage());
			}

		} while (choice != 0);
	}

	public void display() {
		System.out.print("Stack (top->bottom): ");

		for (int iTmp = top; iTmp > -1; iTmp--) {
			System.out.print(data[iTmp] + " ");
		}

		System.out.println();
	}

	public void push(T elem) {
		if (isFull())
			throw new IllegalStateException("Stack overflow");
		top++;
		data[top] = elem;
	}

	public T pop() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		T elem = (T) data[top];
//		if(elem != data[top])
//			return null;
		data[top] = null;
		top--;
		return elem;

	}

	public T peek() {
		if (isEmpty())
			throw new NoSuchElementException("Stack underflow");
		return (T) data[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public boolean isFull() {
		return top == data.length-1;
	}

	public int size() {
		return top + 1;
	}
}
