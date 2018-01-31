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
	
	private void fixHeapBelow(int index, int lastHeapIndex) {
		int maxChild;
		
		while(index <= lastHeapIndex) {
			int leftChild = 2*index + 1;
			int rightChild = 2*index + 2;
			
			if(leftChild <= lastHeapIndex) {
				if(rightChild > lastHeapIndex)
					maxChild = leftChild;
				else
					maxChild = (heap[leftChild] > heap[rightChild]? leftChild: rightChild);
				
				if(heap[index] < heap[maxChild]) {
					int temp = heap[index];
					heap[index] = heap[maxChild];
					heap[maxChild] = temp;
				}else {
					break;
				}
			}else {
				break;
			}
			
			index = maxChild;
			
		}
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
			fixHeapBelow(index, size-1);
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
	
	public void sort() {
		
		int lastHeapIndex = size-1;
		
		while(lastHeapIndex > 0) {
			//Swap 0th and last index elements
			int temp = heap[0];
			heap[0] = heap[lastHeapIndex];
			heap[lastHeapIndex] = temp;
			
			//Heapify below
			fixHeapBelow(0, --lastHeapIndex);
		}
	}
	
}
