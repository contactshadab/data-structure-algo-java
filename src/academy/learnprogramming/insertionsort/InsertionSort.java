package academy.learnprogramming.insertionsort;

public class InsertionSort {

	public void sort(int[] arr) {
		for(int firstUnsortedIndex = 1; firstUnsortedIndex < arr.length; firstUnsortedIndex++) {
			int newElement = arr[firstUnsortedIndex];
			
			int i;
			for(i = firstUnsortedIndex; i > 0 && arr[i-1] > newElement; i--) {
				arr[i] = arr[i-1];
			}
			arr[i] = newElement;
		}
	}
	
	public void display(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {20, 35, -15, 7, 55, 1, -22};

		InsertionSort insertionSort = new InsertionSort();
		insertionSort.display(arr);
		insertionSort.sort(arr);
		insertionSort.display(arr);
		
	}

}
