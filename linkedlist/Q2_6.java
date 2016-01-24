package linkedlist;

import CtCILibrary.LinkedListNode;

public class Q2_6 {
	
	// suppose it's already a circled linked list
	// thus no boundary check
	public static LinkedListNode beginOfLoop(LinkedListNode head){
		LinkedListNode p1 = head.next;
		LinkedListNode p2 = head.next.next;
		while(p1 != p2){
			p1 = p1.next;
			p2 = p2.next.next;
		}
		
		p1 = head; 
		while (p1 != p2) { 
			p1 = p1.next; 
			p2 = p2.next; 
		}
		return p1;

	}
	
	// method 2: standard answer
	public static LinkedListNode FindBeginning(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head; 
		
		// Find meeting point
		while (fast != null && fast.next != null) { 
			slow = slow.next; 
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		// Error check - there is no meeting point, and therefore no loop
		if (fast == null || fast.next == null) {
			return null;
		}

		/* Move slow to Head. Keep fast at Meeting Point. Each are k steps
		/* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
		slow = head; 
		while (slow != fast) { 
			slow = slow.next; 
			fast = fast.next; 
		}
		
		// Both now point to the start of the loop.
		return fast;
	}
	
	public static void main(String[] args) {
		int list_length = 100;
		int k = 10;
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[list_length];
		for (int i = 0; i < list_length; i++) {
			nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
		}
		
		// Create loop;
		nodes[list_length - 1].next = nodes[list_length - k];
		
		LinkedListNode loop = beginOfLoop(nodes[0]);
		if (loop == null) {
			System.out.println("No Cycle.");
		} else {
			System.out.println(loop.data);
		}
	}

}
