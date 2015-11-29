package sort_and_search;

import java.util.ArrayList;

/*A circus is designing a tower routine consisting of people standing atop one
another's shoulders. For practical and aesthetic reasons, each person must be
both shorter and lighter than the person below him or her. Given the heights
and weights of each person in the circus, write a method to compute the largest
possible number of people in such a tower.
EXAMPLE:
Input (ht,wt): (65, 100) (70, 150) (56, 90) (75, 190) (60, 95) (68, 110)
Output:The longest tower is length 6 and includes from top to bottom:
(56, 90) (60,95) (65,100) (68,110) (70,150) (75,190)
*/

// Longest increasing subsequence (LIS) problem
public class Q11_7 {
	
	/** generate and print out the longest tower */
	public static void generateTower(int[][] arr){
		// sort array by weight
		sortByWeight(arr);
		
		// create height array
		int[] heights = new int[arr.length];
		for (int i = 0; i < arr.length; i++){
			heights[i] = arr[i][0];
		}
		
		// find longest increasing sub sequence indexes
		ArrayList<Integer> indexes = findLongestSubSequence(heights);
		
		// print result
		for (int i = 0; i < arr.length; i++){
			if(indexes.contains(i)){
				System.out.println("(" + arr[i][0] + ", " + arr[i][1] + ")");
			}
		}
	}
	
	/** rearrange array by ascending weight, insertion sort */
	public static void sortByWeight(int[][] arr){
		for (int i = 1; i < arr.length; i++){
			int currWeight = arr[i][1];
			int currHeight = arr[i][0];
			int j = i;
			while (j > 0 && arr[j-1][1] > currWeight){
				arr[j][1] = arr[j-1][1];
				arr[j][0] = arr[j-1][0];
				j--;
			}
			arr[j][1] = currWeight;
			arr[j][0] = currHeight;
		}
	}
	
	
	/**
	 * find longest increasing subsequence's indexes in the array
	 * @param arr (height array)
	 * @return indexes of longest increasing subsequence 
	 */
	public static ArrayList<Integer> findLongestSubSequence(int[] arr){
		ArrayList<Integer>[] paths = new ArrayList[arr.length]; // keep track of indexes
		int[] sizes = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			sizes[i] = 1;
			ArrayList<Integer> path = new ArrayList<Integer>();
			path.add(i);
			paths[i] = path;
		}
		
		int maxLength = 1;
		
		for (int i = 1; i < arr.length; i++){
			for (int j = 0; j < i; j++){
				if (arr[i] > arr[j] && sizes[i] < sizes[j] + 1){
					sizes[i] = sizes[j] + 1;
					paths[i] = new ArrayList<Integer>();
					paths[i].addAll(paths[j]);
					paths[i].add(i);
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
		int[][] array = {{65,60},
						 {70,150},
						 {56,90},
						 {75,190},
						 {60,95},
						 {68,110},
						 {35,65},
						 {40,60},
						 {45,63}};
		generateTower(array);
/*		
 		Output:
		(40, 60)
		(45, 63)
		(56, 90)
		(60, 95)
		(68, 110)
		(70, 150)
		(75, 190)*/
	}
}
