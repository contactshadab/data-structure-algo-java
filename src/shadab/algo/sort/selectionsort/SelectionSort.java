package shadab.algo.sort.selectionsort;

public class SelectionSort {
	
	private void swap(int[] arr, int i, int j){
		if(i == j)
			return;
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void display(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}
	
	public void sort(int[] arr) {
		for(int lastUnsortedPartition = arr.length-1; lastUnsortedPartition > 0; lastUnsortedPartition--) {
			for(int i = 0; i < lastUnsortedPartition; i++) {
				if(arr[i] > arr[lastUnsortedPartition])
					swap(arr, i, lastUnsortedPartition);
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {20, 35, -15, 7, 55, 1, -22};
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.display(arr);
		selectionSort.sort(arr);
		selectionSort.display(arr);

	}

}
