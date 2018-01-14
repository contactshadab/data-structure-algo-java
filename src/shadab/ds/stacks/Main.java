package shadab.ds.stacks;

import shadab.models.Employee;

public class Main {

	public static void main(String[] args) {
		Employee john = new Employee(1, "John");
		Employee james = new Employee(2, "James");
		Employee alice = new Employee(3, "Alice");
		Employee jane = new Employee(4, "Jane");
		
		ArrayStack stack = new ArrayStack(10);
		System.out.println(stack.peek());
		stack.printStack();
		stack.push(john);
		stack.push(james);
		stack.push(alice);
		stack.push(jane);
		stack.printStack();
		System.out.println("Pop - " + stack.pop());
		stack.printStack();

	}

}
