package chap14_java;


public class CircularArrayTest {

	public static void main(String[] args) {
		int size = 10;
		CircularArray<String> array = new CircularArray<String>(size);
		for (int i = 0; i < size; i++) {
			array.set(i, String.valueOf(i));
		}
		
		array.rotate(3);
		for (int i = 0; i < size; i++) {
			System.out.println(array.get(i));
		}
		
		System.out.println("");
		
		array.rotate(-3);
		for (String s : array) {
			System.out.println(s);
		}
	}

}