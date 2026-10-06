package in.ads.practice.day3;

import java.util.Scanner;

public class SLL {
	private static final Scanner sc = new Scanner(System.in);
	private Node head;
	private Node tail;
	
	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		SLL list = new SLL();

		int choice;

		do {
			System.out.println("\n----- Singly Linked List -----");
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
		newNode.next = current.next;
		current.next = newNode;
		if (newNode.next == null)
			tail = newNode;
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
		Node current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		int remove = tail.data;
		tail = current;
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
		return remove;
	}

	void reverse() {
		Node prev = null;
		Node current = head;
		tail = head;
		while (current != null) {
			Node next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
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


class SCL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    // Add at beginning
    void addFirst(int value) {
        Node newNode = new Node(value);

        // Empty list
        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    // Add at end
    void addLast(int value) {
        Node newNode = new Node(value);

        // Empty list
        if (head == null) {
            head = tail = newNode;
            newNode.next = newNode;
            return;
        }

        newNode.next = head;
        tail.next = newNode;
        tail = newNode;
    }

    // Delete first
    int deleteFirst() {
        if (head == null)
            return -1;

        int value = head.data;

        // Only one node
        if (head == tail) {
            head = tail = null;
            return value;
        }

        head = head.next;
        tail.next = head;

        return value;
    }

    // Delete last
    int deleteLast() {
        if (head == null)
            return -1;

        // Only one node
        if (head == tail) {
            int value = head.data;
            head = tail = null;
            return value;
        }

        Node current = head;

        // Find node before tail
        while (current.next != tail) {
            current = current.next;
        }

        int value = tail.data;

        current.next = head;
        tail = current;

        return value;
    }

    // Display
    void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node current = head;

        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);

        System.out.println();
    }
}


class StackLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node top;

    // Push
    void push(int value) {
        Node newNode = new Node(value);

        newNode.next = top;
        top = newNode;
    }

    // Pop
    int pop() {
        if (top == null)
            return -1;

        int value = top.data;
        top = top.next;

        return value;
    }

    // Peek
    int peek() {
        if (top == null)
            return -1;

        return top.data;
    }

    boolean isEmpty() {
        return top == null;
    }

    void display() {
        Node current = top;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}

class QueueLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;

    // Enqueue
    void enqueue(int value) {
        Node newNode = new Node(value);

        // Empty queue
        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue
    int dequeue() {
        if (front == null)
            return -1;

        int value = front.data;

        front = front.next;

        // Queue became empty
        if (front == null) {
            rear = null;
        }

        return value;
    }

    int peek() {
        if (front == null)
            return -1;

        return front.data;
    }

    boolean isEmpty() {
        return front == null;
    }

    void display() {
        Node current = front;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }
}

class CircularQueueLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node rear;

    // Enqueue
    void enqueue(int value) {
        Node newNode = new Node(value);

        // Empty queue
        if (rear == null) {
            newNode.next = newNode;
            rear = newNode;
            return;
        }

        // Insert after rear
        newNode.next = rear.next;
        rear.next = newNode;
        rear = newNode;
    }

    // Dequeue
    int dequeue() {
        if (rear == null)
            return -1;

        Node front = rear.next;
        int value = front.data;

        // Only one node
        if (front == rear) {
            rear = null;
        } else {
            rear.next = front.next;
        }

        return value;
    }

    // Peek
    int peek() {
        if (rear == null)
            return -1;

        return rear.next.data;
    }

    boolean isEmpty() {
        return rear == null;
    }

    void display() {
        if (rear == null) {
            System.out.println("Queue is empty");
            return;
        }

        Node front = rear.next;
        Node current = front;

        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != front);

        System.out.println();
    }
}
