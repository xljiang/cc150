package sort_and_search;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.LinkedList;

/*Write a method to sort an array of strings so that all the anagrams are next to
each other.
Anagram: a word the letters of which can be rearranged into another word, 
e.g. "angel" is an anagram of "glean"
*/
public class Q11_2 {
	
	// method 1: BF
	public static void sortAnagram(String[] array){
		for ( int i = 0; i < array.length - 1; i++){
			for ( int j = i + 1; j < array.length; j++){
				if (sortedStr(array[i]).equals(sortedStr(array[j]))){
					String tmp = array[i+1];
					array[i+1] = array[j];
					array[j] = tmp;
				}
			}
		}
	}

	// method 2: Hash table & linked list
	public static void sortAnagram2(String[] array){
		Hashtable<String, LinkedList<String>> hash = new Hashtable<String, LinkedList<String>>();
		for (int i = 0; i < array.length; i++){
			String key = sortedStr(array[i]);
			if (!hash.containsKey(key)){
				LinkedList<String> ll = new LinkedList<String>();
				ll.add(array[i]);
				hash.put(key, ll);
			} else {
				hash.get(key).add(array[i]);
			}
		}
		
		int i = 0;
		for (String key : hash.keySet()){
			while (!hash.get(key).isEmpty()){
				array[i++] = hash.get(key).pop();
			}
		}
	}
	
	
	/**
	 * sort a string alphabetically
	 * @param str input string
	 * @return sorted string
	 */
	private static String sortedStr(String str){
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}
	
	// print
	private static void printArray(String[] array){
		
		System.out.print("[");
		for (int i = 0; i < array.length; i++){
			System.out.print(array[i] + ", ");
		}
		System.out.print("]");
		System.out.println();
	}
	
	// Test
	public static void main(String[] args) {
		String[] array = {"apple", "banana", "carrot", "ele", "duck", "papel", "tarroc", "cudk", "eel", "lee"};
		sortAnagram2(array);
		printArray(array);
	}
}
