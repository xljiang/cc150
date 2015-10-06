package tree_and_graph;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

// if binary tree T2 is a subtree of T1
public class Q4_8 {

	public static boolean isSubtree(TreeNode root1, TreeNode root2){
		if (root2 == null) return true;
		TreeNode subRoot = subRootOf2in1(root1, root2);
		if (subRoot != null ){
			return isSameTree(subRoot, root2);
		} else
			return false;
	}
	
	// check if tree1 has a node.data equal to root2.data, return this node (subRoot)
	private static TreeNode subRootOf2in1(TreeNode root1, TreeNode root2){
		if (root1 == null) return null;
		if (root1.data == root2.data) return root1;
		else {
			TreeNode subRoot = subRootOf2in1(root1.left, root2);
			if (subRoot == null){
				subRoot = subRootOf2in1(root1.right, root2);
			}
			return subRoot;
		}
	}
	
	// check if two tree is the same tree
	private static boolean isSameTree(TreeNode node1, TreeNode node2){
		if (node1 == null && node2 == null) return true;
		else if(node1 != null && node2 != null){
			return node1.data == node2.data
				&& isSameTree(node1.left, node2.left)
				&& isSameTree(node1.right, node2.right);
		} else return false;
	}
	
	
	// Test
	public static void main(String[] args) {
		// t2 is a subtree of t1
		int[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
		int[] array2 = {2, 4, 5, 8, 9, 10, 11};
		
		TreeNode t1 = AssortedMethods.createTreeFromArray(array1);
		TreeNode t2 = AssortedMethods.createTreeFromArray(array2);

		if (isSubtree(t1, t2))
			System.out.println("t2 is a subtree of t1"); // should print this line
		else
			System.out.println("t2 is not a subtree of t1");

		// t4 is not a subtree of t3
		int[] array3 = {1, 2, 3};
		TreeNode t3 = AssortedMethods.createTreeFromArray(array1);
		TreeNode t4 = AssortedMethods.createTreeFromArray(array3);

		if (isSubtree(t3, t4))
			System.out.println("t4 is a subtree of t3");
		else
			System.out.println("t4 is not a subtree of t3");  // should print this line
		
		// test empty tree2, t5
		TreeNode t5empty = null;
		if (isSubtree(t3, t5empty))
			System.out.println("t5 is a subtree of t3"); // should print this line
		else
			System.out.println("t5 is not a subtree of t3");  
		
		// test empty tree1, t6
		TreeNode t6empty = null;
		if (isSubtree(t6empty, t1))
			System.out.println("t1 is a subtree of t6"); 
		else
			System.out.println("t1 is not a subtree of t6");  // should print this line
		
	}
}
