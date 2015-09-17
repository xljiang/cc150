package array_and_string;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Test;

public class Q1_7Test {

	
	@Test
	public void testSetZero_1() {
		
		int[][] grid = new int[][] {
			{1, 0, 1},
			{1, 1, 1},
			{1, 1, 1}
		};
		
		int[][] result = new int[][] {
			{0, 0, 0},
			{1, 0, 1},
			{1, 0, 1}
		};
		
		Q1_7.setZero(grid);
		assertTrue(Arrays.deepEquals(grid, result));
	}
	
	@Test
	public void testSetZero_2() {
		
		
		int[][] grid = new int[][] {
			{1, 0, 1},
			{1, 1, 1},
			{0, 1, 1}
		};
		
		int[][] result = new int[][] {
			{0, 0, 0},
			{0, 0, 1},
			{0, 0, 0}
		};
		
		Q1_7.setZero(grid);
		assertTrue(Arrays.deepEquals(grid, result));
	}
	
	
	@Test
	public void testSetZero2_1() {
		
		
		int[][] grid = new int[][] {
			{1, 0, 1},
			{1, 1, 1},
			{1, 1, 1}
		};
		
		int[][] result = new int[][] {
			{0, 0, 0},
			{1, 0, 1},
			{1, 0, 1}
		};
		
		Q1_7.setZero(grid);
		assertTrue(Arrays.deepEquals(grid, result));
	}
	
	@Test
	public void testSetZero2_2() {
		
		
		int[][] grid = new int[][] {
			{1, 0, 1},
			{1, 1, 1},
			{0, 1, 1}
		};
		
		int[][] result = new int[][] {
			{0, 0, 0},
			{0, 0, 1},
			{0, 0, 0}
		};
		
		Q1_7.setZero(grid);
		assertTrue(Arrays.deepEquals(grid, result));
	}
	

}
