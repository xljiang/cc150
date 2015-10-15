package basic_algo;

// follow: http://cslibrary.stanford.edu/110/BinaryTrees.html
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
	public BinaryTree(){
		root = null;
	}
	
	/*********************************************************
	 * lookup() -- BST only
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
	 * insert() -- not for BST!
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
	  1. build123() -- BST only
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
	  2. size() 
	 *********************/
	
	public int size(){
		return size(root);
	}
	
	// helper, recur down
	private int size(Node node){
		if (node == null){
			return 0;
		} else{
			return (1 + size(node.left) + size(node.right));
		}
	}
	
	
	/************************
	  3. maxDepth() 
	 ************************/
	
	public int maxDepth(){
		return maxDepth(root);
	}
	
	// helper, recur down
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
	  4. minValue() -- BST only
	 *************************/
	
	public int minValue(){
		int min = root.data;
		Node current = root;
		while(current.left != null){
			min = current.left.data;
			current = current.left;
		}
		return min;
	}

	
	
	/**************************
	  5. printTree() 
	 -- in order tree traversal
	 **************************/
	/* for tree: 
	          4 
    		 / \ 
            2   5 
           / \ 
          1   3
	 output is: "1 2 3 4 5".
	 */
	
	// For each node, the strategy is: recur left, print the node data, recur right.
	public void printTree(){
		printTree(root);
		System.out.println();
	}
	
	private void printTree(Node node){
		if (node == null) return;
		printTree(node.left);
		System.out.print(node.data + " ");
		printTree(node.right);
	}
	
	
	/*******************************
	  6. printPostorder() 
	 -- post order tree traversal
	 *******************************/
	/* for tree: left->right->node
	          4 		
  		 	 / \ 			
            2   5 		
           / \ 			
          1   3			
	 output is: "1 3 2 5 4".
	 */
	
	public void printPostorder(){
		printPostorder(root);
		System.out.println();
	}
	
	private void printPostorder(Node node){
		if (node == null) return;
		printPostorder(node.left);
		printPostorder(node.right);
		System.out.print(node.data + " ");
	}


	/*******************************
	  7. hasPathSum() 
	 *******************************/
	
	/*	We'll define a "root-to-leaf path" to be a sequence of nodes in a tree starting with the root node 
	 * and proceeding downward to a leaf. We'll say that an empty tree contains no root-to-leaf paths. 
	 * So for example, the following tree has exactly four root-to-leaf paths:
	        5 
	       / \ 
	      4   8 
	     /   / \ 
	    11  13  4 
	   /  \      \ 
	  7    2      1
	
	Root-to-leaf paths: 
	path 1: 5 4 11 7 
	path 2: 5 4 11 2 
	path 3: 5 8 13 
	path 4: 5 8 4 1
	for example, the sum of the values on the 5-4-11-7 path is 5 + 4 + 11 + 7 = 27.
	
	Given a binary tree and a sum, return true if the tree has a root-to-leaf path such that 
	adding up all the values along the path equals the given sum. 
	Return false if no such path can be found. 
	*/
	
	public boolean hasPathSum(int sum){
		return hasPathSum(root, sum);
	}
	
	private boolean hasPathSum(Node node, int sum){
		if (node == null) return false;
		if (node.left == null && node.right == null)
			return root.data == sum;
		else {
			return (hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data));
		}
	}
	
	
	/*******************************
	  8. printPaths() 
	 *******************************/
	/* Given a binary tree, print out all of its root-to-leaf paths, one per line. */
	
	// Hint: In C, C++, and Java, probably the best solution is to create a recursive helper function 
	// printPathsRecur(node, int path[], int pathLen), where the path array communicates the sequence of 
	// nodes that led up to the current call. 
	
	// DFS
	public void printPaths(){
		int[] path = new int[maxDepth()];
		printPathsRecur(root, path, 0);
	}
	
	// recursive helper
	private void printPathsRecur(Node node, int[] path, int pathLen){
		if (node == null){
			return;
		}
		path[pathLen] = node.data;
		pathLen++;
		if(node.left == null && node.right == null){
			printArray(path, pathLen);
		} else{
			printPathsRecur(node.left, path, pathLen);
			printPathsRecur(node.right, path, pathLen);
		}
	}
	
	// utility
	private void printArray(int[] path, int pathLen){
		for(int i = 0; i < pathLen; i++){
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
	
	
	
	/*******************************
	  9. mirror() 
	 *******************************/
	/*Change a tree so that the roles of the left and right pointers are swapped at every node.
	 So the tree... 
	       4 
	      / \ 
	     2   5 
	    / \ 
	   1   3

	 is changed to... 
	       4 
	      / \ 
	     5   2 
	        / \ 
	       3   1
	*/
	
	public void mirror(){
		mirror(root);
	}
	
	private void mirror(Node node){
		if (node == null) return;
		mirror(node.left);
		mirror(node.right);
		// swap
		Node temp = node.left;
		node.left = node.right;
		node.right = temp;
	}
	
	
	/*******************************
	  10. doubleTree() -- BST only
	 *******************************/
	
	/* For each node in a binary search tree, create a new duplicate node, 
	 * and insert the duplicate as the left child of the original node. 
	 * The resulting tree should still be a binary search tree.
	 So the tree... 
	    2 
	   / \ 
	  1   3

	 is changed to... 
	       2 
	      / \ 
	     2   3 
	    /   / 
	   1   3 
	  / 
	 1
	 */
	
	public void doubleTree(){
		doubleTree(root);
	}
	
	private void doubleTree(Node node){
		if (node == null) return;
		doubleTree(node.left);
		doubleTree(node.right);

		Node inst = new Node(node.data);
		inst.left = node.left;
		node.left = inst;
	}
	
	
	/*******************************
	  11. sameTree() -- BST only
	 *******************************/
	public boolean sameTree(BinaryTree other){
		return sameTree(root, other.root);
	}
	
	private boolean sameTree(Node node1, Node node2){
		if(node1 == null && node2 == null) {
			return true;
		} else if(node1 != null && node2 != null){
			return node1.data != node2.data 
					&& sameTree(node1.left, node2.left) 
					&& sameTree(node1.right, node2.right);
		} else { // only one node is empty
			return false;
		}
	}
	
	
	
	/*******************************
	  12. countTrees() -- BST only
	 *******************************/

	/* Suppose you are building an N node binary search tree with the values 1..N. 
	 * How many structurally different binary search trees are there that store those values? 
	 * Write a recursive function that, given the number of distinct values, computes the number 
	 * of structurally unique binary search trees that store those values. 
	 * For example, countTrees(4) should return 14, since there are 14  structurally unique 
	 * binary search trees that store 1, 2, 3, and 4. 
	 * The base case is easy, and the recursion is short but dense. 
	 * Your code should not construct any actual trees; it's just a counting problem.
	 */
	
	//  Strategy: consider that each value could be the root. 
	//  Recursively find the size of the left and right subtrees. 
	public static int countTrees(int numKeys){
		if(numKeys <= 1){
			return 1;
		} else {
			int sum = 0;
			int left, right, root;
			for(root = 1; root <= numKeys; root++){
				left = countTrees(root - 1);
				right = countTrees(numKeys - root);
				sum += left * right;
			}
			return sum;
		}
	}
	
	
	
	/*******************************
	  13. isBST() v1 -- BST only
	 *******************************/
	
	// not efficient
	public boolean isBST(){
		return isBST(root);
	}

	private boolean isBST(Node node){
		if (node == null) return true;
		if(node.left != null && maxValue(node.left) > node.data) return false;
		if(node.right != null && minValue(node.right) <= node.data) return false;
		return isBST(node.left) && isBST(node.right);
	}
	
	private int minValue(Node node){
		int min = node.data;
		Node current = node;
		while(current.left != null){
			min = current.left.data;
			current = current.left;
		}
		return min;
	}
	
	private int maxValue(Node node){
		int max = node.data;
		Node current = node;
		while(current.right != null){
			max = current.right.data;
			current = current.right;
		}
		return max;
	}
	
	
	/*******************************
	  14. isBST() v2 -- BST only
	 *******************************/

	public boolean isBST2(){
		return isBSTRecur(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	// returns true if the given tree is a BST and its value >= max and <= min
	private boolean isBSTRecur(Node node, int min, int max){
		if (node == null) return true;
		if (node.data <= min || node.data > max) {
			return false;
		} else {
			return isBSTRecur(node.left, min, node.data) && isBSTRecur(node.right, node.data, max);
		}
	}
	
	
	
}
