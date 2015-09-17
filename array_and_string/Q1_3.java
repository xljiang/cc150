package array_and_string;

import java.util.HashMap;
import java.util.Map;

public class Q1_3 {
	
	// method 1, use hashmap, check occurrence
	public static boolean isPermutation(String str1, String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		
		// map(char, occurrence times)
		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		for (int i = 0; i < str1.length(); i++){
			char key = str1.charAt(i);
			if(map1.containsKey(key))
				map1.put(key, map1.get(key) + 1);
			else map1.put(key, 1);
		}
		
		for(int i = 0; i < str2.length(); i++){
			char key = str2.charAt(i);
			if (!map1.containsKey(key)){
				return false;
			} else {
				map1.put(key, map1.get(key) - 1);
			}
			if(map1.get(key) == 0){
				map1.remove(key);
			}
		}
		
		return true;
	}
	
	// method 2, use 256 char array, check occurrence
	public static boolean isPermutation2(String str1, String str2){
		if(str1.length() != str2.length()){
			return false;
		}
		
		int[] char_set = new int[256];
		for(int i = 0; i < str1.length(); i++){
			int val = str1.charAt(i);
			char_set[val]++;
		}
		
		for(int i = 0; i < str2.length(); i++){
			int val = str2.charAt(i);
			int occr = char_set[val];
			char_set[val] = occr - 1;
			if (char_set[val] < 0) return false;
		}
		
		return true;
	}
	
	// method 3: sort string then compare
}
