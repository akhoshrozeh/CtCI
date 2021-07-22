public class palindrome {

	// time and space: O(n)
	public static boolean m_isPalindrome(SLL list) {
		SLL reverse = new SLL();
		Node curr = list.getHead();

		if(curr == null || curr.next == null)
			return true;

		// create a copy of the list backwards
		while(curr != null) {
			reverse.push(curr.data);
			curr = curr.next;
		}

		System.out.println("the reverse");
		reverse.printSLL();

		// check each node is the same
		curr = list.getHead();
		Node revCurr = reverse.getHead();

		while(curr != null) {
			if(curr.data != revCurr.data)
				return false;
			curr = curr.next;
			revCurr = revCurr.next;
		}

		return true;
	}


	public static void main(String[] args) {
		SLL list = new SLL(20);
		for(int i = 18; i >= 0; --i) {
			list.append(i);
		}		
		list.printSLL();

		boolean val = m_isPalindrome(list);
		System.out.println(val);
	}
}