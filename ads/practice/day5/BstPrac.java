

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class BstPrac {
private static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinarySearchTree t = new BinarySearchTree();
		t.add(50);
		t.add(30);
		t.add(90);
		t.add(10);
		t.add(40);
		t.add(70);
		t.add(100);
		t.add(20);
		t.add(60);
		t.add(80);
		t.preOrder();
		t.preOrderWORecursion();
		t.inOrder();
		t.inOrderWORecursion();
		t.postOrder();
		t.postOrderWORecursion();
		
		System.out.println("Enter element you want to search");
		t.bfs(sc.nextInt());
		System.out.println("Height of tree is " + t.height());
		t.deleteAll();
		System.out.println("Height of tree after deleteALL " + t.height());
	}

}

class BinarySearchTree {
	// Node
	static class Node {
		// Node mai data left right
		private int data;
		private Node left;
		private Node right;

		/// Node methods
		public Node() {
			data = 0;
			left = null;
			right = null;
		}

		public Node(int val) {
			data = val;
			left = null;
			right = null;
		}
	}

	// Tree fields
	private Node root;

	// tree methods
	public BinarySearchTree() {
		root = null;
	}

	public void add(int val) {
		Node newNode = new Node(val);
		if (root == null)
			root = newNode;
		else {
			Node trav = root;
			while (true) {
				if (val < trav.data) {
					if (trav.left != null)
						trav = trav.left;
					else {
						trav.left = newNode;
						break;
					}
				} else {
					if (trav.right != null)
						trav = trav.right;
					else {
						trav.right = newNode;
						break;
					}
				}
			}
		}
	}

	public void preOrder(Node trav) {
		if (trav == null)
			return;
		System.out.print(trav.data + ", ");
		preOrder(trav.left);
		preOrder(trav.right);
	}

	public void inOrder(Node trav) {
		if (trav == null)
			return;
		inOrder(trav.left);
		System.out.print(trav.data + ", ");
		inOrder(trav.right);
	}

	public void postOrder(Node trav) {
		if (trav == null)
			return;
		postOrder(trav.left);
		postOrder(trav.right);
		System.out.print(trav.data + ", ");
	}

	public void preOrder() {
		System.out.print("Pre : ");
		preOrder(root);
		System.out.println();
	}

	public void inOrder() {
		System.out.print("In : ");
		inOrder(root);
		System.out.println();
	}

	public void postOrder() {
		System.out.print("Post : ");
		postOrder(root);
		System.out.println();
	}

	// height
	public int height(Node trav) {
		if (trav == null)
			return -1;
		int hl = height(trav.left);
		int hr = height(trav.right);
		int max = hl > hr ? hl : hr;
		return max + 1;
	}

	public int height() {

		return height(root);
	}

	public void deleteAll() {
		deleteAll(root);
		root = null;
	}

	private void deleteAll(Node trav) {
		if (trav == null)
			return;
		deleteAll(trav.left);
		deleteAll(trav.right);
		trav.left = null;
		trav.right = null;
		trav = null;
	}

	public void preOrderWORecursion() {
		System.out.print("PreWOR : ");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		while (trav != null || !s.isEmpty()) {
			while (trav != null) {
				System.out.print(trav.data + ", ");
				if (trav != null)
					s.push(trav.right);
				trav = trav.left;
			}
			if (!s.isEmpty())
				trav = s.pop();
		}
		System.out.println();
	}

	public void inOrderWORecursion() {
		System.out.print("InWOR : ");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		while (trav != null || !s.isEmpty()) {
			while (trav != null) {
				s.push(trav);
				trav = trav.left;
			}
			if (!s.isEmpty()) {
				trav = s.pop();
				System.out.print(trav.data + ", ");
				trav = trav.right;
			}
		}
		System.out.println();
	}

	public void postOrderWORecursion() {
		System.out.print("PostWOR : ");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		Node lastVisited= null;
		while (trav != null || !s.isEmpty()) {
			while (trav != null) {
//				System.out.print(trav.data + ", ");
//				if (trav != null)
				s.push(trav);
				trav = trav.left;
			}
			
			Node peekNode = s.peek();
			if (peekNode.right != null && lastVisited != peekNode.right)
				trav = peekNode.right;
			else {
				System.out.print(peekNode.data + ", ");
				lastVisited = s.pop();
			}
		}
		System.out.println();
	}
	
	public Node bfs(int val) {
		if( root == null)
			return null;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			Node trav = q.poll();
			if(val==trav.data) {
				System.out.println("Value found");
				return trav;
			}
			if(trav.left != null)
				q.offer(trav.left);
			if(trav.right != null)
				q.offer(trav.right);
		}
		System.out.println("Value not found"); 
		return null;
	}
}