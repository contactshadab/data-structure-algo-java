package shadab.ds.linkedlist;

public class Main {

	public static void main(String[] args) {
		
		LinkedList<Employee> linkedList = new LinkedList<Employee>();
		
		linkedList.addToFirst(new Employee(1, "Shadab"));
		linkedList.addToFirst(new Employee(2, "Roshni"));
		linkedList.addToFirst(new Employee(3, "Shabih"));
		System.out.println(linkedList.getSize());
		linkedList.addToFirst(new Employee(4, "Waquar"));
		linkedList.printList();
		linkedList.removeFromFront();
		linkedList.printList();
	}

}

