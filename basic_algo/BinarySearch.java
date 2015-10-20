package basic_algo;

/**
 * Binary Search
 * 
 * Search a sorted array A. if A is sorted, we can check the midpoint of the sequence agianst value 
 * and eliminate half of the sequence from further considerations.
 * 
 * worst: O(logn)
 */
public class BinarySearch {

	/**
	 * @return index of the array, where arr[index] = val
	 */
	public static int binarySearch(int[] arr, int val){
		int low = 0;
		int high = arr.length - 1;
		int mid;
		while(low <= high){
			mid = (low + high)/ 2;
			if (arr[mid] < val){
				high = mid - 1;
			} else if (arr[mid] > val){
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1; // didn't find val in array 
	}
	
	// method 2: recursive
	public static int binarySearchRec(int[] arr, int val){
		return binarySearchRec(arr, val, 0, arr.length);
	}
	
	private static int binarySearchRec(int[] arr, int val, int low, int high){
		if (low > high) return -1;
		int mid = (low + high) / 2;
		if (arr[mid] < val){
			return binarySearchRec(arr, val, mid + 1, high);
		} else if (arr[mid] > val){
			return binarySearchRec(arr, val, low, mid - 1);
		} else{
			return mid;
		}
	}
	
	// Test
	public static void main(String[] args) {
		int[] arr = {0,2,5,6,8,20};
		int a = binarySearch(arr, 5);
		int b = binarySearchRec(arr, 5);
		System.out.println(a + ", " + b);
	}
}
