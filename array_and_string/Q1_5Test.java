package array_and_string;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q1_5Test {

	@Test
	public void test_compression() {
		assertTrue(Q1_5.compressString("aabcccccaaa").equals("a2b1c5a3"));
		assertTrue(Q1_5.compressString("abcd").equals("abcd"));
		assertTrue(Q1_5.compressString("").equals(""));
		assertTrue(Q1_5.compressString("  ").equals("  "));
		assertTrue(Q1_5.compressString("   ").equals(" 3"));

		
		// advanced: 
		// compressed string is longer than the original string
		assertTrue(Q1_5.compressString("abcdefghiii").equals("abcdefghiii"));


	}
	
	
	@Test
	public void test_compression2() {
		assertTrue(Q1_5.compressString2("aabcccccaaa").equals("a2b1c5a3"));
		assertTrue(Q1_5.compressString2("abcd").equals("abcd"));
		assertTrue(Q1_5.compressString2("").equals(""));
		assertTrue(Q1_5.compressString2("  ").equals("  "));
		assertTrue(Q1_5.compressString2("   ").equals(" 3"));

		
		// advanced:
		// compressed string is longer than the original string
		assertTrue(Q1_5.compressString2("abcdefghiii").equals("abcdefghiii"));
	}

}
