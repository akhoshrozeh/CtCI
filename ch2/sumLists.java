public class sumLists {

	// only works for same length lists; 
	// time: O(n)
	// space: O(n)

	// this checks to see if lengths are the same; if not -> make shorter one just as long
	public static void checkLength(SLL l1, SLL l2) {
		Node ptr = l1.getHead();
		int l1_len = 0;
		int l2_len = 0;

		while(ptr != null) {
			ptr = ptr.next;
			l1_len++;
		}

		ptr = l2.getHead();
		while(ptr != null) {
			ptr = ptr.next;
			l2_len++;
		}

		if(l1_len == l2_len) {
			return;
		}

		else {
			if(l1_len < l2_len) {
				int toAdd = l2_len - l1_len;
				fixLengths(l1, toAdd);
			}
			else {
				int toAdd = l1_len - l2_len;
				fixLengths(l2, toAdd);
			}
		}

		return;
	}

	// passes in the shorter list with the # of zero digits to append
	public static void fixLengths(SLL list, int toAdd) {
		for(int i = 0; i < toAdd; i++)
			list.append(0);
	}

	public static SLL m_sumReverse(SLL l1, SLL l2) {
		SLL summed = new SLL();
		Node sumPtr = summed.getHead();
		int carry = 0;
		int sum;

		Node l1Ptr = l1.getHead();
		Node l2Ptr = l2.getHead();

		while(l1Ptr != null && l2Ptr != null) {
			sum = l1Ptr.data + l2Ptr.data + carry;
			if(sum > 9) {
				summed.append(sum%10);
				carry = 1;
			}
			else {
				summed.append(sum);
				carry = 0;
			}

			l1Ptr = l1Ptr.next;
			l2Ptr = l2Ptr.next;
		} 

		if(carry == 1)
			summed.append(1);


		return summed;
	}


	public static void main(String[] args) {

		SLL l1 = new SLL();
		SLL l2 = new SLL();
		l1.append(7);
		l1.append(1);
		l1.append(6);
		l1.append(6);
		l1.append(6);
		l1.append(6);

		l2.append(5);
		l2.append(9);
		l2.append(4);
		// System.out.println(checkLength(l1, l2));


		l1.printSLL();
		System.out.print('\n');
		l2.printSLL();
		System.out.print('\n');

		// check if lengths are equal
		checkLength(l1, l2);
		SLL summed = m_sumReverse(l1, l2);
		summed.printSLL();
		
		

		


	}
}