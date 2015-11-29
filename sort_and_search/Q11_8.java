package sort_and_search;

import CtCILibrary.AssortedMethods;

/*Imagine you are reading in a stream of integers. Periodically, you wish to be able
to look up the rank of a number x (the number of values less than or equal to x).
Implement the data structures and algorithms to support these operations.That
is, implement the method track(int x), which is called when each number
is generated, and the method getRankOfNumber(int x), which returns the
number of values less than or equal to x (not including x itself).
EXAMPLE
Stream (in order of appearance): 5, 1, 4, 4, 5, 9, 7, 13, 3
getRankOfNumber(l) = 0
getRankOfNumber(3) = 1
getRankOfNumber(4) = 3*/

public class Q11_8 {
	
	public static void track(int x){
		
	}
	
	public static int getRankOfNumber(int x){
		return 0;
	}
	
	// Test
	public static void main(String[] args) {
		int size = 100;
		int[] list = AssortedMethods.randomArray(size, -100, 100);
		for (int i = 0; i < list.length; i++){
			track(list[i]);
		}
		int[] tracker = new int[size];
		for (int i = 0; i < list.length; i++){
			int v = list[i];
		//	int rank1 = root.getRank(list[i]);
			//tracker[rank1] = v;
		}
		
	}
}
