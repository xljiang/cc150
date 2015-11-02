package basic_algo;

/**
 * Radix Sort
 * 
 * Non-comparison sort.
 * LSD Radix Sort: least significant digit radix sort.
 * 
 * average: O(n*k/d) (n: number of keys, k/d: average key length)
 * worst: O(n*k/d)
 * memory: O(n+2^d) 
 * stable: Yes
 */
public class RadixSort {
	
	/**
	 * Radix Sort - rearranges the array of d-digits integer in ascending order
	 * 
	 * @param arr the array to be sorted
	 * @param d the number of digits of an integer (e.g. for integer 793749, d = 6)
	 */
	public static void radixSort(int[] arr, int d){
		for (int i = 1; i <=d; i++){
			// use counting sort to sort array arr on digit i
			
			int[] B = new int[arr.length];
			int[] C = new int[10]; // 0 to 9
			
			// compute frequency counts
			for (int j = 0; j < arr.length; j++){
				int digit = digit(arr[j], i); // the ith digit of number arr[j]
				C[digit]++;
			}
			
			// compute cumulates
			for (int r = 1; r < C.length; r++){
				C[r] = C[r] + C[r-1];
			}
			
			// move data
			for (int j = arr.length - 1; j >= 0; j--){
				int digit = digit(arr[j], i);
				B[C[digit] - 1] = arr[j];
				C[digit]--;
			}
			
			// copy back
			for (int j = 0; j < arr.length; j++){
				arr[j] = B[j];
			}
		}
	}
	
	/**
	 * 
	 * @param number a input integer
	 * @param i the ith digit
	 * @return the ith digit of the number
	 */
	private static int digit(int number, int i){
		String str = String.valueOf(number);
		if (i > str.length()) return 0;
		
		char ch = str.charAt(str.length() - i);
		return Character.getNumericValue(ch);
	}

}
