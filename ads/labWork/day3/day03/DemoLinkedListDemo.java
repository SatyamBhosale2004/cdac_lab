import java.util.Scanner;

public class DemoLinkedListDemo {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    void insertAtBeginning(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }

    int deleteAtBeginning() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return -1;
        }

        int removed = head.data;
        head = head.next;
        return removed;
    }

    boolean search(int value) {
        Node current = head;

        while (current != null) {
            if (current.data == value) {
                return true;
            }
            current = current.next;
        }

        return false;
    }

    void display() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }

        System.out.print("Linked list elements: ");
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DemoLinkedListDemo list = new DemoLinkedListDemo();

        while (true) {
            System.out.println();
            System.out.println("Linked List Operations:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Delete from beginning");
            System.out.println("4. Search");
            System.out.println("5. Display");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at beginning: ");
                    list.insertAtBeginning(scanner.nextInt());
                    break;
                case 2:
                    System.out.print("Enter value to insert at end: ");
                    list.insertAtEnd(scanner.nextInt());
                    break;
                case 3:
                    int removed = list.deleteAtBeginning();
                    if (removed != -1) {
                        System.out.println(removed + " deleted from linked list");
                    }
                    break;
                case 4:
                    System.out.print("Enter value to search: ");
                    int value = scanner.nextInt();
                    System.out.println(list.search(value) ? "Value found" : "Value not found");
                    break;
                case 5:
                    list.display();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}