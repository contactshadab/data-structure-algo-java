package shadab.ds.linkedlist;

public class LinkedList<T> {

	private Node<T> head;
	int size ;
	
	public void addToFirst(T object) {
		Node<T> current = head;
		head = new Node<T>(object);
		head.setNext(current);
		size++;
	}
	
	public Node<T> getHead() {
		return head;
	}

	public void printList() {
		Node<T> currentNode = head;
		System.out.print("Head -> ");
		while(currentNode != null) {
			System.out.print(currentNode);
			System.out.print(" -> ");
			currentNode = currentNode.getNext();
		}
		System.out.println("null");
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public int getSize() {
		return size;
	}
	
	public Node<T> removeFromFront() {
		if(isEmpty())
			return null;
		
		Node<T> removedNode = head;
		head = head.getNext();
		size--;
		return removedNode;
	}
	
	public void insertSorted(T number) {
		if(!(number instanceof Integer))
			return;
		
		Node<T> insertedNode = new Node<T>(number);
		
		if(isEmpty()) {
			head = insertedNode;
			return;
		}
		
		Node<T> current = head;
		Node<T> previous = null;
		while(current != null && ((Integer)current.getType()) <= (Integer)number) {
			previous = current;
			current = current.getNext();
		}
		
		if(current == head)
			head = insertedNode;
		else
			previous.setNext(insertedNode);
		
		insertedNode.setNext(current);
		
		size++;
	}

}
