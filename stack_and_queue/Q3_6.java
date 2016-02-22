package stack_and_queue;

import java.util.Stack;

// sort a stack in ascending order
public class Q3_6 {
	
	public Stack<Integer> sort(Stack<Integer> stack){
		Stack<Integer> stackSorted = new Stack<Integer>();
		while(!stack.isEmpty()){
			int temp = stack.pop();
			while(!stackSorted.isEmpty() && temp < stackSorted.peek()){
				stack.push(stackSorted.pop());
			}
			stackSorted.push(temp);
		}	
		return stackSorted;
	}
}
