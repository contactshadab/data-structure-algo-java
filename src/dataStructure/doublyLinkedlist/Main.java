package dataStructure.doublyLinkedlist;

import models.Employee;

public class Main {

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
