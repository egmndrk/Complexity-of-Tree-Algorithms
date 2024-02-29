package HW2_AVL;

import java.util.Random;
import java.util.Scanner;

public class AVLTreeExample {

	static class Node {
		long key;
		Node left, right;
		int height;

		Node(long key) {
			this.key = key;
			this.height = 1;
		}
	}

	static Node root;

	static int height(Node N) {
		return (N == null) ? 0 : N.height;
	}

	static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	static Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;
	}

	static Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		return y;
	}

	static int getBalance(Node N) {
		return (N == null) ? 0 : height(N.left) - height(N.right);
	}

	static Node insert(Node node, long key) {
		if (node == null) {
			return new Node(key);
		}

		if (key < node.key) {
			node.left = insert(node.left, key);
		} else if (key > node.key) {
			node.right = insert(node.right, key);
		} else {
			return node; // Duplicate keys are not allowed
		}

		node.height = 1 + max(height(node.left), height(node.right));

		int balance = getBalance(node);

		if (balance > 1 && key < node.left.key) {
			return rightRotate(node);
		}

		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}

		if (balance < -1 && key > node.right.key) {
			return leftRotate(node);
		}

		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}

		return node;
	}

	static Node minValueNode(Node node) {
		Node current = node;

		while (current.left != null)
			current = current.left;

		return current;
	}

	static Node deleteNode(Node root, long key) {
		if (root == null)
			return root;

		if (key < root.key)
			root.left = deleteNode(root.left, key);

		else if (key > root.key)
			root.right = deleteNode(root.right, key);

		else {
			if ((root.left == null) || (root.right == null)) {
				Node temp = (root.left != null) ? root.left : root.right;

				if (temp == null) {
					temp = root;
					root = null;
				} else
					root = temp;

			} else {
				Node temp = minValueNode(root.right);
				root.key = temp.key;
				root.right = deleteNode(root.right, temp.key);
			}
		}

		if (root != null) {
			root.height = max(height(root.left), height(root.right)) + 1;

			int balance = getBalance(root);

			if (balance > 1 && getBalance(root.left) >= 0)
				return rightRotate(root);

			if (balance > 1 && getBalance(root.left) < 0) {
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}

			if (balance < -1 && getBalance(root.right) <= 0)
				return leftRotate(root);

			if (balance < -1 && getBalance(root.right) > 0) {
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
		}

		return root;
	}

	static void inOrder(Node node) {
		if (node != null) {
			inOrder(node.left);
			System.out.print(node.key + " ");
			inOrder(node.right);
		}
	}

	static boolean search(Node root, long key) {
		if (root == null) {
			return false;
		}

		if (key == root.key) {
			return true;
		} else if (key < root.key) {
			return search(root.left, key);
		} else {
			return search(root.right, key);
		}
	}

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		Random random=new Random();
        
        
        System.out.println("Enter number of elements you want to insert: ");
		int n = user.nextInt();
		int [] arr = new int[n];
		for(int i=0; i<n; i++) {
			int number= random.nextInt();
			arr[i]=number;
		}
		long start = System.currentTimeMillis();
		for(int i2=0; i2<n; i2++) {
			root = insert(root, arr[i2]);
		}
		long finish = System.currentTimeMillis();
		long timeElapsed = finish - start;
		System.out.println(timeElapsed);


       
		System.out.println("Enter the number of elements you want to search: ");
		int m=user.nextInt();
		int [] arr2 = new int[m];
		for(int u=0; u<m; u++) {
			int number2= random.nextInt();
			arr2[u]=number2;
		}
		long start2 = System.currentTimeMillis();
		
		
		for(int u2=0; u2<m; u2++) {		
			root = deleteNode(root, arr2[u2]);
		}
		
		long finish2 = System.currentTimeMillis();
		long timeElapsed2 = finish2 - start2;
		System.out.println(timeElapsed2);

		System.out.println("Enter the number of elements you want to delete: ");
		int d=user.nextInt();
		int [] arr3 = new int[d];
		for(int p=0; p<d; p++) {
			int number3= random.nextInt();
			arr3[p]=number3;
		}
		long start3 = System.currentTimeMillis();
		for(int p2=0; p2<d; p2++) {
			
			root = deleteNode(root, arr[p2]);
		}
		long finish3 = System.currentTimeMillis();
		long timeElapsed3 = finish3 - start3;
		System.out.println(timeElapsed3);
		
	}
}
