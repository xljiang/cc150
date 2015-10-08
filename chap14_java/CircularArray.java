package chap14_java;

import java.util.Iterator;

// Q14_6
// Implement a CircularArray class that supports an array-like data structure
// which can be efficiently rotated.The class should use a generic type, and should
// support iteration via the standard for (Obj o : CircularArray) notation
public class CircularArray<T> implements Iterable<T>{
	
//	private int size;
	private int head = 0;
	private T[] array;

	public CircularArray(int size) {
		array = (T[]) new Object[size];
	}
	
	private int realIndex(int index){
		int realIndex = (head + index) % array.length;
		while(realIndex < 0){
			realIndex += array.length;
		}
		return realIndex;
	}
	
	public void set(int index, T t){
		array[realIndex(index)] = t;
	}
	
	public T get(int index){
		
		return array[realIndex(index)];
	}
	
	public void rotate(int r){
		head = head + r;
	}

	@Override
	public Iterator<T> iterator() {
		return (new CircularArrayIterator());
	}
	
	private class CircularArrayIterator implements Iterator<T>{
		private int index = 0;
		
		public boolean hasNext(){
			return (index < array.length);
		}
		
		public T next(){
			T result = array[realIndex(index)];
			index++;
			return result;
		}

		public void remove() {
			throw new UnsupportedOperationException("Remove function is not supported!");
			
		}
	}
}
