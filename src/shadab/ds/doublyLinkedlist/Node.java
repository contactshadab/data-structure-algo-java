package shadab.ds.doublyLinkedlist;

public class Node<T> {
	T item;
	Node previous;
	Node next;
	
	public Node(T object) {
		super();
		this.item = object;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
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
		return item.toString();
	}
	
	
	
	
}
