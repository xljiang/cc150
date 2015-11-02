package basic_algo;

/**
 * Counting Sort
 * 
 * Non-comparison sort.
 * Counting sort assumes that the input consists of n integers in a small range (from 0 to k)
 * 
 * average: O(n+r)
 * worst: O(n+r)
 * memory: O(n+r) 
 * stable: Yes
 * notes: if r is O(n), then average is O(n)
 */
public class CountingSort {

	/* Implementation base on CLRS Chapter 8.2
	 * 
	 * A[0..n-1] input array, elements range from 0 to k
	 * B[0..n-1] sorted output
	 * C[0..k] temporary working storage
	 */
	/**
	 * Counting sort - rearranges the array of integer (min-0, max-k) in ascending order
	 * 
	 * @param A the array to be sorted
	 * @param k the maximum number in the array
	 * @return sorted array
	 */
	public static int[] countingSort(int[] A, int k){
		int[] B = new int[A.length];
		int[] C = new int[k+1];
		
		
/*		// initialize C to all zeros 
 		// automatically done in java
		for (int i = 0; i <= k; i++){
			C[i] = 0;
		}*/
		
		// compute frequency counts
		for (int j = 0; j < A.length; j++){
			C[A[j]]++;
		} // C[i] now contains the number of elements equal to i
			// e.g. here C[5]=2 means: in array A, there are 2 elements with value = 5.

		// compute cumulates
		for (int i = 1; i <= k; i++){
			C[i] = C[i] + C[i-1];
		} // C[i] now contains the number of elements less than or equal to i
			// e.g. here C[5] = 8 means: in array A, there are 8 elements with value <= 5.

		// move data
		for (int j = A.length - 1; j >= 0; j--){ // if j = 0 to A.length -1, then the algorithm isn't stable.
			B[C[A[j]] - 1] = A[j]; 
			C[A[j]]--;
		}
		
		return B;  // also can copy B back to A
	}
	
}
