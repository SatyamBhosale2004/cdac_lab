package in.ads.practice.day2;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class QueueUsingArray<T> {
	private static final Scanner sc = new Scanner(System.in);
	private int front = -1;
	private int rear = -1;
	private Object data[];

	QueueUsingArray(int initialCapacity) {
		data = new Object[initialCapacity];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter queue's array capacity");
		QueueUsingArray<Integer> q = new QueueUsingArray<>(sc.nextInt());

		int choice;

		do {
			System.out.println("\n----- Queue Using Array Menu -----");
			System.out.println("1. enqueue");
			System.out.println("2. dequeue");
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
					q.enqueue(elem);
					System.out.println("Element pushed.");
					break;

				case 2:
					System.out.println("Element poped  is " + q.dequeue());
					break;

				case 3:
					System.out.println("Element at top is " + q.peek());
					break;

				case 4:
					System.out.println("Stack is empty? " + q.isEmpty());
					break;

				case 5:
					System.out.println("Stack is full? " + q.isFull());
					break;

				case 6:
					System.out.println("Size of queue is " + q.size());
					break;

				case 7:
					q.display();
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
		System.out.print("Queue (front->rear): ");

		for (int iTmp = front; iTmp <= rear; iTmp++) {
			System.out.print(data[iTmp] + " ");
		}

		System.out.println();
	}

	public void enqueue(T elem) {
		if (isFull())
			throw new IllegalStateException("Queue overflow");
		if (front == -1)
			front++;
		rear++;
		data[rear] = elem;
	}

	public T dequeue() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		T elem = (T) data[front];
//		if(elem != data[top])
//			return null;
		data[front] = null;
		if (front == rear) {
			front = -1;
			rear = -1;
		} else
			front++;
		return elem;

	}

	public T peek() {
		if (isEmpty())
			throw new NoSuchElementException("Queue underflow");
		return (T) data[front];
	}

	public boolean isEmpty() {
		return front == -1;
	}

	public boolean isFull() {
		return rear == data.length - 1;
	}

	public int size() {
		if (isEmpty())
			return 0;
		return rear - front + 1;
	}
}
