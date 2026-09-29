import java.util.Scanner;

public class SimpleLinkedListDemo {

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    void insertAtBeginning(int value) {
        Node newNode = new Node(value);
       
        newNode.next = head;
         head = newNode;
    }

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

    void insertAtPosition(int value, int position) {
        if (position <= 1 || head == null) {
            insertAtBeginning(value);
            return;
        }

        Node current = head;
        int index = 1;
        while (current.next != null && index < position - 1) {
            current = current.next;
            index++;
        }

        Node newNode = new Node(value);
        newNode.next = current.next;
        current.next = newNode;
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

    int deleteAtEnd() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return -1;
        }

        if (head.next == null) {
            int removed = head.data;
            head = null;
            return removed;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        int removed = current.next.data;
        current.next = null;
        return removed;
    }

boolean deleteByValue(int value) { // 50
        if (head == null) {
            return false;
        }
        if (head.data == value) {
            head = head.next;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        current.next = current.next.next;
        return true;
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

    void reverse() {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = previous;
            previous = current;
            current = nextNode;
        }

        head = previous;
    }

    int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
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
        SimpleLinkedListDemo list = new SimpleLinkedListDemo();

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
                    System.out.print("Enter position (1-based): ");
                    int position = scanner.nextInt();
                    list.insertAtPosition(value, position);
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
                    System.out.println(list.deleteByValue(deleteValue) ? "Value deleted" : "Value not found");
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
}