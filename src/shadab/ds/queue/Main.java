package shadab.ds.queue;

import shadab.models.Employee;

public class Main {

	public static void main(String[] args) {
		Employee john = new Employee(1, "John");
		Employee james = new Employee(2, "James");
		Employee alice = new Employee(3, "Alice");
		Employee jane = new Employee(4, "Jane");
		
		ArrayQueue queue = new ArrayQueue(10);
		queue.printQueue();
		System.out.println(queue.size());
		queue.add(john);
		queue.add(james);
		queue.add(alice);
		queue.add(jane);
		queue.printQueue();
		queue.remove();
		queue.printQueue();

	}

}
