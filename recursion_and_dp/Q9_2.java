package recursion_and_dp;


//Imagine a robot sitting on the upper left corner of an X by Y grid. The robot can
//only move in two directions: right and down. How many possible paths are there
//for the robot to go from (0,0) to (X,Y)?

// FOLLOW UP
// Imagine certain squares are “off limits”, such that the robot can not step on them. 
// Design an algorithm to get all possible paths for the robot.

public class Q9_2 {

	// method 1: recursion
	public static int countPathsSimple(int x, int y){
		if (x == 0 || y == 0) return 1;  // only one way
		return countPathsSimple(x-1, y) + countPathsSimple(x, y-1);
	}
	
	// method 2: simple math: (x+y) choose x (combination->binomial function)
	public static int countPathsSimpleMath(int x, int y){
		return fact(x+y)/(fact(x)*fact(y));
	}
	
	public static int fact(int n){
		if (n == 0) return 1;
		return n*fact(n-1);
	}
	
	// method 3: dp
	public static int countPathsSimpleDP(int x, int y){
		int[] dp = new int[x+1];
		for(int i = 0; i <= x; i++){
			dp[i] = 1;
		}
		for(int i = 1; i <= y; i++){
			for(int j = 1; j <= x; j++){
				dp[j] += dp[j-1];
			}
		}
		return dp[x];
	}
	
	
	
	// Follow up
	
	// dp
	public static int countPaths(int[][] grid) {
	    int width = grid[0].length;
	    int[] dp = new int[width];
	    dp[0] = 1;
	    for (int[] row : grid) {
	        for (int j = 0; j < width; j++) {
	            if (row[j] == 1)
	                dp[j] = 0;
	            else if (j > 0)
	                dp[j] += dp[j - 1];
	        }
	    }
	    return dp[width - 1];
	}
	
	
	// Test
	public static void main(String[] args) {
		//simple
		System.out.println(countPathsSimple(2,2));
		System.out.println(countPathsSimpleMath(2,2));
		System.out.println(countPathsSimpleDP(20,20));
		
		// Follow up
		int[][] grid = {
		          	  	{0,0,0},
		          	  	{0,1,0},
		          	  	{0,0,0},
					   };
		System.out.println(countPaths(grid));
	}

}
