package array_and_string;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Q1_6Test {

	@Test
	public void test_rotateClockwise_1() {
	
		int[][] grid = new int[][] {
			{1, 0, 1},
			{1, 1, 1},
			{1, 1, 1}
		};
		
		int[][] result = new int[][] {
			{1, 1, 1},
			{1, 1, 0},
			{1, 1, 1}
		};
		
		Q1_6.rotateClockwise(grid, 3);
		assertTrue(Arrays.deepEquals(grid, result));
	}

	@Test
	public void test_rotateClockwise_2() {
	
		int[][] grid = new int[][] {
			{0, 1, 2, 5},
			{3, 1, 2, 6},
			{2, 3, 4, 7},
			{1, 2, 3, 8}
		};
		
		int[][] result = new int[][] {
			{1, 2, 3, 0},
			{2, 3, 1, 1},
			{3, 4, 2, 2},
			{8, 7, 6, 5}
		};
		
		Q1_6.rotateClockwise(grid, 4);
		assertTrue(Arrays.deepEquals(grid, result));
	}


}
