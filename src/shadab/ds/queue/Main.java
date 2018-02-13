package shadab.ds.queue;

import shadab.models.Employee;

public class Main {

	public static void main(String[] args) {
		Employee jane = new Employee(1, "Jane");
		Employee john = new Employee(2, "John");
		Employee mary = new Employee(3, "Mary");
		Employee mike = new Employee(4, "Mike");
		Employee bill = new Employee(5, "Bill");
		
		
		//ArrayQueue queue = new ArrayQueue(10);
		CircularQueue queue = new CircularQueue(5);
		
		queue.add(jane);
		queue.add(john);
		queue.add(mary);
		queue.add(mike);
		queue.add(bill);
		queue.printQueue();
		
		
//		queue.add(jane);
//		queue.add(john);
//		queue.remove();
//		queue.add(mary);
//		queue.remove();
//		queue.add(mike);
//		queue.remove();
//		queue.add(bill);
//		queue.remove();
//		queue.add(jane);
//		queue.printQueue();
		

	}

}
