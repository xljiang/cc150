package sort_and_search;

/*
 * Given a sorted array of strings which is interspersed with empty strings, write a
 * method to find the location of a given string.
 * EXAMPLE
 * Input: find "ball" in {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""}
 * Output: 4
 */


public class Q11_5 {

	public static int find(String[] arr, String str){
		if(arr == null || str == null || str.equals("")){
			return -1;
		}
		return find(arr, str, 0, arr.length);
	}
	
	public static int find(String[] arr, String str, int start, int end){
		if (start > end) return -1;
		int mid = (start + end)/2;
		if (arr[mid].equals("")){
			int left = mid - 1;
			int right = mid + 1;
			while(true){
				if (left < start && right > end){
					return -1;
				} else if (right <= end && !arr[right].isEmpty()){
					mid = right;
					break;
				} else if (left >= start && !arr[left].isEmpty()){
					mid = left;
					break;
				}
				left--;
				right++;
			}
		}
		if (arr[mid].compareTo(str) > 0){
			return find(arr, str, start, mid - 1);
		} else if (arr[mid].compareTo(str) < 0){
			return find(arr, str, mid + 1, end);
		} else return mid;
	}
	
	// Test
	public static void main(String[] args) {
		String[] array = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		int index = find(array, "ball");
		System.out.println(index);
	}
}
