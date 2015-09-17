package array_and_string;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q1_1Test {

	@Test
	public void test_allUnique() {
		assertEquals(true, Q1_1.allUnique(""));
		assertEquals(true, Q1_1.allUnique("abc"));
		assertEquals(false, Q1_1.allUnique("  "));
		assertEquals(false, Q1_1.allUnique("abbbc c"));
	}
	
	@Test
	public void test_allUnique2() {
		assertEquals(true, Q1_1.allUnique2(""));
		assertEquals(true, Q1_1.allUnique2("abc"));
		assertEquals(false, Q1_1.allUnique2("  "));
		assertEquals(false, Q1_1.allUnique2("abbbc c"));
	}
	
	@Test
	public void test_allUnique3() {
		assertEquals(true, Q1_1.allUnique3(""));
		assertEquals(true, Q1_1.allUnique3("abc"));
		assertEquals(false, Q1_1.allUnique3("  "));
		assertEquals(false, Q1_1.allUnique3("abbbc c"));
	}

}
