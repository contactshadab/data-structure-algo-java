package shadab.programs.array;

public class SearchElement_SortedRotatedArray {
	
	//Time Complexity: O(logn)
	public int searchInSortedAndRotatedArray(int[] arr, int val){
		int index;
		int pivot = findPivot(arr, 0, arr.length-1);
		if(pivot < 0)
			return -1;
		
		//If val is greater than last element of array, search on first part
		if(val > arr[arr.length-1]){
			index = binarySearch(arr, 0, pivot-1, val);
		}else {
			index = binarySearch(arr, pivot, arr.length-1, val);
		}
		
		return index;
	}
	
	private int findPivot(int arr[], int start, int end){
		if(start >= end)
			return -1;
		
		int mid = (start + end) / 2;
		
		//Check if the elements order is changed at m
		if(arr[mid + 1] < arr[mid]){
			//Found pivot
			return mid+1;
		}
		
		if(arr[start] > arr[mid]){
			//Search in first part
			return findPivot(arr, start, mid);
		}
		//Search in second part
		return findPivot(arr, mid+1, end);
	}
	
	private int binarySearch(int[] arr, int start, int end, int val){
		if(start > end)
			return -1;
		
		int mid = (start + end)/2;
		if(arr[mid] == val)
			return mid;
		
		if(val < arr[mid]){
			//Search in first part
			return binarySearch(arr, start, mid-1, val);
		}
		return binarySearch(arr, mid+1, end, val); //mid+1 as we have already checked mid
	}
	
	
	
	public static void main(String[] args) {
		int[] arr = {5, 9, 11, 15, 0, 3, 4};
		int findVal = 0;
		
		SearchElement_SortedRotatedArray search = new SearchElement_SortedRotatedArray();
				
		System.out.println("Element " + findVal+ " is at index: " + search.searchInSortedAndRotatedArray(arr, findVal));
	}

}
