package basic_algo;

/**
 * Bubble Sort
 * 
 * best: (n)
 * average: (n2)
 * worst: (n2), space (1)
 * stable: Yes
 * method: Exchanging
 * notes: tiny code size
 */
public class BubbleSort {

	/* i = 0 --> compare arr[0] with arr[1-end], if arr[0] > arr[others], swap
	 * i = 1 --> compare arr[1] with arr[2-end], if arr[1] > arr[others], swap
	 * .... till i --> end */
	public static void bubbleSort1(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	/* compare each item in the list with the item next to it, and swapping them
	 * if required */
	public static void bubbleSort2(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

	/* Conventional bubble sort
	 * optimization of bubbleSort2:
	 * 1) boolean isSorted to help break early
	 * 2) after each loop, you'll have the largest element at the end, so no
	 * need to compare them can skip it */
	public static void bubbleSort3(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			boolean swapped = false; // add boolean value to break loop early
			for (int j = 1; j < arr.length - i; j++) { // skip the already sorted largest elements
				if (arr[j - 1] > arr[j]) {
					int temp = arr[j - 1];
					arr[j - 1] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
			if (!swapped)
				return;
		}
	}

	/* optimization 2 (~ worse case 50% improvement)
	 * after every pass, all elements after the last swap are sorted, and do not need to be checked again.
	 * So, use a variable "size" for the inner loop and change it to the latest swapped element in each cycle.
	 * This way your inner loop goes up to the latest "swapped" element and passes the rest 
	 * that are un-swapped (aka in their correct place).
	 */
	public static void bubbleSort4(int arr[]) {
		int size = arr.length;
		do {
			int newsize = 0;
			for (int i = 1; i < size; i++) {
				if (arr[i - 1] > arr[i]) {
					int temp = arr[i - 1];
					arr[i - 1] = arr[i];
					arr[i] = temp;
					newsize = i;
				}
			}
			size = newsize;
		} while (size > 0);
	}

}
