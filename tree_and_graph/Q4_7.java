package tree_and_graph;

import CtCILibrary.TreeNode;

// find the first common ancestor of two nodes in a binary tree
// avoid storing additional nodes in a data structure
// Note: not necessarily a BST
public class Q4_7 {
	
	// method 1
	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if (!covers(root, p) || !covers(root, q)){
			return null;
		}
		return commonAncestorHelper(root, p, q);
	}
	
	private static TreeNode commonAncestorHelper(TreeNode root, TreeNode p, TreeNode q){
		if (root == null) return null;
		if (root == p || root == q) return root;
		boolean is_p_onleft = covers(root.left, p);
		boolean is_q_onleft = covers(root.left, q);
		if (is_p_onleft && is_q_onleft){
			return commonAncestorHelper(root.left, p, q);
		} else if (!is_p_onleft && !is_q_onleft){
			return commonAncestorHelper(root.right, p, q);
		} else {
			return root;
		}
	}

	private static boolean covers(TreeNode root, TreeNode p){
		if (root == null) return false;
		if (root == p) return true;
		return covers(root.left, p) || covers(root.right, p);
	}
	

	
	// method 2:
	public static class Result{
		public TreeNode node;
		public boolean isAncestor;
		public Result(TreeNode n, boolean isAnc){
			node = n;
			isAncestor = isAnc;
		}
	}
	
	public static TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q){
		Result r = commonAncestorHelper2(root, p, q);
		if (r.isAncestor){
			return r.node;
		}
		return null;
	}
	
	public static Result commonAncestorHelper2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return new Result(null, false);
		}
		if (root == p && root == q) {
			return new Result(root, true);
		}
		
		Result rLeft = commonAncestorHelper2(root.left, p, q);
		if (rLeft.isAncestor) { // Found common ancestor
			return rLeft;
		}
		
		Result rRight = commonAncestorHelper2(root.right, p, q);
		if (rRight.isAncestor) { // Found common ancestor
			return rRight;
		}
		
		if (rLeft.node != null && rRight.node != null) {
			return new Result(root, true); // This is the common ancestor
		} else if (root == p || root == q) {
			/* If we’re currently at p or q, and we also found one of those
			 * nodes in a subtree, then this is truly an ancestor and the
			 * flag should be true. */
			boolean isAncestor = rLeft.node != null || rRight.node != null;
			return new Result(root, isAncestor);
		} else {
			return new Result(rLeft.node != null ? rLeft.node : rRight.node, false);
		}
	}	
	
	
	// Test
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = TreeNode.createMinimalBST(array);
		TreeNode n1 = root.find(1);
		TreeNode n7 = root.find(7);
		TreeNode ancestor = commonAncestor2(root, n1, n7);
		if (ancestor != null) {
			System.out.println(ancestor.data);
		} else {
			System.out.println("null");
		}	}
}
