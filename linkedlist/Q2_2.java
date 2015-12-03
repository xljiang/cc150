package linkedlist;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;

public class Q2_2 {
	
	// simply print
	public int nthToLastR1(LinkedListNode head, int k){
		if(k == 0 || head == null){
			return 0;
		}
		int i = nthToLastR1(head.next, k) + 1;
		if(i == k){
			System.out.println(k + "th to last node is "+ head.data);
		}
		return i;
	}
	
	
	
	// method 2: with a wrapper to pass "int" by reference
/*	public class IntWrapper{
		public int value = 0;
	}
	*/
	
	// method 2: recursive
	public static LinkedListNode nthToLastR2(LinkedListNode head, int k, IntWrapper i){
		if(head == null || k == 0){
			return null;
		}
		LinkedListNode node = nthToLastR2(head.next, k, i);
		i.value = i.value + 1;
		if(i.value == k){
			return head;
		}
		return node;
	}
	
	// method 3, iterative, 2 pointer interval = k
	// O(n) time and O(1) space
	public static LinkedListNode nthToLastR3(LinkedListNode head, int k){
		if(head == null || k == 0)
			return null;
		
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		int i = 1;
		while(i < k){
			if(p2 == null) return null;
			p2 = p2.next;
			i++;
		}
		while(p2.next != null){
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	public static void main(String[] args) {
		LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
		System.out.println(head.printForward());
		int nth = 3;
		IntWrapper wr = new IntWrapper();
		LinkedListNode n2 = nthToLastR2(head, nth, wr);
		LinkedListNode n3 = nthToLastR3(head, nth);
		if (n2 != null) {
			System.out.println("recursive");
			System.out.println(nth + "th to last node is: " + n2.data);
		} else {
			System.out.println("Null.  n is out of bounds.");
		}
		
		if (n3 != null) {
			System.out.println("iterative");
			System.out.println(nth + "th to last node is: " + n3.data);
		} else {
			System.out.println("Null.  n is out of bounds.");
		}
	}
}
