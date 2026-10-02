
import java.util.Scanner;

public class LinkedListPrac {
	private Node head;
	private Node tail;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		LinkedListPrac list = new LinkedListPrac();

        while (true) {
            System.out.println();
            System.out.println("Singly Linked List Operations:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete at beginning");
            System.out.println("5. Delete at end");
            System.out.println("6. Delete by value");
            System.out.println("7. Search");
	        System.out.println("8. Reverse");
	        System.out.println("9. Display");
	        System.out.println("10. Size");
	        System.out.println("11. Exit");
	        System.out.print("Enter your choice: ");
	
	        int choice = scanner.nextInt();
	
	        switch (choice) {
	            case 1:
	                System.out.print("Enter value: ");
	                list.insertAtBeginning(scanner.nextInt());
	                break;
	            case 2:
	                System.out.print("Enter value: ");
	                list.insertAtEnd(scanner.nextInt());
	                break;
	            case 3:
	                System.out.print("Enter value: ");
	                int value = scanner.nextInt();
	                System.out.print("Enter position : ");
	                int position = scanner.nextInt();
	                list.insertAtPosition(position, value);
	                break;
	            case 4:
	                int removedBeginning = list.deleteAtBeginning();
	                if (removedBeginning != -1) {
	                    System.out.println(removedBeginning + " deleted from beginning");
	                }
	                break;
	            case 5:
	                int removedEnd = list.deleteAtEnd();
	                if (removedEnd != -1) {
	                    System.out.println(removedEnd + " deleted from end");
	                }
	                break;
	            case 6:
	                System.out.print("Enter value to delete: ");
	                int deleteValue = scanner.nextInt();
	                System.out.println(list.deleteByValue(deleteValue) + "Value deleted");
	                break;
	            case 7:
	                System.out.print("Enter value to search: ");
	                int searchValue = scanner.nextInt();
	                System.out.println(list.search(searchValue) ? "Value found" : "Value not found");
	                break;
	            case 8:
	                list.reverse();
	                System.out.println("List reversed");
	                break;
	            case 9:
	                list.display();
	                break;
	            case 10:
	                System.out.println("Size: " + list.size());
	                break;
	            case 11:
	                System.out.println("Exiting...");
	                scanner.close();
	                return;
	            default:
	                System.out.println("Invalid choice");
	        }
        }
	}

	class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}


	void insertAtBeginning(int value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = newNode;
			tail=newNode;
			return;
		}
		newNode.next = head;
		head = newNode;
	}

	void insertAtEnd(int value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = newNode;
			tail=newNode;
			return;
		}
		tail.next = newNode;
		tail=newNode;
	}
	
	void insertAtPosition(int position, int value) {
		Node newNode = new Node(value);
		if(position == 1 || head == null) {
			insertAtBeginning(value);
			return;
		}

		Node current = head;
		int currPointer =1;
		while(current.next!=null && currPointer < position-1) {
			current = current.next;
			currPointer++;
			
		}
		
		if(currPointer != position-1) {
			System.out.println("Invalid Position");
			return;
		}
		
		newNode.next = current.next;
		current.next = newNode;
		
		if(newNode.next == null) {
			tail = newNode;
		}
	}
	int deleteAtBeginning() {
		if(head == null) {
			System.out.println("List is empty");
			return -1;
		} 
		
		int remove = head.data;
		head = head.next;
		if(head == null)
			tail = null;
		return remove;
	}
	int deleteAtEnd() {
		if(head == null) {
			System.out.println("List is empty");
			return -1;
		}
		
		if(head == tail) {
			int remove = head.data;
			head = null;
			tail = null;
			return remove;
		}
		Node current = head;
		
		while(current.next!=tail) {
			current = current.next;
		}
		
		int remove = tail.data;
		tail = current;
		tail.next = null;
		return remove;
	}
	int deleteByValue(int value) {
		if(head == null) {
			System.out.println("List is empty");
			return -1;
		}
		if(head.data == value) {
			int remove = head.data;
			head = head.next;
			if(head == null)
				tail = null;
			return remove;
		}
		Node current = head;
		while(current.next!=null && current.next.data !=value) {
			current = current.next;
		}
		if(current.next == null) {
		    System.out.println("Value not found");
		    return -1;
		}
		if(current.next == tail) {
			tail = current;
		}
		
		int remove = current.next.data;
		current.next = current.next.next;
		return remove;
		
	}
	void reverse() {
		Node prev = null;
		Node current = head;
		tail = head;
		while(current!=null) {
			Node nextNode = current.next;
			current.next = prev;
			prev = current;
			current = nextNode;
		}
		head = prev;
		
	}
	boolean search(int value) {
		Node current = head;
		while(current != null ) {
			if(current.data == value)
				return true;	
			current = current.next;
		}
		return false;
		
	}
	void display() {
		Node current = head;
		while(current != null) {
			
			System.out.println(current.data);
			current = current.next;
		}
	}
	int size() {
		Node current = head;
		int count =0;
		while(current != null) {
			count++;
			current = current.next;
		}
		return count;
	}
}