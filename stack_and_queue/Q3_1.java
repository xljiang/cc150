package stack_and_queue;

import java.util.EmptyStackException;

public class Q3_1 {
	public static int stackSize = 10;
	public static int[] buffer = new int[stackSize * 3];
	
	// 3 pointers to keep track of the index of the top element
	public static int[] stackPointer = {-1, -1, -1};
	
	public static void push(int stackNum, int value) throws Exception{
		if(stackPointer[stackNum] + 1 > stackSize){
			throw new FullStackException();
		} else{
			stackPointer[stackNum]++;
			buffer[absTopOfStack(stackNum)] = value;
		}
	}
	
	public static int pop(int stackNum) throws Exception{
		if(isEmpty(stackNum)){
			throw new EmptyStackException();
		} else{
			int top = buffer[absTopOfStack(stackNum)];
			buffer[absTopOfStack(stackNum)] = 0;
			stackPointer[stackNum]--;
			return top;
		}
	}
	
	public static int peek(int stackNum){
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		else return buffer[absTopOfStack(stackNum)];
	}
	
	public static boolean isEmpty(int stackNum){
		return stackPointer[stackNum] == -1;
	}
	
	private static int absTopOfStack(int stackNum){
		return stackNum * stackSize + stackPointer[stackNum];
	}
	
	
	public static void main(String [] args) throws Exception  {
		push(2, 4);
		System.out.println("Peek 2: " + peek(2));
		push(0, 3);
		push(0, 7);
		push(0, 5);
		System.out.println("Peek 0: " + peek(0));
		pop(0);
		System.out.println("Peek 0: " + peek(0));
		pop(0);
		System.out.println("Peek 0: " + peek(0));
	}
}
