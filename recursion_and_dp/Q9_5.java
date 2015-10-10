package recursion_and_dp;

import java.util.ArrayList;

// compute all permutations of a string
// N! permutations
public class Q9_5 {

	public static ArrayList<String> getPerms(String str){
		ArrayList<String> list = new ArrayList<String>();
		getPermsRecur("", str, list);
		return list;
	}
	
	private static void getPermsRecur(String soFar, String rest, ArrayList<String> list){
		if (rest.equals("")){
			list.add(soFar);
		} else{
			for(int i = 0; i < rest.length(); i++){
				String next = soFar + rest.charAt(i);
				String remaining = rest.substring(0, i) + rest.substring(i + 1, rest.length());
				getPermsRecur(next, remaining, list);
			}
		}
	}
	
	// Test
	public static void main(String[] args) {
		ArrayList<String> list = getPerms("abc");
		System.out.println("There are " + list.size() + " permutations.");
		for (String s : list) {
			System.out.println(s);
		}
	}
}
