package dataStructure.stacks;

import java.util.EmptyStackException;

import models.Employee;

public class ArrayStack {
	
	private Employee[] stack;
	private int top;
	
	public ArrayStack(int capacity) {
		this.stack = new Employee[capacity];
	}
	
	private boolean isEmpty() {
		return top == 0;
	}
	
	public int size() {
		return top;
	}
	
	public void push(Employee employee) {
		if(size() == stack.length) {
			Employee[] newStack = new Employee[2 * stack.length];
			System.arraycopy(stack, 0, newStack, 0, stack.length);
			stack = newStack;
		}
		
		stack[top++] = employee;
	}
	
	public Employee pop() {
		if(isEmpty())
			throw new EmptyStackException();
		
		Employee poppedItem = stack[--top];
		stack[top] = null;
		return poppedItem;
	}
	
	public Employee peek() {
		if(isEmpty())
			return null;
		
		return stack[top - 1];
	}
	
	public void printStack() {
		for(int i=size()-1; i >= 0; i--)
			System.out.println(stack[i]);
	}
}
