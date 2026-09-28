import java.util.Scanner;
import java.util.Stack;

public class UndoOperationDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> actions = new Stack<>();

        while (true) {
            System.out.println();
            System.out.println("1. Add action");
            System.out.println("2. Undo last action");
            System.out.println("3. Show actions");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter action: ");
                    String action = scanner.nextLine();
                    actions.push(action);
                    System.out.println("Action saved: " + action);
                    break;
                case 2:
                    if (actions.isEmpty()) {
                        System.out.println("Nothing to undo");
                    } else {
                        System.out.println("Undone: " + actions.pop());
                    }
                    break;
                case 3:
                    if (actions.isEmpty()) {
                        System.out.println("No actions available");
                    } else {
                        System.out.println("Current actions:");
                        for (String item : actions) {
                            System.out.println(item);
                        }
                    }
                    break;
                case 4:
                    scanner.close();
                    System.out.println("Exiting program");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}