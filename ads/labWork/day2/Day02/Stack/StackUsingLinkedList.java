public class StackUsingLinkedList<T> {

	private static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
		}
	}

	private Node<T> top;
	private int size;

	void push(T value) {
		Node<T> newNode = new Node<>(value);
		newNode.next = top;
		top = newNode;
		size++;
	}

	T pop() {
		if (isEmpty()) {
			return null;
		}

		T value = top.data;
		top = top.next;
		size--;
		return value;
	}

	T peek() {
		return isEmpty() ? null : top.data;
	}

	boolean isEmpty() {
		return top == null;
	}

	int size() {
		return size;
	}

	void display() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}

		System.out.print("Stack elements (top to bottom): ");
		Node<T> current = top;

		while (current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}

		System.out.println();
	}

	public static void main(String[] args) {
		StackUsingLinkedList<Integer> stack = new StackUsingLinkedList<>();

		stack.push(10);
		stack.push(20);
		stack.push(30);

		stack.display();
		System.out.println("Top element: " + stack.peek());
		System.out.println("Popped element: " + stack.pop());
		System.out.println("Size after pop: " + stack.size());
		stack.display();
	}
}
