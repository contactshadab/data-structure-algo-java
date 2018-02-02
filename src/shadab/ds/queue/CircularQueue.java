package shadab.ds.queue;

import java.util.NoSuchElementException;

import shadab.models.Employee;

public class CircularQueue {
	
	Employee[] queue;
	int front;
	int back;
	
	CircularQueue(int capacity){
		this.queue = new Employee[capacity];
	}
	
	public void add(Employee employee) {
		//Resize array if there is only one space left so that back is at valid position always
		if(size() == queue.length-1) {
			int origSize = size();
			Employee[] newQueue = new Employee[2 * queue.length];
			
			System.arraycopy(queue, front, newQueue, 0, queue.length - front);
			System.arraycopy(queue, 0, newQueue, queue.length - front, back);
			
			queue = newQueue;
			
			front = 0;
			back = origSize;
		}
		
		queue[back] = employee;
		
		if(back < queue.length-1)
			back++;
		else
			back = 0;
	}
	
	public Employee remove() {
		if(size() == 0)
			throw new NoSuchElementException();
		
		Employee removedItem = queue[front];
		
		queue[front++] = null;
		
		//If array is empty, set front and back to 0
		if(size() == 0)
			front = back = 0;
		else if(front == queue.length) //Using queue.length as front is already incremented
			front = 0;
		
		return removedItem;
	}
	
	public Employee peek() {
		return queue[front];
	}
	
	public int size() {
		if(front < back)
			return back-front;
		else
			return queue.length - (front - back);
	}
	
	public void printQueue() {
		if(front < back) {
			for(int i = front; i < back; i++)
				System.out.println(queue[i]);	
		}else {
			for(int i = front; i < queue.length; i++)
				System.out.println(queue[i]);
			for(int i = 0; i < back; i++)
				System.out.println(queue[i]);	
		}
		
	}

}
