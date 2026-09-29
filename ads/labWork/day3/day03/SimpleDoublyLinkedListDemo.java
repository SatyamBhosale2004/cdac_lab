import java.util.Scanner;

public class SimpleDoublyLinkedListDemo {

    private static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private Node tail;

    void insertAtBeginning(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    void insertAtEnd(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
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

        if (current.next == null) {
            insertAtEnd(value);
            return;
        }

        Node newNode = new Node(value);
        Node nextNode = current.next;

        current.next = newNode;
        newNode.prev = current;
        newNode.next = nextNode;
        nextNode.prev = newNode;
    }

    int deleteAtBeginning() {
        if (head == null) {
            System.out.println("Doubly linked list is empty");
            return -1;
        }

        int removed = head.data;
        head = head.next;

        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }

        return removed;
    }

    int deleteAtEnd() {
        if (tail == null) {
            System.out.println("Doubly linked list is empty");
            return -1;
        }

        int removed = tail.data;
        tail = tail.prev;

        if (tail == null) {
            head = null;
        } else {
            tail.next = null;
        }

        return removed;
    }

    boolean deleteByValue(int value) {
        Node current = head;

        while (current != null && current.data != value) {
            current = current.next;
        }

        if (current == null) {
            return false;
        }

        if (current == head) {
            deleteAtBeginning();
            return true;
        }

        if (current == tail) {
            deleteAtEnd();
            return true;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;
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

    int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    void displayForward() {
        if (head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }

        System.out.print("Forward: ");
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }

        System.out.println();
    }

    void displayBackward() {
        if (tail == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }

        System.out.print("Backward: ");
        Node current = tail;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleDoublyLinkedListDemo list = new SimpleDoublyLinkedListDemo();

        while (true) {
            System.out.println();
            System.out.println("Doubly Linked List Operations:");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at end");
            System.out.println("3. Insert at position");
            System.out.println("4. Delete at beginning");
            System.out.println("5. Delete at end");
            System.out.println("6. Delete by value");
            System.out.println("7. Search");
            System.out.println("8. Display forward");
            System.out.println("9. Display backward");
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
                    list.displayForward();
                    break;
                case 9:
                    list.displayBackward();
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