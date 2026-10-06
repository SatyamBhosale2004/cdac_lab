package in.ads.practice.day3;

import java.util.Scanner;

public class DLL {
	private static final Scanner sc = new Scanner(System.in);
	private Node head;
	private Node tail;

	static class Node {
		int data;
		Node next;
		Node prev;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		DLL list = new DLL();

		int choice;

		do {
			System.out.println("\n----- Doubly Linked List -----");
			System.out.println("1. Add at beginning");
			System.out.println("2. Add at last");
			System.out.println("3. Add at position");
			System.out.println("4. Delete at beginning");
			System.out.println("5. Delete at last");
			System.out.println("6. Delete by value");
			System.out.println("7. Search");
			System.out.println("8. Display");
			System.out.println("9. Size");
			System.out.println("10. Reverse");
			System.out.println("0. Exit");

			System.out.print("Enter choice: ");
			choice = sc.nextInt();

			switch (choice) {

			case 1:
				System.out.print("Enter value: ");
				list.addAtBeg(sc.nextInt());
				break;

			case 2:
				System.out.print("Enter value: ");
				list.addAtLast(sc.nextInt());
				break;

			case 3:
				System.out.print("Enter position: ");
				int position = sc.nextInt();

				System.out.print("Enter value: ");
				int val = sc.nextInt();

				list.addAtPosition(position, val);
				break;

			case 4:
				System.out.println("Deleted: " + list.delAtBeg());
				break;

			case 5:
				System.out.println("Deleted: " + list.delAtLast());
				break;

			case 6:
				System.out.print("Enter value to delete: ");
				System.out.println("Deleted: " + list.delByVal(sc.nextInt()));
				break;

			case 7:
				System.out.print("Enter value to search: ");
				System.out.println(list.search(sc.nextInt()) ? "Value found" : "Value not found");
				break;

			case 8:
				System.out.print("List: ");
				list.display();
				break;

			case 9:
				System.out.println("Size: " + list.size());
				break;

			case 10:
				list.reverse();
				System.out.println("List reversed.");
				break;

			case 0:
				System.out.println("Exiting...");
				break;

			default:
				System.out.println("Invalid choice.");
			}

		} while (choice != 0);
	}

	void addAtBeg(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}

	void addAtLast(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;
			tail = newNode;
			return;
		}
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
	}

	void addAtPosition(int position, int val) {
		Node newNode = new Node(val);
		if (position <= 0) {
			System.out.println("Invalid Position");
			return;
		}
		if (position == 1) {
			addAtBeg(val);
			return;
		}

		if (head == null) {
			System.out.println("List is empty");
			return;
		}

		Node current = head;
		int currPointer = 1;
		while (current.next != null && currPointer < position - 1) {
			current = current.next;
			currPointer++;
		}
		if (currPointer != position - 1) {
			System.out.println("Invalid Position");
			return;
		}
		newNode.prev = current;
		newNode.next = current.next;
		if(current.next!=null)
			current.next.prev = newNode;
		else
			tail = newNode;
		current.next = newNode;
	}

	int delAtBeg() {
		if (head == null) {
			System.out.println("List is empty");
			return -1;
		}
		int remove = head.data;
		head = head.next;
		if (head == null)
			tail = null;
		else
			head.prev = null;		
		return remove;
	}

	int delAtLast() {
		if (head == null) {
			System.out.println("List is empty");
			return -1;
		}
		if (head == tail) {
			int remove = head.data;
			head = null;
			tail = null;
			return remove;
		}
		int remove = tail.data;
		tail = tail.prev;
		tail.next = null;
		return remove;
	}

	int delByVal(int val) {
		if (head == null) {
			System.out.println("List is empty");
			return -1;
		}
		if (head.data == val) {
			return delAtBeg();
		}
		if (tail.data == val) {
			return delAtLast();
		}
		Node current = head;
		while (current.next != null && current.next.data != val) {
			current = current.next;
		}
		if (current.next == null) {
			System.out.println("Value not found");
			return -1;
		}
		int remove = current.next.data;
		current.next = current.next.next;
		current.next.prev = current;
		return remove;
	}

	void reverse() {
		Node current = head;
		tail = head;
		while (current != null) {
			Node temp = current.prev;
			current.prev = current.next;
			current.next = temp;
			current = current.prev;
		}
		Node temp = head;
		head = tail;
		tail = temp;
	}

	boolean search(int val) {
		Node current = head;
		while (current != null) {
			if (current.data == val)
				return true;
			current = current.next;
		}
		return false;
	}

	void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.data + ", ");
			current = current.next;
		}
	}

	int size() {
		Node current = head;
		int count = 0;
		while (current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
}
