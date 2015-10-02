package tree_and_graph;

import CtCILibrary.TreeNode;

// check if a binary tree is balanced
public class Q4_1 {
	
	// method 1 - not efficient, time: O(n^2)
	public static boolean isBalanced(TreeNode root){
		if (root == null) return true;
		int heightDiff = Math.abs(maxDepth(root.left) - maxDepth(root.right));
		if (heightDiff > 1){
			return false;
		} else {
			return isBalanced(root.left) && isBalanced(root.right);
		}
	}
	
	private static int maxDepth(TreeNode root){
		if (root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}
	
	// method 2, O(n) time, O(h) space. h is tree-height
	public static boolean isBalanced2(TreeNode root){
		if (root == null) return true;
		else return getHeight(root) != -1;
	}
	
	private static int getHeight(TreeNode root){
		if (root == null) return 0;
		int left = getHeight(root.left);
		int right = getHeight(root.right);
		if(left == -1 || right == -1){
			return -1;
		}
		if (Math.abs(left - right) > 1){
			return -1;
		}
		return Math.max(left, right) + 1;
	}
	
	
	// Test
	public static void main(String[] args) {
		// Create balanced tree
		int[] array = {0, 1, 2, 3, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		
		System.out.println("Is balanced? " + isBalanced2(root));
		root.insertInOrder(4); // Add 4 to make it unbalanced
		System.out.println("Is balanced? " + isBalanced2(root));
	}

}
