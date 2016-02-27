package stack_and_queue;

import java.util.Stack;


// Q3-2
public class StackWithMin2 extends Stack<Integer>{
	
	private static final long serialVersionUID = 1L;
	
	Stack<Integer> minStack;
	
	public StackWithMin2(){
		minStack = new Stack<Integer>();
	}
	
	public void push(int value){
		if( value <= min()){
			minStack.push(value);
		}
		super.push(value);
	}
	
	public Integer pop(){
		int value = super.pop();
		if(value == min()){
			minStack.pop();
		}
		return value;
	}
	
	public int min(){
		if(minStack.isEmpty()){
			return Integer.MAX_VALUE;
		} else{
			return minStack.peek();
		}
	}

}
