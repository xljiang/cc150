package stack_and_queue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

// set of stacks
public class Q3_3 {
	private ArrayList<Stack<Integer>> setOfStacks;
	private int threshold;
	
	public Q3_3(int threshold){

		setOfStacks = new ArrayList<Stack<Integer>>();
		this.threshold = threshold;
	}
	
	public void push(int value){
		if (setOfStacks.isEmpty() || getCurrStack().size() == threshold){
			Stack<Integer>stack = new Stack<Integer>();
			stack.push(value);
			setOfStacks.add(stack);
		} else{
			getCurrStack().push(value);
		}
	}
	
	public int pop(){
		if(setOfStacks.isEmpty()){
			throw new EmptyStackException();
		}
		Stack<Integer> curr = getCurrStack();
		int top = curr.pop();
		if(curr.isEmpty()){
			setOfStacks.remove(curr);
		} 
		return top;
	}
	
	private Stack<Integer> getCurrStack(){
		if(setOfStacks.isEmpty()){
			throw new EmptyStackException();
		}
		Stack<Integer> curr = setOfStacks.get(setOfStacks.size() - 1);
		return curr;
	}

}
