package basic_algo;

// reference: Data Structures and Algorithm in Java by Goodrich et.al. 6th ed
public class SinglyLinkedList<E> {

	private static class Node<E>{
		private E element;
		private Node<E> next;
		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}
		public E getElement(){
			return element; 
		}
		public Node<E> getNext(){
			return next;
		}
		public void setNext(Node<E> n){
			next = n;
		}
	}
	
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	public SinglyLinkedList(){
	
	}

	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	// returns the first element
	public E first(){
		if(isEmpty()){
			return null;
		}
		return head.getElement();
	}
	
	// returns the last element
	public E last(){
		if(isEmpty()){
			return null;
		}
		return tail.getElement();
	}
	
	public void addFirst(E e){
		head = new Node<>(e, head);
		if(size == 0){
			tail = head;
		}
		size++;
	}
	
	public void addLast(E e){
		Node<E> newest = new Node<>(e, null);
		if(isEmpty()){
			head = newest;
		} else{
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	
	// removes and returns the first element
	public E removeFirst(){
		if(isEmpty())
			return null;
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if(size == 0)
			tail = null;
		return answer;
	}
	

}
		
		



