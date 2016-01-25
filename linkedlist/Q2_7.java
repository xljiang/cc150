package linkedlist;

import java.util.Stack;

import CtCILibrary.LinkedListNode;

public class Q2_7 {
	// method 1: fast, slow, and stack
	public static boolean isPalindrome(LinkedListNode head){
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		Stack<Integer> stack = new Stack<Integer>();
		while(fast != null && fast.next != null){
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null){
			slow = slow.next;
		}
		while(slow != null){
			int top = stack.pop().intValue();
			if(slow.data != top)
				return false;
			slow = slow.next;
		}
		return true;
	}
	
	public static Result isPalindromeRecurseHelper(LinkedListNode head, int length){
		if(head == null || length == 0){
			return new Result(null, true);
		} else if (length == 1){
			return new Result(head.next, true);
		} else if(length == 2){
			return new Result(head.next.next, head.data == head.next.data);
		}
		Result res = isPalindromeRecurseHelper(head.next, length - 2);
		if(!res.result || res.node == null){
			return res;
		} else{
			res.result = head.data == res.node.data;
			res.node = res.node.next;
			return res;
		}
	}
	
	public static boolean isPalindromeRecurse(LinkedListNode head){
		Result p = isPalindromeRecurseHelper(head, listSize(head));
		return p.result;
	}
	
	public static int listSize(LinkedListNode head){
		int size = 0;
		while (head != null){
			head = head.next;
			size++;
		}
		return size;
	}
	
	// test
	public static void main(String[] args) {
		int length = 9;
		LinkedListNode[] nodes = new LinkedListNode[length];
		for (int i = 0; i < length; i++) {
			nodes[i] = new LinkedListNode(i >= length / 2 ? length - i - 1 : i, null, null);
		}
		
		for (int i = 0; i < length; i++) {
			if (i < length - 1) {
				nodes[i].setNext(nodes[i + 1]);
			}
			if (i > 0) {
				nodes[i].setPrevious(nodes[i - 1]);
			}
		}
		//nodes[length - 2].data = 9; // Uncomment to ruin palindrome
		
		LinkedListNode head = nodes[0];
		System.out.println(head.printForward());
		System.out.println(isPalindrome(head));
		System.out.println(isPalindromeRecurse(head));
		
	}

}
