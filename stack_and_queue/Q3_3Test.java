package stack_and_queue;

public class Q3_3Test {
	
	
	public static void main(String[] args) {
		int capacity_per_substack = 5;
		Q3_3 set = new Q3_3(capacity_per_substack);
		for (int i = 0; i < 34; i++) {
			set.push(i);
		}
		for (int i = 0; i < 34; i++) {
			System.out.println("Popped " + set.pop());
		}		
	}
}
