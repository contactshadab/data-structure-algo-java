package shadab.ds.doublyLinkedlist;

public class DoublyLinkedList<T> {
	Node<T> head;
	Node<T> tail;
	int size;
	
	public void printList() {
		Node<T> currentNode = head;
		System.out.print("Head <-> ");
		while(currentNode != null) {
			System.out.print(currentNode);
			System.out.print(" <-> ");
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
	
	public void addToFront(T object) {
		Node<T> addedNode = new Node<T>(object);
		
		if(head == null) 
			tail = addedNode;
		else
			head.setPrevious(addedNode);
		
		addedNode.setNext(head);
		
		head = addedNode;
		size++;
	}
	
	public void addToEnd(T object) {
		Node<T> addedNode = new Node<T>(object);
		
		if(tail == null)
			head = addedNode;
		else
			tail.setNext(addedNode);
		
		addedNode.setPrevious(tail);
		
		tail = addedNode;
		size++;
	}
	
	public Node<T> removeFromFront(){
		if(isEmpty())
			return null;
		
		Node<T> removedNode = head;
		
		if(head.getNext() == null)
			tail = null;
		else
			head.getNext().setPrevious(null);
		
		head = head.getNext();
		return removedNode;
		
	}
	
	public Node<T> removeFromEnd(){
		if(isEmpty())
			return null;
		
		Node<T> removedNode = tail;
		
		if(tail.getPrevious() == null)
			head = null;
		else
			tail.getPrevious().setNext(null);
		
		tail = tail.getPrevious();
		return removedNode;
	}
	
	
}
