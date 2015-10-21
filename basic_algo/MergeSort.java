package basic_algo;

/**
 * Merge Sort
 * 
 * best: O(nlogn) typical
 * average: O(nlogn)
 * worst: O(nlogn), space O(n)
 * stable: Yes
 * method: Merging
 * notes: 
 */
public class MergeSort {
	/* Divide and conquer
	 * 1) Divide the array into two (or more) subarrays
	 * 2) Sort each subarray (Conquer)
	 * 3) Merge them into one (in a smart way!)
	 */
	
	public static void mergeSort(int[] arr){
		int[] tmp = new int[arr.length];
		mergeSort(arr, tmp, 0, arr.length - 1);
	}
	
	public static void mergeSort(int[] arr, int[] tmp, int left, int rightEnd){
		if (left < rightEnd){
			int center = (left + rightEnd)/2;
			mergeSort(arr, tmp, left, center);
			mergeSort(arr, tmp, center + 1, rightEnd);
			merge(arr, tmp, left, center + 1, rightEnd);
		}
	}
	
	public static void merge(int[] arr, int[] tmp, int left, int right, int rightEnd){
		int leftEnd = right - 1;
		int k = left;
		int num = rightEnd - left + 1;
		
		while(left <= leftEnd && right <= rightEnd){
			if (arr[left] < arr[right]){
				tmp[k++] = arr[left++];
			}else {
				tmp[k++] = arr[right++];
			}
		}
		while (left <= leftEnd){ // copy rest of first half
			tmp[k++] = arr[left++];
		}
		while (right <= rightEnd) { // copy rest of right half
			tmp[k++] = arr[right++];
		}
		
		// copy tmp back
		for (int i = 0; i < num; i++, rightEnd--){
			arr[rightEnd] = tmp[rightEnd];
		}

	}
	
}
