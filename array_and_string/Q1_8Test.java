package array_and_string;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q1_8Test {

	@Test
	public void test_isSubString() {
		// presume sub and str cannot be null or empty	
		assertEquals(true, Q1_8.isSubString("abcdefg", "bcd"));
		assertEquals(false, Q1_8.isSubString("abcdefg", "defgh"));
		assertEquals(false, Q1_8.isSubString("abcdefg", "hij"));
		assertEquals(true, Q1_8.isSubString("abcdafg", "af"));

	}
	
	@Test
	public void test_isRotation() {		
		assertEquals(true, Q1_8.isRotation("abcdefg", "cdefgab"));
		assertEquals(true, Q1_8.isRotation("abcdefg", "abcdefg"));
		assertEquals(false, Q1_8.isRotation("abcdefg", "bcd"));
		assertEquals(false, Q1_8.isRotation("abcdefg", "bcdefgx"));
		assertEquals(true, Q1_8.isRotation("abcddddefg", "ddefgabcdd"));

	}

}
