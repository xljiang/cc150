package array_and_string;

public class Q1_5 {
	
	// method 1
	public static String compressString(String str){
		
		if (str == null || str.isEmpty())
			return str;
		
		String result = "";
		result += str.charAt(0);
		int count = 1;	// count repeat times
		for(int i = 1; i < str.length(); i++){
			if (i == 0) {
				result += str.charAt(i);
				count++;
			} else {
				if (str.charAt(i) == str.charAt(i - 1)){
					count++;
				} else{
					result += count;
					result += str.charAt(i);
					count = 1;
				}
			}
		}	
		
		result += count;
		
		if (result.length() >= str.length())
			return str;
		else return result;
	}
	
	
	
	// method 2: 1, precheck result's length --> more efficient
	// 			 2, use stringbuffer --> more efficient
	public static String compressString2(String str){
		
		// check length first
		if(compressedLength(str) >= str.length()){
			return str;
		}
		
		StringBuffer result = new StringBuffer();
		char last = str.charAt(0);		
		result.append(last);
		int count = 1;	// count repeats

		for(int i = 1; i < str.length(); i++){
			if (str.charAt(i) == last){
				count++;
			} else{
				result.append(count);
				last = str.charAt(i);
				result.append(last);
				count = 1;
			}
		}
		result.append(count);
		return result.toString();
	}
	
	
	private static int compressedLength(String str){
		
		if (str == null || str.isEmpty())
			return 0;
		
		char last = str.charAt(0);
		int count = 1;
		int size = 1;
		for(int i = 1; i < str.length(); i++){
			if(str.charAt(i) == last){
				count++;
			} else {
				last = str.charAt(i);
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += String.valueOf(count).length();
		return size;
	}

	
	// method 3: use array to rewrite method 2

}
