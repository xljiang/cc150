package linkedlist;

import java.util.HashSet;

import CtCILibrary.LinkedListNode;

public class Q2_1 {
	
	public static void removeDuplicatesA(LinkedListNode n){
		HashSet<Integer> set = new HashSet<Integer>();
		LinkedListNode previous = null;
		while(n != null){
			if(set.contains(n.data)){
				previous.next = n.next;
			} else{
				set.add(n.data);
				previous = n;
			}
			n = n.next;
		}
	}	

	// method2: don't use temporary buffer
	public static void removeDuplicatesB(LinkedListNode head){
		if(head == null) return;
		LinkedListNode curr = head;
		while(curr != null){
			LinkedListNode runner = curr;
			while(runner.next != null){
				if(runner.next.data == curr.data){
					runner.next = runner.next.next;
				} else{
					runner = runner.next;
				}
			}
			curr = curr.next;
		}
	}
	
	
}