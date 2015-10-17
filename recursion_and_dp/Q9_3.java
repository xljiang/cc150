package recursion_and_dp;


// A magic index in an array A[0.. .n-1] is defined to be an index such that A[i] = i.
// Given a sorted array of distinct integers, write a method to find a magic index, 
// if one exists, in array A.
// FOLLOW UP
// What if the values are not distinct?

public class Q9_3 {
	
	// method 1: brute force O(N)
	public static int findIndex(int[] arr){
		for ( int i = 0; i < arr.length; i++){
			if (arr[i] == i){
				return i;
			}
		}
		return -1;
	}
	
	// method 2: binary search (divide and conquer) O(logN)
	public static int findIndexBS(int[] arr){
		return findIndexBSHelper(arr, 0, arr.length - 1);
	}
	
	public static int findIndexBSHelper(int[] arr, int start, int end){
		if ( start > end) return -1;
		int mid = (start + end) / 2;
		if (arr[mid] == mid) return mid;
		if (arr[mid] < mid){
			// search right
			return findIndexBSHelper(arr, mid+1, end);
		} else {
			// search left
			return findIndexBSHelper(arr, start, mid-1);
		}
	}
	
	// non-distinct value
	public static int findIndexNonDistinct(int[] arr){
		return findIndexNonDistinctHelper(arr, 0, arr.length - 1);
	}
	
	public static int findIndexNonDistinctHelper(int[] arr, int start, int end){
		if ( start > end) return -1;
		int mid = (start + end) / 2;
		if (arr[mid] == mid) return mid;
		if (arr[mid] < mid){
			// search left first
			int index = findIndexNonDistinctHelper(arr, start, arr[mid]); // search left side, use arr[mid] instead of mid to save some time
			if (index != -1){
				return index;
			} else{
				// search right
				return findIndexNonDistinctHelper(arr, mid+1, end);
			}
		} else {
			// search left
			return findIndexNonDistinctHelper(arr, start, mid-1);
		}
	}
	
	// Test
	public static void main(String[] args) {
		int[] arr = {-40,-20,-1,1,2,3,5,7,9,12,13};
		System.out.println(findIndex(arr));
		System.out.println(findIndexBS(arr));

		int[] arr2 = {-10,-5,2,2,2,3,5,7,9,12,13};
		System.out.println(findIndexNonDistinct(arr2));

	}
}
