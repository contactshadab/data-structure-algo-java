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
	
	public void printList() {
		Node<T> currentNode = head;
		System.out.print("Head -> ");
		while(currentNode != null) {
			System.out.print(currentNode);
			System.out.print(" -> ");
			currentNode = currentNode.getNext();
		}
		System.out.println("");
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

}
