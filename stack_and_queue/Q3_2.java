package stack_and_queue;

import CtCILibrary.AssortedMethods;


// this is a test class
// method 1: NodeWithMin + StackWithMin
// method 2: StackWithMin2
public class Q3_2 {

	public static void main(String[] args) {
		StackWithMin stack = new StackWithMin();
		StackWithMin2 stack2 = new StackWithMin2();
		for (int i = 0; i < 15; i++) {
			int value = AssortedMethods.randomIntInRange(0, 100);
			stack.push(value);
			stack2.push(value);
			System.out.print(value + ", ");
		}
		System.out.println('\n');
		for (int i = 0; i < 15; i++) {
			System.out.println("Popped " + stack.pop().value + ", " + stack2.pop());
			System.out.println("New min is " + stack.min() + ", " + stack2.min());
		}
	}

}
