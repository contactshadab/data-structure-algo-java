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
	
	public void insert(int data) {
		if(isFull())
			throw new ArrayIndexOutOfBoundsException();
		
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
	
	private int getParent(int index) {
		return (index-1) / 2;
	}
	
}
