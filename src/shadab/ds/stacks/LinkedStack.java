package shadab.ds.stacks;

import shadab.ds.linkedlist.MyLinkedList;

public class LinkedStack<T> {
	MyLinkedList<T> stack;
	
	LinkedStack(){
		stack = new MyLinkedList<T>();
	}
	
	public boolean isEmpty() {
		return stack.isEmpty();
	}
	
	public int size() {
		return stack.getSize();
	}
	
	public void push(T item) {
		stack.addToFirst(item);
	}
	
	public T pop() {
		return stack.removeFromFront().getType();
	}
	
	public T peek() {
		return (stack.getHead() != null)? stack.getHead().getType(): null;
	}
	
	public void printStack() {
		stack.printList();
	}
	
}
