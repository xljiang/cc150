package recursion_and_dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

// print all valid combinations of n-pairs of parentheses.
// eg. input: 3
// output: ((())), (()()), (())(), ()(()), ()()()
public class Q9_6 {
	
	// method 1: insert a pair of parens inside every existing pair of parens, check duplicates
	public static Set<String> generateParens(int n){
		Set<String> set = new HashSet<String>();
		if (n == 1){
			set.add("()");
		} else{
			Set<String> prevset = generateParens(n - 1);
			for(String str : prevset){
				String newstr1 = "()" + str;
				set.add(newstr1);
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '('){
						String newstr2 = str.substring(0, i + 1) + "()" + str.substring(i + 1);
						set.add(newstr2);
					}
				}
			}
		}
		return set;
	}
	
	// similar as method 1, use helper recur function, keep result set updated
	// method1 is better than this one
	public static void printParens(int n){
		Set<String> set = new HashSet<String>();
		ParensRecur(n, set);
		for(String str : set){
			System.out.print(str + " ");
		}
	}
	
	private static void ParensRecur(int n, Set<String> set){
		if(n == 1){
			set.add("()");
		} else if (n > 1){
			ParensRecur(n - 1, set);
			Set<String> prevset = new HashSet<String>();
			prevset.addAll(set);
			for(String str : prevset){
				String newstr1 = "()" + str;
				set.add(newstr1);
				for(int i = 0; i < str.length(); i++){
					if(str.charAt(i) == '('){
						String newstr2 = str.substring(0, i + 1) + "()" + str.substring(i + 1);
						set.add(newstr2);
					}
				}
				set.remove(str);
			}
		} else return;
	}
	
	
	// method 2
	public static ArrayList<String> generateParens2(int n){
		char[] str = new char[n*2];
		ArrayList<String> list = new ArrayList<String>();
		addParen(list, n, n, str, 0);
		return list;
	}
	
	private static void addParen(ArrayList<String> list, int leftRem,
			int rightRem, char[] str, int count){
		if (leftRem < 0 || rightRem < leftRem){
			return;
		}
		if (leftRem == 0 && rightRem == 0){
			String s = String.copyValueOf(str);
			list.add(s);
		} else {
			// add left paren, if there are any left left parens remaining
			if (leftRem > 0){
				str[count] = '(';
				addParen(list, leftRem - 1, rightRem, str, count + 1);
			}
			// add right paren, if expression is valid
			if (rightRem > leftRem){
				str[count] = ')';
				addParen(list, leftRem, rightRem - 1, str, count + 1);
			}
		}
	}
	
	
	// Test
	public static void main(String[] args) {
		// test method 1
		System.out.println("method 1: ");
		Set<String> set = generateParens(3);
		for(String str : set){
			System.out.print(str + " ");
		}
		
		System.out.println();
		System.out.println("printParens1");
		printParens(1);
		System.out.println();
		System.out.println("printParens2");
		printParens(2);
		System.out.println();
		System.out.println("printParens3");
		printParens(3);

		// test method 2
		System.out.println();
		System.out.println("method 2: ");
		ArrayList<String> list = generateParens2(1);
		for(String str : list){
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.println("method 2: ");
		ArrayList<String> list2 = generateParens2(2);
		for(String str : list2){
			System.out.print(str + " ");
		}
		System.out.println();
		System.out.println("method 2: ");
		ArrayList<String> list3 = generateParens2(3);
		for(String str : list3){
			System.out.print(str + " ");
		}
	}
	
	

}
