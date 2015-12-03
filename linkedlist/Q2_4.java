package linkedlist;

import CtCILibrary.LinkedListNode;

public class Q2_4 {
	
	public static LinkedListNode partition(LinkedListNode node, int x){
		LinkedListNode beforeStart = null;
		LinkedListNode beforeEnd = null;
		LinkedListNode afterStart = null;
		LinkedListNode afterEnd = null;

		while(node != null){
			LinkedListNode next = node.next;
			node.next = null;
			if(node.data < x){
				if(beforeStart == null){
					beforeStart = node;
					beforeEnd = beforeStart;
				} else{
					beforeEnd.next = node;
					beforeEnd = node;
				}
			} else{
				if(afterStart == null){
					afterStart = node;
					afterEnd = afterStart;
				} else{
					afterEnd.next = node;
					afterEnd = node;
				}
			}
			node = next;
		}
		
		if(beforeStart == null) 
			return afterStart;
		beforeEnd.next = afterStart;
		return beforeStart;
	}
	
	// put < x before head, >= x after tail
	public static LinkedListNode partition2(LinkedListNode node, int x){
		
		LinkedListNode head = node;
		LinkedListNode tail = node;
		
		while(node != null){
			LinkedListNode next = node.next;
			if(node.data < x){
				node.next = head;
				head = node;
			} else{
				tail.next = node;
				tail = node;
			}
			node = next;
		}
		tail.next = null;
		return head;
	}
	
	
	public static void main(String[] args) {
		/* Create linked list */
		int[] vals = {1, 3, 7, 5, 2, 9, 4};
		LinkedListNode head = new LinkedListNode(vals[0], null, null);
		LinkedListNode current = head;
		for (int i = 1; i < vals.length; i++) {
			current = new LinkedListNode(vals[i], null, current);
		}
		LinkedListNode clone = head.clone();
		
		/* Partition */
		LinkedListNode h = partition(head, 5);
		LinkedListNode h2 = partition2(clone, 5);
		
		/* Print Result */
		System.out.println(head.printForward()); // 1->3->2->4->7->5->9
		System.out.println(h.printForward()); // 1->3->2->4->7->5->9
		System.out.println(h2.printForward()); // 4->2->3->1->7->5->9
	}
}
