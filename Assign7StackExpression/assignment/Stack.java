package assignment;

public class Stack<T> implements StackInterface{
	Node head;
	
	public Stack() {
		this.head = null;
	}
	
	@Override
	public void push(Object item) {
		Node newNode = new Node(item);
		newNode.next = this.head;
		this.head = newNode;
	}

	@Override
	public Object pop() {
		Node node = this.head;
		this.head = this.head.next;
		return node;
	}

	@Override
	public Object peek() {
		return this.head;
	}

	@Override
	public boolean isEmpty() {
		if(this.head != null) {
			return false;
		}
		return true;
	}

	@Override
	public int size() {
		int count = 0;
		Node curNode = this.head;
		while(this.head != null) {
			count++;
			curNode = curNode.next;
		}
		return count;
	}

}
