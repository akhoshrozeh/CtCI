import java.util.*; 

public class compressString {

	public static String m_compress(String str) {
		int origLen = str.length();
		int count = 1;
		StringBuffer compStr = new StringBuffer("");

		for (int i = 0; i <= str.length() - 2; i++) {
			
			if (str.charAt(i) == str.charAt(i+1)) {
				count++;
				if (i == str.length()-2) {
					compStr.append(str.charAt(i));
					compStr.append(count);
				}
			}
			else {
				compStr.append(str.charAt(i));
				compStr.append(count);
				count = 1;

				//check last character
				if (i == str.length()-2) {
					compStr.append(str.charAt(str.length()-1));
					compStr.append(1);
				}
			}
		}

		if (origLen <= compStr.length()) 
			return str;

		else
			return compStr.toString();
		
	
	}

	public static void main(String[] args) {
		String str;
		
		if(args.length == 1)
			str = args[0];
		else
			str = "aabcccccaaa";

		System.out.println(m_compress(str));
	}
}