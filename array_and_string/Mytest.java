package array_and_string;

public class Mytest {
	public static void main(String[] args) {
		String str = "abc";
		Integer i = 1;
		int[] arr = {1};
		im(str,i, arr);
		System.out.println(str + ", " + i + ", " + arr[0]);

	}
	
	public static void im(String str, Integer i, int[] arr){
		str += "ddd";
		i = 2;
		arr[0] = 2;
		System.out.println(str + ", " + i + ", " + arr[0]);
	}
}
