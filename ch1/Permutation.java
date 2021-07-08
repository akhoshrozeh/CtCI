public class Permutation {

	// note: we could sort the strings and then check char by char, but that has time complexity O(n log n)

	// create map of letters and make sure none have negative value
	// we dont need to check if an element is greater than 1 since that implies another element must be -1 
	public static boolean isPermutation(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;

		int[] letters = new int[256]; // assume char set is is ASCII extended

		for(int i=0; i < str1.length(); i++) {
			char temp = str1.charAt(i);
			letters[temp]++;
		}

		for(int i=0; i < str2.length(); i++) {
			char temp = str2.charAt(i);
			if(--letters[temp] < 0) {
				return false;
			}
		}

		return true;


	}


	public static void main(String[] args) {
		if(args.length != 2) {
			System.out.println("Please enter 2 strings as the parameters to the program. Exiting..");
			return;
		}

		String str1 = args[0];
		String str2 = args[1];
		
		if(isPermutation(str1, str2)) {
			System.out.println("True. Is a permutation");
		}
		else {
			System.out.println("False. Not a permutation");
		}


	}
}