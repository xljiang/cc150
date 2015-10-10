package recursion_and_dp;

import java.util.ArrayList;


// return all subsets of a set

public class Q9_4 {

	// method 1: recursion
	public static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> allsubsets;
		if(set.size() == index){ // base case, add empty set
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
		} else{
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for (ArrayList<Integer> subset : allsubsets){
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
	
	
	// method 2: combinatorics, use binary string
	
	// method 3: inspired from cs106b
	// be careful about pass by reference, should pass by value
	public static ArrayList<ArrayList<Integer>> getSubsets3(ArrayList<Integer> set){
		ArrayList<ArrayList<Integer>> allsubsets = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> emptySet = new ArrayList<Integer>();
		SubSetRecur(emptySet, set, allsubsets);
		return allsubsets;
	}
	
	private static void SubSetRecur(ArrayList<Integer> soFar, ArrayList<Integer> rest, 
			ArrayList<ArrayList<Integer>> allsubsets){
		
		if(rest.isEmpty()){
			if (soFar.isEmpty()){
				allsubsets.add(new ArrayList<Integer>());
			} else{
				allsubsets.add(soFar);
			}
		} else{
			ArrayList<Integer> soFarAdd = new ArrayList<Integer>();
			ArrayList<Integer> restrest = new ArrayList<Integer>();
			soFarAdd.addAll(soFar);
			restrest.addAll(rest);
			int item = rest.get(0);
			soFarAdd.add(item);
			restrest.remove(0);
			// don't add to soFar, remove from rest, recur
			SubSetRecur(soFar, restrest, allsubsets);
			
			// add to soFar, remove from rest, recur
			SubSetRecur(soFarAdd, restrest, allsubsets);
		}
	}
	
	/*	
  	// print all substring of a string
    public static void printSubStringSet(String str){
		SubStringRecur("", str);
	}
	
	private static void SubStringRecur(String soFar, String rest){
		if(rest.equals("")){
			System.out.println(soFar);
		} else{
			// don't add to soFar, remove from rest, recur
			SubStringRecur(soFar, rest.substring(1));
			
			// add to soFar, remove from rest, recur
			SubStringRecur(soFar + rest.charAt(0), rest.substring(1));
		}
	}*/
	
	// Test
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			list.add(i);
		}
		ArrayList<ArrayList<Integer>> subsets = getSubsets(list, 0);
		System.out.println(subsets.toString());
		
		ArrayList<ArrayList<Integer>> subsets3 = getSubsets3(list);
		System.out.println(subsets3.toString());	
		
		// print all substring of a string
		// printSubStringSet("012");
		
	}
}
