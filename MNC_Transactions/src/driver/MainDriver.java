package driver;

import bst_service.BinarySearchTree;
import bst_service.Node;

public class MainDriver {
	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();

		tree.root = new Node(50);
		tree.root.left = new Node(30);
		tree.root.right = new Node(60);
		tree.root.left.left = new Node(10);
		tree.root.right.left = new Node(55);

		tree.convertBSTtoSkewedTree(tree.root);
		tree.printInorder(tree.stHead);
	}
}