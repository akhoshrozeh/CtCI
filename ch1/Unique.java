import java.util.*;

public class Unique {
	// another naive solution is use 2 for-loops and check if theres a match
	// time is O(n^2) and space is O(1)w

	// uses a hashmap to check if character already exists
	// time and space is O(n)
	public static boolean my_unique(String word) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < word.length(); i++) {
			
			char curr = word.charAt(i);
			
			if(map.containsKey(curr)) {
				return false;
			} 
			else {
				map.put(curr, 1);
			}
		}
		return true;
	}

	// assume string is ASCII; then are 256 possible chars (extended set);
	// uses a bool array  
	// time is O(n) and space is O(1)
	public static boolean arr_unique(String word) {
		if (word.length() > 256) return false;

		boolean[] arr = new boolean[256];
		for (int i = 0; i < word.length(); i++) {
			char curr = word.charAt(i);
			if (arr[curr]) return false;
			else arr[curr] = true;
			
		}
		return true;
	}

	public static void main(String[] args) {
		String word = args[0];
		// if(my_unique(word)) {
		// 	System.out.println("True. All unique characters in string.");
		// }
		// else {
		// 	System.out.println("False. Duplicate characters in string.");
		// }
		if(arr_unique(word)) {
			System.out.println("True. All unique characters in string.");
		}
		else {
			System.out.println("False. Duplicate characters in string.");
		}
	}

}