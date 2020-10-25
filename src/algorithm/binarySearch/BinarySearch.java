package algorithm.binarySearch;

public class BinarySearch {
	
	public int binarySearch(int[] arr, int start, int end, int val) {
		if(start > end)
			return -1;
		
		int mid = (start + end)/2;
		
		if(val == arr[mid])
			return mid;
		if(val < arr[mid])
			return binarySearch(arr, start, mid-1, val);
		else
			return binarySearch(arr, mid+1, end, val);
	}

	public static void main(String[] args) {
		int[] arr = {1, 4, 6, 8, 11, 32};
		BinarySearch search = new BinarySearch();
		int index = search.binarySearch(arr, 0, arr.length-1, 1);
		System.out.println("Index: " + index);
	}

}
