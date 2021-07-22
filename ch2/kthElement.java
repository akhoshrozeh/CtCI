public class kthElement {
	// Implement an algorithm to find the kth to last element of a singly linked list.

	// iterate through to find length, then find kth to last
	// time: O(n + (n-2)) -> O(2n) -> O(n)
	// space: O(1)
	public static int m_findKth(SLL list, int k) {
		if(k < 1)
			return -1;
		Node curr = list.getHead();

		if(curr == null)
			return -1;

		int length = 0;
		while(curr != null) {
			curr = curr.next;
			length++;
		}

		if(k > length)
			return -1;

		curr = list.getHead();
		for(int i = 0; i < length - k; i++) {
			curr = curr.next;
		}

		return curr.data;
	}

	public static void main(String[] args) {
		int k;
		if(args.length != 1)
			k = 5;
		else {
			k = Integer.parseInt(args[0]);
		}

		SLL list = new SLL(20);
		list.printSLL();
		System.out.println('\n');

		System.out.println(m_findKth(list, k));
	}
}