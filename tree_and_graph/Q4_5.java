package tree_and_graph;

import CtCILibrary.TreeNode;

public class Q4_5 {
	// check if a binary tree is a binary search tree
	public static boolean isBSearchTree(TreeNode root){
		return isBSearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	private static boolean isBSearchTree(TreeNode node, int min, int max){
		if (node == null) return true;
		if (node.data <= min || node.data > max) {
			return false;
		} else {
			return isBSearchTree(node.left, min, node.data) && isBSearchTree(node.right, node.data, max);
		}
	}

	
	// Test
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		System.out.println("Is BST? " + isBSearchTree(root));
		System.out.println("Is BST? " + root.isBST()); // CtCILibrary function
		root.left.left.setLeftChild(new TreeNode(11)); // add a node to make it not BST
		System.out.println("Is BST? " + isBSearchTree(root));
		System.out.println("Is BST? " + root.isBST()); // CtCILibrary function
	}
}
