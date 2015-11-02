package basic_algo;

/**
 * Quick Sort
 * 
 * best: O(nlogn)
 * average: O(nlogn)
 * worst: O(n^2)
 * space: average - O(logn), worst - O(n)
 * stable: typical in-place sort is not stable (stable versions exist)
 * method: Partitioning
 */
public class QuickSort {
	/* Implementation based on CLRS
	 * 1) Divide: Partition array A[p..r] into A[p..q-1] (all <= A[q])and A[q+1, r] (all >= A[q])
	 * 2) Conquer: sort two sub-arrays by recursively call quickSort
	 * 3) Combine: already sorted!
	 */
	
	public static void quickSort(int[] arr){
		quickSort(arr, 0, arr.length - 1);
	}
	
	private static void quickSort(int[] arr, int p, int r){
		if (p < r){
			int q = partition(arr, p, r);
			quickSort(arr, p, q - 1);
			quickSort(arr, q + 1, r);
		}
	}
	
	// use arr[r] as pivot
	private static int partition(int[] arr, int p, int r){
		int pivot = arr[r];
		int i = p - 1;
		for ( int j = p; j < r; j++){
			if (arr[j] <= pivot){
				swap(arr, ++i, j);
			}
		}
		swap(arr, i + 1, r);
		return i + 1;
	}
	
	private static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

}
