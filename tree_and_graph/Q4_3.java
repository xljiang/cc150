package tree_and_graph;

import CtCILibrary.TreeNode;

public class Q4_3 {

	// Given a sorted (increasing order) array with unique integer,
	// create a BST with minimal height

	
	// my method 1 -- copy array
	public static TreeNode generateMinimalBST(int[] arr) {
		if (arr.length <= 0)
			return null;
		else {
			int mid = arr.length%2 == 0 ? arr.length/2 - 1 : arr.length/2;
			TreeNode root = new TreeNode(arr[mid]);
			if (mid >= 1) {
				int[] arr_left = copyArray(arr, 0, mid - 1);
				TreeNode left = generateMinimalBST(arr_left);
				root.setLeftChild(left);
			}
			if (arr.length - 1 >= mid + 1) {
				int[] arr_right = copyArray(arr, mid + 1, arr.length - 1);
				TreeNode right = generateMinimalBST(arr_right);
				root.setRightChild(right);
			}
			return root;
		}
	}

	private static int[] copyArray(int[] arr, int start, int end) {
		int[] newArr = new int[end - start + 1];
		for (int i = 0; i < newArr.length; i++) {
			newArr[i] = arr[start + i];
		}
		return newArr;
	}

	
	// my method 2: don't copy array, much much more elegant!
	public static TreeNode generateMinimalBST2(int[] arr){
		return generateMinimalBST2(arr, 0, arr.length - 1);
	}
	
	private static TreeNode generateMinimalBST2(int[] arr, int start, int end) {
		if (end < start)
			return null;
		else {			
			int mid = (start + end) / 2;
			TreeNode root = new TreeNode(arr[mid]);
			root.setLeftChild(generateMinimalBST2(arr, start, mid - 1));
			root.setRightChild(generateMinimalBST2(arr, mid + 1, end));
			return root;
		}
	}
	
	// test
	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

		TreeNode root = Q4_3.generateMinimalBST2(array);
		System.out.println("Root? " + root.data);
		System.out.println("Created BST? " + root.isBST());
		System.out.println("Height: " + root.height());
		root.print();
	}

}
