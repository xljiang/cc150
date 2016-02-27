package stack_and_queue;

public class Q3_7Test {

	public static void main(String[] args) {
		Q3_7 animals = new Q3_7();
		animals.enqueue(new Cat("Callie"));
		animals.enqueue(new Cat("Kiki"));
		animals.enqueue(new Dog("Fido"));
		animals.enqueue(new Dog("Dora"));
		animals.enqueue(new Cat("Kari"));
		animals.enqueue(new Dog("Dexter"));
		animals.enqueue(new Dog("Dobo"));
		animals.enqueue(new Cat("Copa"));
		
		System.out.println(animals.dequeueAny().getName());	
		System.out.println(animals.dequeueDog().getName());	
		System.out.println(animals.dequeueCat().getName());	
		
		animals.enqueue(new Dog("Dapa"));
		animals.enqueue(new Cat("Kilo"));
		
		while (animals.size() != 0) {
			System.out.println(animals.dequeueAny().getName());	
		}
	}
	
}
