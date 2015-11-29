package sort_and_search;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * Given an M x N matrix in which each row and each column is sorted in ascending
 * order, write a method to find an element.
 */
public class Q11_6 {
	
	// method 1: binary search on each row. O(mlogn)
	public static HashSet<ArrayList<Integer>> find(int[][] matrix, int value){
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		int row = -1;
		int col = -1;
		for (int r = 0; r < matrix.length; r++){
			int index = binarySearch(matrix[r], value);
			if(index != -1){
				row = r;
				col = index;
				ArrayList<Integer> result = new ArrayList<Integer>();
				result.add(row);
				result.add(col);
				set.add(result);
			}
		}
		
		// add row = -1, col = -1 if didn't find value in the matrix
		if (set.isEmpty()){
			ArrayList<Integer> result = new ArrayList<Integer>();
			result.add(-1);
			result.add(-1);
			set.add(result);
		}
		return set;
	}
	
	public static int binarySearch(int[] arr, int val){
		int start = 0;
		int end = arr.length - 1;
		while(start <= end){
			int mid = (start + end)/2;
			if (arr[mid] == val){
				return mid;
			} else if (arr[mid] > val){
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1; 
	}
	
	// method 2
	public static boolean find2(int[][] matrix, int value){
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix[0].length && col >= 0){
			if (matrix[row][col] == value){
				return true;
			} else if (matrix[row][col] > value){
				col--;
			} else {
				row ++;
			}
		}
		return false;
	}
	
	// Test
	public static void main(String[] args) {
		
		// m*n matrix
		int[][] matrix = {{15,20,40,85},
						  {20,35,80,95},
						  {30,55,95,105},
						  {40,80,100,120}};
		
		HashSet<ArrayList<Integer>> set = find(matrix, 80);
		boolean found = find2(matrix, 80);

		System.out.println(found);
		for (ArrayList<Integer> array : set){
			System.out.println("row: " + array.get(0) + ", cloumn: " + array.get(1));
		}
		
	}
}
