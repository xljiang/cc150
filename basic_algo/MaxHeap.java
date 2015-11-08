package basic_algo;

/**
 * Max Heap
 * 
 * based on CLRS Chapter 6.
 */
public class MaxHeap {

	public int[] heap;
	private int size;	// number of elements in the array
	private int heapsize;	// number of valid elements in the heap 
	
	public MaxHeap(int[] array){
		size = array.length;
		heap = new int[size + 1];	// heap index start from 1, so comparable to CLRS indexes
		heap[0] = Integer.MAX_VALUE;
		System.arraycopy(array, 0, heap, 1, array.length); // in heap we do not use 0 index
		buildMaxHeap();
	}

	public int parent(int i){
		return i/2;
	}
	
	public int left(int i){
		return 2 * i;
	}
	
	public int right(int i){
		return 2 *i + 1;
	}
	
	public boolean isLeaf(int i){
		if (i > heapsize/2 && i <= heapsize){
			return true;
		}
		return false;
	}
	
	public void maxHeapify(int i){
		int l = left(i);
		int r = right(i);
		int largest = i;
		if ( l <= heapsize && heap[l] > heap[i]){
			largest = l;
		}
		if ( r <= heapsize && heap[r] > heap[largest]){
			largest = r;
		}
		if (largest != i){
			swap(i, largest); // swap arr[i] and arr[largest]
			maxHeapify(largest);
		}
	}
	
	/** build a heap in O(n) time */
	public void buildMaxHeap(){
		heapsize = size;
		for (int i = size/2; i > 0; i--){
			maxHeapify(i);
		}
	}
	
	/**
	 * Heap Sort
	 * 
	 * best: O(nlogn)
	 * average: O(nlogn)
	 * worst: O(nlogn), space O(1)
	 * stable: No
	 * method: Selection
	 * notes: in place
	 */
	public void heapSort(){
		// buildMaxHeap(); already in constructor
		for (int i = size; i >= 2; i--){
			swap(1, i);
			heapsize--;
			maxHeapify(1);
		}
	}
	
	/** returns the largest key */
	public int getHeapMax() throws Exception{
		if (heapsize < 1){
			throw new Exception("heap underflow");
		}
		return heap[1];
	}
	
	/** removes and returns the largest key */
	// O(logn)
	public int heapExtractMax() throws Exception{
		if (heapsize < 1){
			throw new Exception("heap underflow");
		}
		int max = heap[1];
		heap[1] = heap[heapsize];
		heapsize--;
		maxHeapify(1);
		return max;
	}
	
	/** increase the value of element i's key to the new value key,
	 *  new key is assumed to be at least as large as i's current key value*/
	// O(logn)
	public void heapIncreaseKey(int i, int key) throws Exception{
		if (key < heap[i]){
			throw new Exception("new key is smaller than current key");
		}
		heap[i] = key;
		while (i > 1 && heap[parent(i)] < heap[i]){
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	/** inserts the element key into the maxHeap */
	// O(logn)
	public void insert(int key) throws Exception{
		heapsize++;
		heap[heapsize] = Integer.MIN_VALUE;
		heapIncreaseKey(heapsize, key);
	}
	
	
	
	private void swap(int i, int j){
		int tmp = heap[i];
		heap[i] = heap[j];
		heap[j] = tmp;
	}
	
	public void printHeap(){
		System.out.print("[");
		for (int i = 1; i <= size; i++){
			System.out.print(heap[i] + ", ");
		}
		System.out.print("]");
		System.out.println();
	}
}
