public class deleteMiddle {


	// time and space: O(1)
	public static boolean m_delMid(SLL list, Node toDelete) {

		if(toDelete.next == null || toDelete == null)
			return false;		// can't do; need to mark as dummy variable somehow

		toDelete.data = toDelete.next.data;
		if(toDelete.next.next != null)
			toDelete.next = toDelete.next.next;
		else
			toDelete.next = null;

		return true;
	}


	public static void main(String[] args) {
		SLL list = new SLL(20);
		list.printSLL();
		System.out.print('\n');

		Node toDelete = list.getHead();
		
		for(int i=0; i<18; i++)
			toDelete = toDelete.next;

		

		System.out.print("After deleting the node:");
		toDelete.printNode();
		System.out.print('\n');
		System.out.println(m_delMid(list, toDelete));
		list.printSLL();
		return;
	}
}