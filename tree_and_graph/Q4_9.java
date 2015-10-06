package tree_and_graph;

import CtCILibrary.TreeNode;

// You are given a binary tree in which each node contains a value. 
// Design an algorithm to print all paths which sum to a given value. 
// The path does not need to start or end at the root or a leaf.

public class Q4_9 {
	
	// O(NlogN) time, O(logN) space
	public static void findSum(TreeNode root, int sum){
		int[] path = new int[maxDepth(root)];
		findSum(root, path, 0, sum);
	}
	
	private static void findSum(TreeNode node, int[] path, int level, int sum){
		if (node == null) return;
		path[level] = node.data;
		int t = 0;
		for (int i = level; i >= 0 ; i--){
			t += path[i];
			if (t == sum){
				print(path, i, level);
			}
		}
		findSum(node.left, path, level + 1, sum);
		findSum(node.right, path, level + 1, sum);
		
	}
	
	private static void print(int[] path, int start, int end){
		for (int i = start; i <= end; i++){
			System.out.print(path[i]+ " ");
		}
		System.out.println();
	}
	
	private static int maxDepth(TreeNode root){
		if (root == null) return 0;
		int lMaxDepth = maxDepth(root.left);
		int rMaxDepth = maxDepth(root.right);
		return Math.max(lMaxDepth, rMaxDepth) + 1;
	}
	
	
	public static void main(String [] args){
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(1);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(6);
		findSum(root, 8);
	}
	

}
