package linkedlist;

import CtCILibrary.LinkedListNode;

public class Q2_3 {
	
	// delete a node in the middle of a singly linked list
	public static boolean deleteNode(LinkedListNode n){
		if(n == null || n.next == null){
			return false; // failure
		}
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}
}
