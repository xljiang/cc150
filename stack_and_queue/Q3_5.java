package stack_and_queue;

import java.util.Stack;

// myQueue use two stacks
public class Q3_5 {

	private Stack<Integer> stack, revStack;
	
	public Q3_5(){
		stack = new Stack<Integer>();
		revStack = new Stack<Integer>();
	}
	
	public int size(){
		return stack.size() + revStack.size();
//		return stack.size() > revStack.size() ? stack.size() : revStack.size();
	}
	
	public Integer peek(){
		if(revStack.isEmpty()){
			shiftStack(stack, revStack);
		}
		return revStack.peek();
	}
	
	private void shiftStack(Stack<Integer> stack1, Stack<Integer> stack2){
		// shift data from stack1 to stack2
		if(stack2.isEmpty()){
			while(!stack1.isEmpty()){
				stack2.push(stack1.pop());
			}
		}
	}
	
	// add
	public void enqueue(Integer item){
		if(stack.isEmpty()){
			shiftStack(revStack, stack);
		}
		stack.push(item);
	}
	
	// remove
	public Integer dequeue(){
		if(revStack.isEmpty()){
			shiftStack(stack, revStack);
		}
		return revStack.pop();	
	}
	
}
