package basic_algo;

//reference: Data Structures and Algorithm in Java by Goodrich et.al. 6th ed

public class CircularlyLinkedList<E> {
	
	private static class Node<E>{
		private E element;
		private Node<E> next;
		public Node(E e, Node<E> n){
			element = e;
			next = n;
		}
		private E getElement(){
			return element;
		}
		private Node<E> getNext(){
			return next;
		}
		private void setNext(Node<E> n){
			next = n;
		}
	}
	
	private Node<E> tail = null;
	private int size = 0;
	public CircularlyLinkedList(){
		
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public E first(){
		if(isEmpty())
			return null;
		return tail.getNext().getElement();
	}
	
	public E last(){
		if(isEmpty())
			return null;
		return tail.getElement();
	}
	
	// rotate the first element to the back of the list
	public void rotate(){
		if(tail != null)
			tail = tail.getNext();
	}
	
	public void addFirst(E e){
		if(isEmpty()){
			tail = new Node<E>(e, null);
			tail.setNext(tail);
		} else{
			Node<E> newest = new Node<>(e, tail.getNext());
			tail.setNext(newest);
		}
		size++;
	}
	
	public void addLast(E e){
		addFirst(e);
		tail = tail.getNext();
	}
	
	public E removeFirst(){
		if(isEmpty()) return null;
		Node<E> head = new Node<>(tail.getNext().getElement(), tail.getNext());
		if(head == tail)
			tail = null;
		else
			tail.setNext(head.getNext());
		size--;
		return head.getElement();
	}
}
