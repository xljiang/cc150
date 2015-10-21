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
public class MergeSort2 {
	/* CLRS */
	
	public static void mergeSort(int[] arr){
		mergeSort(arr, 0, arr.length - 1);
	}
	
	public static void mergeSort(int[] arr, int left, int rightEnd){
		if (left < rightEnd){
			int center = (left + rightEnd)/2;
			mergeSort(arr, left, center);
			mergeSort(arr, center + 1, rightEnd);
			merge(arr, left, center, rightEnd); // center is leftEnd
		}
	}
	
	public static void merge(int[] arr, int left, int leftEnd, int rightEnd){
		int n1 = leftEnd - left + 1;
		int n2 = rightEnd - leftEnd;
		int[] L = new int[n1+1];
		int[] R = new int[n2+1];
		
		for (int i = 0; i < n1; i++){
			L[i] = arr[left + i];
		}
		for (int j = 0; j < n2; j++){
			R[j] = arr[leftEnd + j + 1];
		}
		
		L[n1] = Integer.MAX_VALUE;
		R[n2] = Integer.MAX_VALUE;
		
		int i = 0;
		int j = 0;
		
		for (int k = left; k <= rightEnd; k++){
			if(L[i] <= R[j]){
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
		}
	}
}
