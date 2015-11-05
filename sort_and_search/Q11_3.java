package sort_and_search;

/* Given a sorted array of n integers that has been rotated an unknown number of
 * times, write code to find an element in the array. You may assume that the array
 * was originally sorted in increasing order.
 * EXAMPLE
 * Input: find 5 in {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
 * Output: 8 (the index of 5 in the array)
*/
public class Q11_3 {

	public static int find(int[] arr, int value) {
		return find(arr, value, 0, arr.length - 1);
	}

	public static int find(int[] arr, int value, int start, int end) {
		if (start > end)
			return -1;
		int mid = (start + end) / 2;
		if (arr[mid] == value) {
			return mid;
		} else if (arr[mid] > value) {
			if (arr[start] > value) {
				return find(arr, value, mid + 1, end);
			} else {
				return find(arr, value, start, mid - 1);
			}
		} else {
			if (arr[end] > value) {
				return find(arr, value, mid + 1, end);
			} else {
				return find(arr, value, start, mid - 1);
			}
		}
	}

	// Test
	public static void main(String[] args) {
		int[] array = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };
		int index = find(array, 5);
		System.out.println(index);
	}
}
