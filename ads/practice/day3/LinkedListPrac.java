package in.ads.practice.day3;

import java.util.Scanner;
public class LinkedListPrac {
	private final Scanner sc = new Scanner(System.in);
	private Node head;

	public static void main(String args[]) {

	}

	void addAtFirst(int value) {
		Node newNode = new Node(value);
		// if list is empty
		if (head == null) {
			head = newNode;
		}
		newNode = head;
		head = newNode;
	}

	void addAtLast(int value) {
		Node newNode = new Node(value);
		Node current = head;
		// if list is empty
		if (head == null) {
			head = newNode;
		}
		while (current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}

	void addAtPos(int pos, int value) {
		Node newNode = new Node(value);
		Node current = head;
		if(pos ==1 || head == null) {
			addAtFirst(value);
		}
		for(int iTmp = 0 ; iTmp < pos-1 ; iTmp++) {
			if(current.next == null) {
				System.out.println("Invalid Position");
				break;
			}
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
		
	}
	
	void delAtFirst(int value) {
		if(head == null) {
			throw new RuntimeException("List is empty");
		}
		head = head.next;
	}
	
	void delAtLast(int value) {
		Node current = head;
		if(head == null) {
			
		}
		while(current.next!=null) {
			current = current.next;
		}
		current.next=null;
		
	}
}

class Node {
	int data;
	Node next;// self referencing class

	Node(int data) {
		this.data = data;
	}
}
