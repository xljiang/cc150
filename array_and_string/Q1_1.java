package array_and_string;

import java.util.ArrayList;

public class Q1_1 {
	
	// use ArrayList
	public static boolean allUnique(String str){
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < str.length(); i++){
			if(list.contains(str.charAt(i)))
				return false;
			else list.add(str.charAt(i));
		}
		return true;
	}
	
	// no additional data structures. time - O(n2), space - O(1)
	public static boolean allUnique2(String str){
		char[] arr = new char[str.length()];
		for(int i = 0; i < str.length(); i++){
			if(contains(arr, str.charAt(i)))
				return false;
			else arr[i] = str.charAt(i);
		}	

		return true;
	}
	
	private static boolean contains(char[] arr, char c){
		for(int i = 0; i < arr.length; i++){
			if(arr[i] == c) return true;
		}
		return false;	
	}
	
	// ascII 256 set, set boolean flag. time - O(n), space - O(1)
	public static boolean allUnique3(String str){
		if (str.length() > 256) return false;
		boolean[] char_set = new boolean[256];
		for(int i = 0; i < str.length(); i++){
			int val = str.charAt(i); // get an ascII code (int) from a char
			System.out.println(val);
			if(char_set[val])
				return false;
			char_set[val] = true;
				
		}
		return true;	
	}
	
	// method 4: use bit vector
}
