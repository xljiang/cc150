package stack_and_queue;

// Q3_7

public abstract class Animal {
	
	public String name;
	private int order;
	
	public Animal(String name){
		this.name = name;
	}
	
	public abstract String getName();

	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}
	
}
