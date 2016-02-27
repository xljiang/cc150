package stack_and_queue;

import java.util.Stack;


// Q3-2
public class StackWithMin extends Stack<NodeWithMin>{
	
	private static final long serialVersionUID = 1L;

	public void push(int value){
		int newMin = Math.min(value, min());
		super.push(new NodeWithMin(value, newMin));
	}
	
	public int min(){
		if(this.isEmpty()){
			return Integer.MAX_VALUE;
		} else{
			return peek().min;
		}
	}
}
