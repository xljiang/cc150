package sort_and_search;

/* You are given two sorted arrays, A and B, where A has a large enough buffer at
the end to hold B. Write a method to merge B into A in sorted order */

public class Q11_1 {
	/**
	 * 
	 * @param a first array
	 * @param b second array
	 * @param lastA	number of "real" elements in a
	 * @param lastB number of "real" elements in b
	 */
	
	// method 1: CLRS mergeSort's merge
	public static void merge(int[] a, int[] b, int lastA, int lastB){
		// initial a and b2
		a[lastA] = Integer.MAX_VALUE;
		int[] b2 = new int[lastB + 1];
		for (int i = 0; i < b.length; i++){
			b2[i] = b[i];
		}
		b2[lastB] = Integer.MAX_VALUE;
		
		// tmp array to hold sorted result
		int[] tmp = new int[lastA + lastB];
		
		int i = 0;
		int j = 0;
		for (int k = 0; k < tmp.length; k++){
			if (a[i] <= b2[j]){
				tmp[k] = a[i];
				i++;
			} else{
				tmp[k] = b2[j];
				j++;
			}
		}
			
		// copy tmp back to a
		for (int k = 0; k < tmp.length; k++){
			a[k] = tmp[k];
		}
	}
	

	
	// method 2: merge from the end of A and B, merge in place
	public static void merge2(int[] a, int[] b, int lastA, int lastB){
		int indexA = lastA - 1;
		int indexB = lastB - 1;
		int index = lastA + lastB - 1;
		
		while(indexA >= 0 && indexB >= 0){
			if (a[indexA] > b[indexB]){
				a[index] = a[indexA];
				index--;
				indexA--;
			} else{
				a[index] = b[indexB];
				index--;
				indexB--;
			}
		}
		
		// copy the rest of B. The rest of A is already in right place
		while(indexB >= 0){
			a[index] = b[indexB];
			index--;
			indexB--;
		}
	}
	
	
	// print
	private static void printArray(int[] arr, int length){
		if (length > arr.length) {
			System.out.println("Wrong length input");
			return;
		}
		
		System.out.print("[");
		for (int i = 0; i < length; i++){
			System.out.print(arr[i] + ", ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	// Test
	public static void main(String[] args) {
		int[] a = {1,4,7,12,45,67,77,0,0,0,0,0,0,0,0};
		int[] b = {2,3,8,10,33};
		printArray(a,7);
		printArray(b,5);
		//merge(a,b,7,5);
		merge2(a,b,7,5);  // test of method 2
		printArray(a, 12);	
	}
}
