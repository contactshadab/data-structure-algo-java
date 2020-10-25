package dataStructure.linkedList;

import models.Employee;

public class DoublyLinkedList<T> {

	private class Node<T> {
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
	
	public boolean addBefore(T newItem, T existingItem) {
		if(isEmpty())
			return false;
		
		Node<T> current = head;
		while(current !=null && !current.getItem().equals(existingItem)) {
			current = current.getNext();
		}
		
		if(current == null)
			return false;
		
		Node<T> newNode = new Node<T>(newItem);
		newNode.setPrevious(current.getPrevious());
		newNode.setNext(current);
		current.setPrevious(newNode);
		
		if(head == current)
			head = newNode;
		else
			newNode.getPrevious().setNext(newNode);
		
		size++;
		return true;
	}


	public static void main(String[] args) {
		DoublyLinkedList<Employee> linkedList = new DoublyLinkedList<Employee>();
		linkedList.addToFront(new Employee(1, "John"));
		linkedList.addToFront(new Employee(2, "Alice"));
		linkedList.addToFront(new Employee(3, "James"));
		linkedList.printList();
		linkedList.addToEnd(new Employee(4, "Rosh"));
		linkedList.printList();
		linkedList.removeFromFront();
		linkedList.printList();
		linkedList.removeFromEnd();
		linkedList.printList();

		Employee employee = new Employee(1, "John");
		linkedList.addBefore(new Employee(5, "Jamie"), employee);
		linkedList.printList();

	}
	
	
}
