package tree_and_graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import CtCILibrary.AssortedMethods;
import CtCILibrary.TreeNode;

// Given a binary tree, design an algorithm which creates a linked list of all the
// nodes at each depth (if you have a tree with Depth D, you'll have D linked lists)
public class Q4_4 {
	
	// method 1: DFS (similar as problem in basic_algo BinaryTree Q8. printPaths())
	public static ArrayList<LinkedList<TreeNode>> createDepthLinkedList(TreeNode root){
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		createDepthLinkedList(root, 0, list);
		return list;
	}
	
	private static void createDepthLinkedList(TreeNode node, int depth, ArrayList<LinkedList<TreeNode>> list){
		if (node == null) return;
		if (list.size() < depth + 1){
			LinkedList<TreeNode> ll = new LinkedList<TreeNode>();
			ll.add(node);
			list.add(ll);
		} else {
			list.get(depth).add(node);
		}
		depth++;
		createDepthLinkedList(node.left, depth, list);
		createDepthLinkedList(node.right, depth, list);
	}
	

	
	// method2: BFS
	public static ArrayList<LinkedList<TreeNode>> createDepthLinkedList2(TreeNode root){
		ArrayList<LinkedList<TreeNode>> list = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> curr = new LinkedList<TreeNode>();
		if(root != null){
			curr.add(root);
		}
		
		while(curr.size() > 0){
			list.add(curr);
			LinkedList<TreeNode> parents = curr;
			curr = new LinkedList<TreeNode>();
			for(TreeNode parent : parents){
				if (parent.left != null){
					curr.add(parent.left);
				}
				if (parent.right != null){
					curr.add(parent.right);
				}
			}
		}
		return list;
	}

	
	// print out
	public static void printResult(ArrayList<LinkedList<TreeNode>> list){
		for(LinkedList<TreeNode> ll : list){
			Iterator<TreeNode> itr = ll.listIterator();
			while(itr.hasNext()){
				System.out.print(itr.next().data + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[] nodes_flattened = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		TreeNode root = AssortedMethods.createTreeFromArray(nodes_flattened);
		root.print();
		ArrayList<LinkedList<TreeNode>> list = createDepthLinkedList(root);
		printResult(list);
	}
}
