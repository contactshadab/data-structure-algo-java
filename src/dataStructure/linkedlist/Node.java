package dataStructure.linkedlist;

public class Node<T> {
	
	private T type;
	private Node<T> next;
	
	public Node(T type) {
		this.type = type;
	}

	public T getType() {
		return type;
	}

	public void setType(T type) {
		this.type = type;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	public String toString() {
		return type.toString();
	}
	
}
