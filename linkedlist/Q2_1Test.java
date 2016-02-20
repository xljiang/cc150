package linkedlist;

//import static org.junit.Assert.*;

import org.junit.Test;

import CtCILibrary.LinkedListNode;

public class Q2_1Test {
	
	
	@Test
	public void test_removeDuplicatesA() {
		
		LinkedListNode first = new LinkedListNode(0, null, null); //AssortedMethods.randomLinkedList(1000, 0, 2);
		LinkedListNode head = first;
		LinkedListNode second = first;
		for (int i = 1; i < 8; i++) {
			second = new LinkedListNode(i % 2, null, null);
			first.setNext(second);
			second.setPrevious(first);
			first = second;
		}
		
		LinkedListNode clone = head.clone();

		System.out.println(head.printForward());
		Q2_1.removeDuplicatesA(head);
		System.out.println(head.printForward());
		
		Q2_1.removeDuplicatesB(clone);
		System.out.println(clone.printForward());
	}

}
