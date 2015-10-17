package basic_algo;

/**
 * Selection Sort
 * 
 * best: O(n^2) 
 * average: O(n^2) 
 * worst: O(n^2), space O(1) 
 * stable: No 
 * method: Selection
 * notes: stable with O(n) extra space, e.g. using Lists
 */
public class SelectionSort {

	/*
	 * The algorithm works by selecting the smallest unsorted item and then
	 * swapping it with the item in the next position to be filled. 
	 * 
	 * The selection sort works as follows: you look through the entire array for
	 * the smallest element, once you find it you swap it (the smallest element)
	 * with the first element of the array. Then you look for the smallest
	 * element in the remaining array (an array without the first element) and
	 * swap it with the second element. Then you look for the smallest element
	 * in the remaining array (an array without first and second elements) and
	 * swap it with the third element, and so on.
	 */
	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[min] > arr[j]) {
					min = j;
				}
			}
			if (min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}
}
