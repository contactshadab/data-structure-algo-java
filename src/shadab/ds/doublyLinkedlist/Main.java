package shadab.ds.doublyLinkedlist;

import shadab.ds.linkedlist.Employee;

public class Main {

	public static void main(String[] args) {
		DoublyLinkedList<Employee> linkedList = new DoublyLinkedList<Employee>();
		linkedList.addToFront(new Employee(1, "Shadab"));
		linkedList.addToFront(new Employee(2, "Roshni"));
		linkedList.addToFront(new Employee(3, "Shabih"));
		linkedList.printList();
		linkedList.addToEnd(new Employee(4, "Waquar"));
		linkedList.printList();
		linkedList.removeFromFront();
		linkedList.printList();
		linkedList.removeFromEnd();
		linkedList.printList();
	}

}
