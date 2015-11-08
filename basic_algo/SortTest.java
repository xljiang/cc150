package basic_algo;


import org.junit.Test;

public class SortTest {

	int[] arr = {5,2,4,7,1,3,6};
	
	//---------------O(n^2)------------------
	
	@Test
	public void testBubbleSort1() {
		BubbleSort.bubbleSort1(arr);
		printArr(arr);
	}
	
	@Test
	public void testBubbleSort2() {
		BubbleSort.bubbleSort2(arr);
		printArr(arr);
	}
	
	@Test
	public void testBubbleSort3() {
		BubbleSort.bubbleSort3(arr);
		printArr(arr);
	}
	
	@Test
	public void testBubbleSort4() {
		BubbleSort.bubbleSort4(arr);
		printArr(arr);
	}
	
	@Test
	public void testSelectionSort() {
		SelectionSort.selectionSort(arr);
		printArr(arr);
	}
	
	@Test
	public void testInsertionSort() {
		InsertionSort.insertionSort(arr);
		printArr(arr);
	}
	
	
	//---------------O(nlogn)------------------
	
	@Test
	public void testMergeSort() {
		MergeSort.mergeSort(arr);
		printArr(arr);
	}
	
	@Test
	public void testMergeSort2() {
		MergeSort2.mergeSort(arr);
		printArr(arr);
	}
	
	@Test
	public void testQuickSort() {
		QuickSort.quickSort(arr);
		printArr(arr);
	}
	
	@Test
	public void testHeapSort() {
		int[] array = {16,4,10,14,7,9,3,2,8,1};
		System.out.println("Input array:");
		printArr(array);
		
		System.out.println("Max heap:");
		MaxHeap heap = new MaxHeap(array);
		heap.printHeap();
		
		System.out.println("Sorted array:");
		heap.heapSort();
		heap.printHeap();
		
		// test min heap
		System.out.println("Min Heap:");
		MinHeap minHeap = new MinHeap(array);
		minHeap.printHeap();
		System.out.println("Sorted array (largest -> smallest):");
		minHeap.heapSort();
		minHeap.printHeap();
	}
	
	
	//---------------O(n)------------------

	@Test
	public void testCountingSort() {
		int[] array = {2,5,3,0,2,3,0,3};
		int[] output = CountingSort.countingSort(array, 5);
		printArr(output);
	}
	
	@Test
	public void testRadixSort() {
		int[] array = {329,457,657,839,436,720,355};
		RadixSort.radixSort(array, 3);
		printArr(array);
		
		// different digits
		int[] array2 = {1329,457,657,839,436,720,355};
		RadixSort.radixSort(array2, 4);
		printArr(array2);
	}
	
	@Test
	public void testBucketSort() {
		double[] array = {0.78,0.17,0.39,0.26,0.72,0.94,0.21,0.12,0.23,0.68};
		BucketSort.bucketSort(array);
		printArr(array);
	
	}
	
	
	
	// -------------------helper methods------------------------
	// print array
	private void printArr(int[] arr){
		System.out.print("[");
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + ", ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	private void printArr(double[] arr){
		System.out.print("[");
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + ", ");
		}
		System.out.print("]");
		System.out.println();
	}

}
