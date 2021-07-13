public class changeSpaces {

	// changes all spaces in str to '%20'; length is the true length; 
	// assume we are given sufficient spaces in the arr to do inplace changes
	// time: O(n^2)
	// space: O(1)
	public static void m_updateSpaces(char[] str, int length) {
		// find spaces
		int newLength = 0;
		int spaces = 0;

		//count spaces
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ')
				spaces++;
		}

		newLength = length + (spaces * 2);
		str[newLength] = '\0';

		// update str[] spaces
		for (int i = length-1; i >= 0; i--) {
			if (str[i] != ' ') {
				str[newLength - 1] = str[i];
				newLength--;
			}
			else {
				str[newLength - 1] = '0';
				str[newLength - 2] = '2';
				str[newLength - 3] = '%';
				newLength = newLength - 3;
			}
		}
	}

	public static void main(String[] args) {
		char[] test1 = {'M', 'y',' ', 'n', 'a','m','e',' ','i','s',' ','T','o','n','y', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
		int len1 = 15;

		System.out.println("String before: ");
		for (char i : test1)
			System.out.print(i);
		System.out.print('\n');

		m_updateSpaces(test1, len1);

		System.out.println("String after: ");
		for (char i : test1)
			System.out.print(i);
		System.out.print('\n');



	}
}