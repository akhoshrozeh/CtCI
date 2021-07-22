import java.util.*;

public class removeDuplicates {

	public static void incrementValue(Map<Integer, Integer> map, Integer key)
    {
        // get the value of the specified key
        Integer count = map.get(key);
 
        // if the map contains no mapping for the key,
        // map the key with a value of 1
        if (count == null) {
            map.put(key, 1);
        }
        // else increment the found value by 1
        else {
            map.put(key, count + 1);
        }
    }

    // delete() iterates through in the implementation
    // faster way implemented in feu below
	public static void m_removeDups(SLL list) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		Node m_head = new Node();
		m_head = list.getHead();
		if (m_head == null)
			return;

		Node ptr = m_head; 
		while(ptr != null) {
			incrementValue(map, ptr.data);
			if(map.get(ptr.data) > 1)
				list.delete(ptr.data);
			ptr = ptr.next;
		}

	}

	// time: O(n)
	// space O(n)
	// instead of calling delete which finds the node, we just relink using another pointer
	public static void m2_removeDups(SLL list) {
		HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();

		Node curr = list.getHead();
		Node prev = new Node();

		if(curr == null)
			return;

		while(curr != null) {
			if(map.containsKey(curr.data)) {
				prev.next = curr.next;
			}
			else {
				map.put(curr.data, true);
				prev = curr;
			}
			curr = curr.next;
		}

		

	}

	// time: O(n^2)
	// space: O(1)
	// uses a runner; like 2 for loops
	public static void m3_removeDups(SLL list) {
		Node curr = list.getHead();
		Node runner = list.getHead();

		if(curr == null || curr.next == null)
			return;

		while(curr != null) {
			while(runner.next != null) {
				if(runner.next.data == curr.data) {
					runner.next = runner.next.next;
				} 
				else {
					runner = runner.next;
				}
			}
			curr = curr.next;
			runner = curr;
		}

	}

	public static void main(String[] args) {

		SLL list = new SLL();

		// original sol'n
		System.out.println("m_removeDups");
		for(int i = 0; i<20; i++) {
			list.append(i%5);
		}
	
		list.printSLL();
		System.out.println();
		m_removeDups(list);
		list.printSLL();


		// better way
		System.out.println("\nm2_removeDups");
		for(int i = 0; i<20; i++) {
			list.append(i%5);
		}
		list.printSLL();
		System.out.println();
		m2_removeDups(list);
		list.printSLL();


		// save space for time
		System.out.println("\nm3_removeDups");
		for(int i = 0; i<20; i++) {
			list.append(i%5);
		}
		list.printSLL();
		System.out.println();
		m3_removeDups(list);
		list.printSLL();

		return;
	}
}