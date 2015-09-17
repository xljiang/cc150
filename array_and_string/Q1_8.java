package array_and_string;

public class Q1_8 {

	// presume sub and str cannot be null or empty
	public static boolean isSubString(String str, String sub){
		for(int i = 0; i < str.length(); i++){
			if (str.charAt(i) == sub.charAt(0)){
				if(str.length() - i >= sub.length()){
					String generateSub = str.substring(i, i + sub.length());
					if(generateSub.equals(sub))
						return true;
				}
			}
		}
		return false;
	}

	// can only call isSubString once
	public static boolean isRotation(String str, String rot){
		if (str.length() != rot.length() || rot.isEmpty())
			return false;
		String strstr = str + str;
		return isSubString(strstr, rot);
	}
}
