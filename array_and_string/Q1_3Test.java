package array_and_string;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q1_3Test {
	
	@Test
	public void test_isPermutation() {
		assertEquals(true, Q1_3.isPermutation("dog", "god"));
		assertEquals(true, Q1_3.isPermutation("doggy", "ggody"));
		assertEquals(false, Q1_3.isPermutation("aa", "aaa"));
		assertEquals(false, Q1_3.isPermutation("a_ *", "0o d"));
		assertEquals(false, Q1_3.isPermutation("dog   ", "god"));
		assertEquals(true, Q1_3.isPermutation("  *  ", "    *"));
	}
	
	@Test
	public void test_isPermutation2() {
		assertEquals(true, Q1_3.isPermutation2("dog", "god"));
		assertEquals(true, Q1_3.isPermutation2("doggy", "ggody"));
		assertEquals(false, Q1_3.isPermutation2("aa", "aaa"));
		assertEquals(false, Q1_3.isPermutation2("a_ *", "0o d"));
		assertEquals(false, Q1_3.isPermutation2("dog   ", "god"));
		assertEquals(true, Q1_3.isPermutation2("  *  ", "    *"));
	}
	


}
