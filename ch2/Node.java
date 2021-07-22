public class Node {
	// variables
	public Node next = null;
	public int data;

	// constructor
	public Node() {};

	public Node(int d) {
		this.data = d;
	}

	public void setData(int d) {
		this.data = d;
	}

	public int getData() {
		return this.data;
	}

	public void printNode() {
		if(this != null) {
			System.out.print(data);
			System.out.print(" ");
		}
		
	}
	
}