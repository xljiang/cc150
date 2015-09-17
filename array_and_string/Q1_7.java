package array_and_string;

import java.util.HashSet;
import java.util.Set;

public class Q1_7 {

	public static void setZero(int[][] grid){
		Set<Integer> row = new HashSet<Integer>();
		Set<Integer> col = new HashSet<Integer>();
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[i].length; j++){
				if (grid[i][j] == 0){
					row.add(i);
					col.add(j);
				}
			}
		}
		
		for (int i : row){
			for(int j = 0; j < grid[i].length; j++){
				grid[i][j] = 0;
			}
		}
		
		for (int j : col){
			for(int i = 0; i < grid.length; i++){
				grid[i][j] = 0;
			}
		}
	}
	
	
	// method2: this one better or the first one better?
	
	public static void setZero2(int[][] grid){
		Set<Integer> row = new HashSet<Integer>();
		Set<Integer> col = new HashSet<Integer>();
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[i].length; j++){
				if (grid[i][j] == 0){
					row.add(i);
					col.add(j);
				}
			}
		}
		
		for (int i = 0; i < grid.length; i++){
			for (int j = 0; j < grid[i].length; j++){
				if (row.contains(i) || col.contains(j)){
					grid[i][j] = 0;
				}
			}
		}
	}
}
