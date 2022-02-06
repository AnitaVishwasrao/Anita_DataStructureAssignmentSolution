package bst_service;

public class BinarySearchTree {

	public Node root;

	// Used for Skewed Tree
	public Node stHead;
	public Node stPrevNode;

	public BinarySearchTree() {
		root = null;
		stHead = null;
		stPrevNode = null;
	}

	public void insertNode(Node root, int data) {
		Node newNode = new Node(data);
		Node x = root;
		Node current_parent = null;

		while (x != null) {
			current_parent = x;
			if (data < x.data)
				x = x.left;
			else if (data > x.data)
				x = x.right;
			else {
				return;
			}
		}

		if (current_parent == null) {
			current_parent = newNode;
			this.root = current_parent;
		}

		else if (current_parent.data < data)
			current_parent.right = newNode;
		else
			current_parent.left = newNode;

	}

	public void printInorder(Node root) {
		if (root == null) {
			return;
		} else {
			printInorder(root.left);
			System.out.print(root.data + " ");
			printInorder(root.right);
		}
	}

	public void convertBSTtoSkewedTree(Node root) {
		if (root == null)
			return;

		convertBSTtoSkewedTree(root.left);

		Node rightNode = root.right;

		if (stHead == null) {
			stHead = root;
			stHead.left = null;
			stPrevNode = root;
		} else {
			stPrevNode.right = root;
			root.left = null;
			stPrevNode = root;
		}

		convertBSTtoSkewedTree(rightNode);
	}
}
