// Singlely Linked List
public class SLL { 
	private Node head;

	public SLL() {}

	public SLL(int length) {
		for(int i=0; i < length; i++) {
			this.append(i);
		}
	}

	public Node getHead() {
		return this.head;
	}

	public boolean isEmpty() {
		return this.head == null ? true : false;
	}
	
	public void push(int d) {
		Node front = new Node(d);

		if(this.head == null) {
			head = front;
			return;
		}

		front.next = this.head;
		this.head = front; 
		return;
	}

	public void append(int d) {
		Node end = new Node(d);

		if(this.head == null) {
			head = end;
			return;
		}

		Node curr = this.head;
		while(curr.next != null) {
			curr = curr.next;
		}

		curr.next = end;
	}

	public Node delete(int d) {
		Node curr = this.head;
		
		if(curr.data == d) {
			head = curr.next;
			return this.head;
		}
		

		while(curr.next != null) {
			if(curr.next.data == d) {
				curr.next = curr.next.next;
				return this.head;
			}
			curr = curr.next;
		}

		return this.head; // not found
	}


	public void printSLL() {
		Node curr = this.head;

		if(curr == null) {
			System.out.println("Empty list.");
			return;
		}

		while(curr != null) {
			curr.printNode();
			curr = curr.next;

		}
		System.out.print('\n');
		return;


	}

}