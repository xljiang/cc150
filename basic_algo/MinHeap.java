package basic_algo;

/**
 * Min Heap
 * 
 * based on CLRS Chapter 6.
 */
public class MinHeap {

	public int[] heap;
	private int size;	// number of elements in the array
	private int heapsize;	// number of valid elements in the heap 
	
	public MinHeap(int[] array){
		size = array.length;
		heap = new int[size + 1];	// heap index start from 1, so comparable to CLRS indexes
		heap[0] = Integer.MIN_VALUE;
		System.arraycopy(array, 0, heap, 1, array.length); // in heap we do not use 0 index
		buildMinHeap();
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
	
	public void minHeapify(int i){
		int l = left(i);
		int r = right(i);
		int smallest = i;
		if ( l <= heapsize && heap[l] < heap[i]){
			smallest = l;
		}
		if ( r <= heapsize && heap[r] < heap[smallest]){
			smallest = r;
		}
		if (smallest != i){
			swap(i, smallest); // swap arr[i] and arr[largest]
			minHeapify(smallest);
		}
	}
	
	/** build a heap in O(n) time */
	public void buildMinHeap(){
		heapsize = size;
		for (int i = size/2; i > 0; i--){
			minHeapify(i);
		}
	}
	
	/** sort from largest to smallest */
	// just for test
	public void heapSort(){
		// buildMinHeap(); already in constructor
		for (int i = size; i >= 2; i--){
			swap(1, i);
			heapsize--;
			minHeapify(1);
		}
	}
	
	/** returns the largest key */
	public int getHeapMin() throws Exception{
		if (heapsize < 1){
			throw new Exception("heap underflow");
		}
		return heap[1];
	}
	
	/** removes and returns the largest key */
	// O(logn)
	public int heapExtractMin() throws Exception{
		if (heapsize < 1){
			throw new Exception("heap underflow");
		}
		int min = heap[1];
		heap[1] = heap[heapsize];
		heapsize--;
		minHeapify(1);
		return min;
	}
	
	/** decrease the value of element i's key to the new value key,
	 *  new key is assumed to be at least as small as i's current key value*/
	// O(logn)
	public void heapDecreaseKey(int i, int key) throws Exception{
		if (key > heap[i]){
			throw new Exception("new key is larger than current key");
		}
		heap[i] = key;
		while (i > 1 && heap[parent(i)] > heap[i]){
			swap(i, parent(i));
			i = parent(i);
		}
	}
	
	/** inserts the element key into the minHeap */
	// O(logn)
	public void insert(int key) throws Exception{
		heapsize++;
		heap[heapsize] = Integer.MAX_VALUE;
		heapDecreaseKey(heapsize, key);
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
