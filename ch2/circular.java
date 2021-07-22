// Given a circular linked list, implement an algorithm which returns the node at the beginning of the loop.
public class circular {

	// fast/slow runner approach; we can detect if it's circular through a collision
	public static Node beginNode(SLL circList) {
		Node slow = circList.getHead();
		Node fast = circList.getHead();

		// k steps until beginning of looped part
		// K = k mod LOOPSIZE
		// they will meet at LOOPSIZE - K
		while(fast != null || fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
				break;
		}

		// no collision -> not circular
		if(fast == null || fast.next == null)
			return null;
		
		// find the beginning of the loop
		slow = circList.getHead();
		while(slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow;
	}

	public static void main(String[] args) {

		// creating the circular list
		SLL list = new SLL(10);
		list.printSLL();
		Node end = list.getHead();
		Node beginLoop = list.getHead();
		while(end.next != null)
			end = end.next;

		for(int i = 0; i < 6; i++)
			beginLoop = beginLoop.next;
		System.out.print("The correct beginning node: ");
		beginLoop.printNode();
		end.next = beginLoop;

		// 0 1 2 3 4 5 6 7 8 9 6 7 8 9 6 7 8 9 ...
		// i.e. 6 is the beginning node

		Node beginning = beginNode(list);
		System.out.print("The beginning node detected: ");
		beginning.printNode();

		return; 
	}
}