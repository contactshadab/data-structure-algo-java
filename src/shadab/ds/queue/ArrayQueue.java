package shadab.ds.queue;

import java.util.NoSuchElementException;

import shadab.models.Employee;

public class ArrayQueue {
	
	Employee[] queue;
	int front;
	int back;
	
	ArrayQueue(int capacity){
		this.queue = new Employee[capacity];
	}
	
	public void add(Employee employee) {
		if(back == queue.length) {
			Employee[] newQueue = new Employee[2 * queue.length];
			System.arraycopy(queue, 0, newQueue, 0, queue.length);
			queue = newQueue;
		}
		
		queue[back++] = employee;
	}
	
	public Employee remove() {
		if(size() == 0)
			throw new NoSuchElementException();
		
		Employee removedItem = queue[front];
		
		queue[front++] = null;
		return removedItem;
	}
	
	public Employee peek() {
		return queue[front];
	}
	
	public int size() {
		return back-front;
	}
	
	public void printQueue() {
		for(int i = front; i < back; i++)
			System.out.println(queue[i]);
	}

}
