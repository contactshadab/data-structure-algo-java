package shadab.ds.doublyLinkedlist;

public class Node<T> {
	T object;
	Node previous;
	Node next;
	
	public Node(T object) {
		super();
		this.object = object;
	}

	public Node getPrevious() {
		return previous;
	}

	public void setPrevious(Node previous) {
		this.previous = previous;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return object.toString();
	}
	
	
	
	
}
