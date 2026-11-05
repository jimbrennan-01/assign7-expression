package assignment;

import java.util.EmptyStackException;

public class Stack<T> implements StackInterface<T>{
	Node<T> head;
	int size;
	
	public Stack() {
		this.head = null;
	}
	
	@Override
	public void push(T item) {
		Node<T> newNode = new Node<>(item);
		newNode.next = this.head;
		this.head = newNode;
		size++;
	}

	@Override
	public T pop() {
		if (this.head == null) throw new EmptyStackException();
		Node<T> node = this.head;
		this.head = this.head.next;
		size--;
		return (T) node.obj;
	}

	@Override
	public T peek() {
		if (this.head == null) throw new EmptyStackException();

		return (T) this.head.obj;
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
		return this.size;
	}

}
