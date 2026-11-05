package assignment;

public class Node<T>{
	T obj;
	Node<T> next;
	
	public Node() {}
	
	public Node(T obj) {
		this.obj = obj;
		this.next = null;
	}
}
