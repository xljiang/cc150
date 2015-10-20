package basic_algo;

/**
 * Insertion Sort
 * 
 * best: O(n), for nearly sorted data
 * average: O(n^2) 
 * worst: O(n^2), space O(1) 
 * stable: Yes 
 * method: Insertion
 * notes: efficient on small lists and mostly sorted lists
 * notes: the advantage of insertion sort comparing to bubble sort and selection sort: 
 * 		  insertion sort runs in linear time on nearly sorted data
 */
public class InsertionSort {
	
	/*
	 * remove elements of array one at a time and then insert each of them into a sorted part (initially empty)
	 */
	public static void insertionSort(int[] arr){
		for (int i = 1; i < arr.length; i++){
			int curr = arr[i];
			int j = i;
			while (j > 0 && arr[j-1] > curr){
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = curr;
		}
	}
}
