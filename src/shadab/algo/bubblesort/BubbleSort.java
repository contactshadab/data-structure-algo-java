package shadab.algo.bubblesort;

public class BubbleSort {

	private void swap(int[] arr, int i, int j){
		if(i == j)
			return;
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public void sort(int[] arr){
		for(int lastUnsortedIndex = arr.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--){
			for(int i=0; i<lastUnsortedIndex; i++){
				if(arr[i] > arr[i+1]){
					swap(arr, i, i+1);
				}
			}	
		}
	}
	
	public void display(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {20, 35, -15, 7, 55, 1, -22};

		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.display(arr);
		bubbleSort.sort(arr);
		bubbleSort.display(arr);
	}

}
