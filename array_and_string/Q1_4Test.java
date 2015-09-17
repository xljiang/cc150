package array_and_string;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Q1_4Test {

	String strInput1 = "Mr John Smith    ";
	String strResult1 = "Mr%20John%20Smith";
//	String strResult = "Mr John Smith   ";

	String  strInput2 = "aa  bb                ";
	String strResult2 = "aa%20%20bb            ";
	
	String  strInput3 = "    bb                ";
	String strResult3 = "%20%20%20%20bb        ";
	
	@Test
	public void replaceSpaces() {
		
		char[] input1 = strInput1.toCharArray();
		char[] result1 = strResult1.toCharArray();
		Q1_4.replaceSpaces(input1, strInput1.length());
		assertTrue(Arrays.equals(input1, result1));
		
		char[] input2 = strInput2.toCharArray();
		char[] result2 = strResult2.toCharArray();
		Q1_4.replaceSpaces(input2, strInput2.length());
		assertTrue(Arrays.equals(input2, result2));
		
		char[] input3 = strInput3.toCharArray();
		char[] result3 = strResult3.toCharArray();
		Q1_4.replaceSpaces(input3, strInput3.length());
		assertTrue(Arrays.equals(input3, result3));

	}
	

}
