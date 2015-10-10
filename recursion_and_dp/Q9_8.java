package recursion_and_dp;

// Given an infinite number of quarters, dimes, nickels and pennies,
// write code to calculate the number of ways of representing n cents.
public class Q9_8 {

	// method 1: recursive
	public static int makeChange(int n){
		int[] denoms = {25, 10, 5, 1};
		return makeChangeRecur(n, denoms, 0);
	}
	
	private static int makeChangeRecur(int amount, int[] denoms, int index){
		if (index >= denoms.length - 1) return 1;
		int denomAmount = denoms[index];
		int ways = 0;
		for (int i = 0; i*denomAmount <= amount; i++){
			int amountRemaining = amount - i*denomAmount;
			ways += makeChangeRecur(amountRemaining, denoms, index + 1);
		}
		return ways;
	}
	
	
	// method 2
	public static int makeChange2(int n){
		int[] denoms = {25,10, 5, 1};
		int[][] map = new int[n+1][denoms.length];
		return makeChangeDP(n, denoms, 0, map);
	}
	
	private static int makeChangeDP(int amount, int[] denoms, int index, int[][] map){
		if(map[amount][index] > 0){
			return map[amount][index];
		}
		if (index >= denoms.length - 1) return 1;
		int denomAmount = denoms[index];
		int ways = 0;
		for(int i = 0; i*denomAmount <= amount; i++){
			int amountRemaining = amount - i*denomAmount;
			ways += makeChangeDP(amountRemaining, denoms, index + 1, map);
		}
		map[amount][index] = ways;
		return ways;
	}
	
	
	// Test
	public static void main(String[] args) {
		long t1 = System.currentTimeMillis();
		System.out.println(makeChange(10000));
		long t2 = System.currentTimeMillis();

		System.out.println(makeChange2(10000));
		long t3 = System.currentTimeMillis();
		
		long diff1 = t2 - t1;
		long diff2 = t3 - t2;
		System.out.println("t1: " + t1 + " t2: " + t2 + " diff1: " + diff1);
		System.out.println("t2: " + t2 + " t3: " + t3 + " diff2: " + diff2);

	}
}
