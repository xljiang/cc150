package stack_and_queue;

import java.util.LinkedList;

public class Q3_7 {

	private LinkedList<Dog> dogs;
	private LinkedList<Cat> cats;
	private int order = 0;
	
	public Q3_7(){
		dogs = new LinkedList<Dog>();
		cats = new LinkedList<Cat>();
	}
	
	public void enqueue(Animal animal){
		animal.setOrder(order);
		order++;
		if(animal instanceof Dog){
			dogs.addLast((Dog) animal);
		}
		if(animal instanceof Cat){
			cats.addLast((Cat) animal);
		}
	}
	
	public Animal dequeueAny(){
		if(dogs.isEmpty()) return cats.removeFirst();
		else if(cats.isEmpty()) return dogs.removeFirst();
		Dog dog = dogs.getFirst();
		Cat cat = cats.getFirst();

		if(dog.getOrder() < cat.getOrder()){
			return dogs.removeFirst();
		} else {
			return cats.removeFirst();
		}
		
	}
	
	public Dog dequeueDog(){
		return dogs.removeFirst();

	}
	
	public Cat dequeueCat(){
		return cats.removeFirst();

	}
	
	public int size(){
		return dogs.size() + cats.size();
	}
}
