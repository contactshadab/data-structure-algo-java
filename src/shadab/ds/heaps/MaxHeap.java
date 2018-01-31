package shadab.ds.heaps;

public class MaxHeap {
	private int[] heap;
	private int size;
	
	MaxHeap(int capacity){
		heap = new int[capacity];
	}
	
	public boolean isFull() {
		return size == heap.length;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insert(int data) {
		if(isFull())
			throw new ArrayIndexOutOfBoundsException("Heap is full");
		
		heap[size] = data;
		fixHeapAbove(size);
		size++;
	}
	
	private void fixHeapAbove(int index) {
		int newValue = heap[index];
		
		while(index > 0 && newValue > heap[getParent(index)]) {
			heap[index] = heap[getParent(index)];
			index = getParent(index);
		}
		
		heap[index] = newValue;
	}
	
	private void fixHeapBelow(int index) {
		int currentValue = heap[index];
		
		while(index < size-1 & currentValue < heap[getMaxChild(index)]) {
			heap[index] = heap[getMaxChild(index)];
			index = getMaxChild(index);
		}
		heap[index] = currentValue;
	}
	
	private int getMaxChild(int index) {
		//Left child check
		if((2*index + 1) > size-1)
			return -1;
		
		//Right child check
		if((2*index + 2) > size-1)
			return (2*index + 1);
		
		return (heap[2*index + 1] > heap[2*index + 2])? (2*index + 1): (2*index + 2);
	}
	
	private int getParent(int index) {
		return (index-1) / 2;
	}
	
	public int delete(int index) {
		int deletedValue = heap[index];
		int replacedValue = heap[size-1];
		heap[index] = replacedValue;
		if(index > 0 && heap[index] > heap[getParent(index)]) {
			fixHeapAbove(index);
		}else {
			fixHeapBelow(index);
		}
		size--;
		return deletedValue;
	}
	
	public void printHeap() {
		for(int i=0; i<size; i++)
			System.out.print(heap[i] + ", ");
		System.out.println("");
	}
	
	public int peek() {
		if(isEmpty())
			throw new IndexOutOfBoundsException("Heap is empty");
		
		return heap[0];
	}
	
}
