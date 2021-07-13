public class rotatedString {
	
	// returns true if s2 is substring of s1
	public static boolean isSubstring(String s1, String s2) {
		return s1.contains(s2);
	}

	public static boolean isRotation(String s1, String s2) {
		if(s1.length() != s2.length() || s1.length() == 0)
			return false;
		String s1s1 = s1 + s1;
		return isSubstring(s1s1, s2);

	}

// Assume you have a method isSubstring which checks if one word is a substring of another. 
// Given two strings, s i and s2, write code to check if s2 is a rotation of s1 
// using only one call to isSubstring (e.g.,"waterbottle"is a rotation of"erbottlewat").

	public static void main(String[] args) {
		boolean val =  isRotation("waterbottle", "erbottlewat");
		boolean val2 = isRotation("my name is tony", "s tonymy name i");

		System.out.println(val);
		System.out.println(val2);

	}
}