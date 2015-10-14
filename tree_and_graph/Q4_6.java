package tree_and_graph;

import CtCILibrary.TreeNode;

// Write an algorithm to find the'next'node (i.e., in-order successor) of a given node
// in a binary search tree. You may assume that each node has a link to its parent
public class Q4_6 {
	
	// 二叉查找树中序遍历(in-order)后，元素将按递增排序， 某一结点的后继结点即为比该结点大的结点中最小的一个。
	// 如果该结点有右儿子， 则后继结点为右儿子的最左子孙。
	// 否则需要不断地向上查找该结点的祖先，直到找到第一个比它大的结点为止。
	public static TreeNode nextNode(TreeNode node){
		if (node == null) return null;
		if (node.right != null){
			return findMin(node.right);
		} 
		TreeNode parent = node.parent;
		while(parent != null && parent.data < node.data){
			parent = parent.parent;
		}
		return parent;
	}
	
	private static TreeNode findMin(TreeNode node){
		if (node == null) return null;
		while(node.left != null){
			node = node.left;
		}
		return node;
	}

	// Test
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		TreeNode root = TreeNode.createMinimalBST(array);
		for (int i = 0; i < array.length; i++) {
			TreeNode node = root.find(array[i]);
			TreeNode next = nextNode(node);
			if (next != null) {
				System.out.println(node.data + "->" + next.data);
			} else {
				System.out.println(node.data + "->" + null);
			}
		}
	}
}
