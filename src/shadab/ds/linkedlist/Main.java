package shadab.ds.linkedlist;

public class Main {

	public static void main(String[] args) {
		
		LinkedList<Employee> linkedList = new LinkedList<Employee>();
		
		linkedList.addToFirst(new Employee(1, "John"));
		linkedList.addToFirst(new Employee(2, "Alice"));
		linkedList.addToFirst(new Employee(3, "James"));
		System.out.println(linkedList.getSize());
		linkedList.addToFirst(new Employee(4, "Rosh"));
		linkedList.printList();
		linkedList.removeFromFront();
		linkedList.printList();
	}

}

