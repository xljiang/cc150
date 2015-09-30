package tree_and_graph;

// follow http://cslibrary.stanford.edu/110/BinaryTrees.html#java
public class BinaryTree {

	// Root node pointer. will be null for an empty tree.
	private Node root;
	
	/*
	--Node--
	The binary tree is built using this nested node class. Each node stores one data element,
	and has left and right sub-tree pointer which may be null. The node is a "dumb" nested class
	-- we just use it for storage; it does not have any methods.
	*/
	private static class Node{
		Node left;
		Node right;
		int data;
		
		Node(int newData){
			left = null;
			right = null;
			data = newData;
		}
	}
	
	
	/******************************************************
	 * Constructor.
	 * Create an empty binary tree -- a null root pointer.
	 ******************************************************/
	public void BinaryTree(){
		root = null;
	}
	
	/*********************************************************
	 * lookup() -- for BST
	 * Returns true if the given target is in the binary tree.
	 * Use a recursive helper.
	 *********************************************************/
	public boolean lookup(int data){
		return(lookup(root, data));
	}
	
	/*
	 Recursive lookup -- given a node, recur down searching for the given data.
	 */
	private boolean lookup(Node node, int data){
		if (node == null){
			return false;
		} 
		
		if (data == node.data){
			return true;
		} else if(data < node.data){
			return (lookup(node.left, data));
		} else {
			return (lookup(node.right, data));
		}
	}
	
	/**********************************************
	 * insert() -- for BST
	 * Inserts the given data into the binary tree.
	 * Use a recursive helper.
	 **********************************************/
	public void insert(int data){
		root = insert(root, data);
	}
	
	/*
	 Recursive insert -- given a node pointer, recur down and insert the given data into the tree.
	 Returns the new node pointer (the standard way to communicate a changed pointer back to the caller).
	 */
	private Node insert(Node node, int data){
		if(node == null){
			node = new Node(data);
		} else {
			if (data <= node.data){
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return node; // in any case, return the new pointer to the caller
	}
	
	/*************************
	  1. build123() -- for BST
	 *************************/
	
	// use 3 pointer
	public void build123a(){
		root = new Node(2);
		Node lChild = new Node(1);
		Node rChild = new Node(3);
		root.left = lChild;
		root.right = rChild;
	}
	
	// use 1 pointer
	public void build123b(){
		root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
	}
	
	// call insert 3 times
	public void build123c(){
		insert(2);
		insert(1);
		insert(3);
	}
	
	
	/*********************
	  2. size() -- for BT
	 *********************/
	
	// helper
	public int size(){
		return size(root);
	}
	
	// recur down
	private int size(Node node){
		if (node == null){
			return 0;
		} else{
			return (1 + size(node.left) + size(node.right));
		}
	}
	
	
	/************************
	  3. maxDepth() -- for BT
	 ************************/
	
	// helper
	public int maxDepth(){
		return maxDepth(root);
	}
	
	// recur down
	private int maxDepth(Node node){
		if (node == null){
			return 0;
		} else {
			int lDepth = maxDepth(node.left);
			int rDepth = maxDepth(node.right);
			return (Math.max(lDepth, rDepth) + 1);
		}
	}
	
	
	/*************************
	  4. minValue() -- for BST
	 *************************/
	
	
	
	public void print123(){
		System.out.println(root.data + " " + root.left.data + " " + root.right.data);
	}
	
}
