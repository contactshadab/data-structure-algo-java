package shadab.algo.sort.quicksort;

public class QuickSort {

	public void display(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}
	
	private void swap(int[] arr, int i, int j){
		if(i == j)
			return;
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void quickSort(int[] arr, int start, int end) {
		if(end - start < 2)
			return;
		
		int pIndex = partition(arr, start, end);
		quickSort(arr, start, pIndex-1);
		quickSort(arr, pIndex, end);
		
	}
	
	public int partition(int[] arr, int start, int end) {
		int i = start-1;
		int j = start;
		int pivot = arr[end];
		
		for(i = start-1, j = start; j < end; j++) {
			if(arr[j] < pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, end);
		return i+1;
	}
	
	public static void main(String[] args) {
		int[] arr = {20, 35, -15, 7, 55, 1, -22};
		QuickSort sort = new QuickSort();
		sort.display(arr);
		sort.quickSort(arr, 0, arr.length-1);
		sort.display(arr);
	}

}
