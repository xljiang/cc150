package array_and_string;

public class Q1_4 {
	
	public static void replaceSpaces(char[] str, int length){
		
		int i = str.length - 1;
		while(str[i] == ' '){
			i--;
		}

		for (int j = 0; j <= i; j++){
			if(str[j] == ' '){
				str[j] = '%';
				i = i + 2;
				for (int k = i; k > j + 2; k--){
					str[k] = str[k - 2];
				}
				str[j+1] = '2';
				str[j+2] = '0';
			}
		}
	}
}
