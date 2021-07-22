public class partition {
	
	// create two lists and then attach them 
	// time: O(n)
	// space: O(n)
	public static SLL m_partition(SLL list, int x) {
		SLL lessList = new SLL();
		SLL gtrList = new SLL();

		Node curr = list.getHead();

		if(curr == null || curr.next == null)
			return list;

		// 
		while(curr != null) {
			if(curr.data < x) {
				lessList.append(curr.data);
			}
			else if(curr.data >= x) {
				gtrList.append(curr.data);
			}
			curr = curr.next;
		}

		Node lessPtr = lessList.getHead();
		while(lessPtr.next != null)
			lessPtr = lessPtr.next;

		// attach the lists
		lessPtr.next = gtrList.getHead();
		return lessList;

	}

	public static void main(String[] args) {
		SLL list = new SLL();
		for(int i=0; i<20; i++)
			list.append((int)(Math.random()*10));
		list.printSLL();

		System.out.println("After partitioning: ");
		SLL newList = m_partition(list, 5);
		newList.printSLL();

	}
}