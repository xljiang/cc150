package basic_algo;

import java.util.ArrayList;

/**
 * find the longest increasing subsequence (LIS)
 * */
public class LIS {
	
	/** length of LIS */
	public static int findLISlength(int[] arr){
		int maxLength = 1;
		int[] sizes = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			sizes[i] = 1;
			for(int j=0; j<i; ++j) {
	            if(arr[j]<= arr[i] && sizes[j]+1>sizes[i]) {
	                sizes[i] = sizes[j] + 1;
	            }
			}
	        if(sizes[i]>maxLength) maxLength = sizes[i];
		}
		return maxLength;
	}
	
	
	/** print out LIS as a string*/
	public static void printLIS(int[] arr){
		String[] paths = new String[arr.length];  // an accordingly string array to keep track of the path for print out
		int[] sizes = new int[arr.length]; // a size array to keep track of longest LIS ending with current positions
		
		for(int i = 0; i < arr.length; i++){
			sizes[i] = 1;
			paths[i] = arr[i] + "";
		}
		
		int maxLength = 1;
		
		for (int i = 1; i < arr.length; i++){ // start from 2nd position
			for (int j = 0; j < i; j++){ // the inner loop is to check all previous point
				// when append current index to the previous subsequence?
				// need to meet 2 requirements:
				// current > previous ending and size is increasing
				if (arr[i] > arr[j] && sizes[i] < sizes[j] + 1){
					//update sizes[] and path[]
					sizes[i] = sizes[j] + 1;
					paths[i] = paths[j] + arr[i] + "";
				}
			}
			// update maxLength if necessary
			if (maxLength < sizes[i]){
				maxLength = sizes[i];
			}
		}
		
		for (int i = 1; i < arr.length; i++){
			if(sizes[i] == maxLength){
				System.out.println("LIS: " + paths[i]);
			}
		}
	}
	
	
	/** return LIS array*/
	public static ArrayList<Integer> findLIS(int[] arr){
		ArrayList<Integer>[] paths = new ArrayList[arr.length]; // keep track of indexes
		int[] sizes = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			sizes[i] = 1;
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(arr[i]);
			paths[i] = path;
		}
		
		int maxLength = 1;
		
		for (int i = 1; i < arr.length; i++){
			for (int j = 0; j < i; j++){
				if (arr[i] > arr[j] && sizes[i] < sizes[j] + 1){
					sizes[i] = sizes[j] + 1;
					paths[i] = new ArrayList<Integer>();
					paths[i].addAll(paths[j]);
					paths[i].add(arr[i]);
				}
			}
			if (maxLength < sizes[i]){
				maxLength = sizes[i];
			}
		}

		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for (int i = 1; i < arr.length; i++){
			if (sizes[i] == maxLength){
				indexes = paths[i];
			}
		}
		return indexes;
	}
	
	// Test
	public static void main(String[] args) {
		int[] array = {4,5,1,2,3,7,8,6};
		int n = findLISlength(array);
		System.out.println(n);
		
		printLIS(array);
		
		ArrayList<Integer> lis = findLIS(array);
		System.out.print("LIS: ");
		for (int i : lis){
			System.out.print(i);
		}
	}
}
