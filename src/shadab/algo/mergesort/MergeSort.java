package shadab.algo.mergesort;

public class MergeSort {

	public void display(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}
	
	public void mergeSort(int[] arr, int start, int end){
		if(end - start < 1)
			return;
		
		int mid = (start + end) / 2;
		
		mergeSort(arr, start, mid);
		mergeSort(arr, mid+1, end);
		
		merge(arr, start, mid, end);
	}
	
	private void merge(int[] arr, int start, int mid, int end) {
		int[] tempArr = new int[end-start+1];
		int i = start, j = mid+1;
		int index = 0;
		while(i <= mid && j <= end) {
			tempArr[index++] = (arr[i] <= arr[j])? arr[i++]: arr[j++]; 
		}
		int leftoverIndex = (i <= mid)? i: j;
		//Copy elements to temp array
		System.arraycopy(arr, leftoverIndex, tempArr, index, tempArr.length - index);
		//Copy elements from temp array to input array
		System.arraycopy(tempArr, 0, arr, start, tempArr.length);
	}
	
	public static void main(String[] args) {
		int[] arr = {20, 35, -15, 7, 55, 1, -22};
		MergeSort sort = new MergeSort();
		sort.display(arr);
		sort.mergeSort(arr, 0, arr.length-1);
		sort.display(arr);
	}

}
