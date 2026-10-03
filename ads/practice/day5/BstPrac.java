package in.ads.practice.day5;

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
		t.postOrderWORecursion2();
		System.out.println("Enter element you want to search via bfs");
		t.bfs(sc.nextInt());
		System.out.println("Enter element you want to search via dfs");
		t.dfs(sc.nextInt());
		System.out.println("Enter element you want to search via bs");
		t.binarySearch(sc.nextInt());
		System.out.println("Enter element you want to search via bs with its parent");
		BinarySearchTree.Node[] arr = t.binarySearchChildWithParent(sc.nextInt());
		if (arr[0] == null)
			System.out.println("Value not found");
		else if (arr[1] == null)
			System.out.println("Value found at " + arr[0].getData() + " with parent " + arr[1]);
		else
			System.out.println("Value found at " + arr[0].getData() + " with parent " + arr[1].getData());
		System.out.println("Height of tree is " + t.height());
		System.out.println("Size of tree : ");
		System.out.println(t.size());
		System.out.println("No of leaves : ");
		System.out.println(t.leaves());
		System.out.println("Min element is : ");
		System.out.println(t.min().getData());
		System.out.println("Max element is : ");
		System.out.println(t.max().getData());
		System.out.println("Level by level tree");
		t.levelByLevel();
		System.out.println("Tree is a full binary tree or not ?");
		System.out.println(t.isFull());
		System.out.println("Tree is a perfect binary tree or not ?");
		System.out.println(t.isPrefect());
		System.out.println("Tree is a complete binary tree or not ?");
		System.out.println(t.isCompleted());
		System.out.println("Tree is a binary tree or not ?");
		System.out.println(t.isBst());
		System.out.println("Enter element to delete ");
		t.deleteNode(sc.nextInt());
		System.out.println("Size of tree now : ");
		t.size();
		System.out.println("Tree now: ");
		t.inOrder();
		
		
//		t.deleteAll();
//		System.out.println("Height of tree after deleteALL " + t.height());
	}

}

class BinarySearchTree {
	// Node
	static class Node {
		// Node mai data left right
		private int data;
		private Node left;
		private Node right;
		public boolean visited;

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

		public int getData() {
			return data;
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
		System.out.print("Pre : \t\t");
		preOrder(root);
		System.out.println();
	}

	public void inOrder() {
		System.out.print("In : \t\t");
		inOrder(root);
		System.out.println();
	}

	public void postOrder() {
		System.out.print("Post : \t\t");
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
		System.out.print("PreWOR : \t");
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
		System.out.print("InWOR : \t\t");
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
		System.out.print("PostWOR : \t");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		Node lastVisited = null;
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

	public void postOrderWORecursion2() {
		System.out.print("PostWOR2 : \t");
		Stack<Node> s = new Stack<>();
		Node trav = root;
		while (trav != null || !s.isEmpty()) {
			while (trav != null) {
				s.push(trav);
				trav = trav.left;
			}
			if (!s.empty()) {
				trav = s.pop();
				if (trav.right != null && !trav.right.visited) {
					s.push(trav);
					trav = trav.right;
				} else {
					System.out.print(trav.data + ", ");
					trav.visited = true;
					trav = null;

				}
			}
		}
		System.out.println();
	}

	public Node bfs(int val) {
		if (root == null)
			return null;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			Node trav = q.poll();
			if (val == trav.data) {
				System.out.println("Value found");
				return trav;
			}
			if (trav.left != null)
				q.offer(trav.left);
			if (trav.right != null)
				q.offer(trav.right);
		}
		System.out.println("Value not found");
		return null;
	}

	public Node dfs(int val) {
		if (root == null)
			return null;
		Stack<Node> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {
			Node trav = s.pop();
			if (val == trav.data) {
				System.out.println("Value found");
				return trav;
			}
			if (trav.left != null)
				s.push(trav.left);
			if (trav.right != null)
				s.push(trav.right);
		}
		System.out.println("Value not found");
		return null;
	}

	public Node binarySearch(int val) {
		if (root == null)
			return null;
		Node trav = root;
		while (trav != null) {
			if (val == trav.data) {
				System.out.println("Value found");
				return trav;
			}
			if (val < trav.data)
				trav = trav.left;
			else
				trav = trav.right;
		}
		System.out.println("Value not found");
		return null;
	}

	public Node[] binarySearchChildWithParent(int val) {

		Node parent = null;
		Node trav = root;
		while (trav != null) {
			if (val == trav.data) {
				return new Node[] { trav, parent };
			}
			parent = trav;
			if (val < trav.data)
				trav = trav.left;
			else
				trav = trav.right;
		}
		System.out.println("Value not found");
		return new Node[] { null, null };
	}

	public void deleteNode(int val) {
		Node trav, parent;
		// find the node to be deleted along with parent
		Node[] arr = binarySearchChildWithParent(val);
		trav = arr[0];
		parent = arr[1];
		// if node is not found throw exe
		if (trav == null)
			throw new RuntimeException("Node not found");
		// if node has left and ruight child
		if (trav.left != null && trav.right != null) {
			// find its successor with parent
			parent = trav;
			Node succ = trav.right;
			while (succ.left != null) {
				parent = succ;
				succ = succ.left;
			}
			// overwrite node with succ data
			trav.data = succ.data;
			// mark succ as null
			trav = succ;
		}
		// if node has only right child
		if (trav.left == null) {
			if (trav == root)
				root = trav.right;
			else if (trav == parent.left)
				parent.left = trav.right;
			else
				parent.right = trav.right;
		}
		// if node has only left child
		else if (trav.right == null) {
			if (trav == root)
				root = trav.left;
			else if (trav == parent.left)
				parent.left = trav.left;
			else
				parent.right = trav.left;
		}

	}
	
	public int size(Node trav) {
		if(trav == null)
			return 0;
		return 1 + size(trav.left) + size(trav.right);
	}
	
	public int size() {
		return size(root);
	}
	
	public int leaves(Node trav) {
		if(trav == null)
			return 0;
		if(trav.left == null && trav.right == null)
			return 1;
		
		return leaves(trav.left) + leaves(trav.right);
	}
	public int leaves() {
		return leaves(root);
	}
	
	public Node min() {
		if(root == null)
			return null;
		Node trav = root;
		while(trav.left != null)
			trav = trav.left;
		
		return trav;
	}
	public Node max() {
		if(root == null)
			return null;
		Node trav = root;
		while(trav.right != null)
			trav = trav.right;
		
		return trav;
	}
	
	public void levelByLevel() {
		if(root == null)
			return;
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		
		int level = 0;
		
		while(!q.isEmpty()) {
			int count = q.size();
			System.out.print("Level " +level+ " : ");
			for(int iTmp = 0; iTmp < count ; iTmp++) {
				Node trav = q.poll();
				
				System.out.print(trav.data + ", ");
				if(trav.left!=null)
					q.offer(trav.left);
				if(trav.right!=null)
					q.offer(trav.right);
				
			}
			System.out.println();
			level++;
		}
	}
	
	public boolean isFull(Node trav) {
		if(root == null)
			return true;
		
		if(trav.left == null && trav.right == null)
			return true;
		
		if(trav.left == null || trav.right == null )
			return false;
		
		return isFull(trav.left) && isFull(trav.right);
	}
	
	public boolean isFull() {
		return isFull(root);
	}
	
	public boolean isPrefect() {
		int h = height();
		int expectedNoNodes = (1 << (h+1) + 1);
		
		return size() == expectedNoNodes;
	}
	
	public boolean isCompleted(Node trav, int index, int total) {
		if(trav == null)
			return true;
		
		if(index >= total)
			return false;
		
		return isCompleted(trav.left, 2*index + 1 ,total) && isCompleted(trav.right, 2*index+2,total);
	}
	
	public boolean isCompleted() {
		return isCompleted(root, 0 ,size()); 
	}
	
	public boolean isBst(Node trav, long min, long max) {
		if(trav==null)
			return true;
		
		if(trav.data <= min || trav.data >= max)
			return false;
		
		return isBst(trav.left, min , trav.data) && isBst(trav.right, trav.data, max );
	}
	
	public boolean isBst() {
		return isBst(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
}