import java.util.Scanner;

public class Qusingstack {

	private final StackDemo inputStack = new StackDemo();
	private final StackDemo outputStack = new StackDemo();

	void enqueue(char value) {
		inputStack.push(value);
		System.out.println(value + " inserted into queue");
	}

	char dequeue() {
		if (isEmpty()) {
			System.out.println("Queue Underflow");
			return '\0';
		}

		moveInputToOutputIfNeeded();
		return outputStack.pop();
	}

	char peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return '\0';
		}

		moveInputToOutputIfNeeded();
		return outputStack.stack[outputStack.top];
	}

	boolean isEmpty() {
		return inputStack.isEmpty() && outputStack.isEmpty();
	}

	void display() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}

		System.out.print("Queue elements: ");

		for (int i = outputStack.top; i >= 0; i--) {
			System.out.print(outputStack.stack[i] + " ");
		}

		for (int i = 0; i <= inputStack.top; i++) {
			System.out.print(inputStack.stack[i] + " ");
		}

		System.out.println();
	}

	private void moveInputToOutputIfNeeded() {
		if (outputStack.isEmpty()) {
			while (!inputStack.isEmpty()) {
				outputStack.push(inputStack.pop());
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Qusingstack queue = new Qusingstack();

		while (true) {
			System.out.println();
			System.out.println("Queue Using StackDemo Operations:");
			System.out.println("1. Enqueue");
			System.out.println("2. Dequeue");
			System.out.println("3. Peek");
			System.out.println("4. Display");
			System.out.println("5. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();

			switch (choice) {
				case 1:
					System.out.print("Enter a character to enqueue: ");
					char value = scanner.next().charAt(0);
					queue.enqueue(value);
					break;
				case 2:
					char removed = queue.dequeue();
					if (removed != '\0') {
						System.out.println(removed + " removed from queue");
					}
					break;
				case 3:
					char frontValue = queue.peek();
					if (frontValue != '\0') {
						System.out.println("Front element: " + frontValue);
					}
					break;
				case 4:
					queue.display();
					break;
				case 5:
					System.out.println("Exiting...");
					scanner.close();
					return;
				default:
					System.out.println("Invalid choice");
			}
		}
	}
}
