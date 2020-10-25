package dataStructure.array;

public class ReverseArray_ConstantExtraSpace {
	
	public void display(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.print('\n');
	}
	
	private void swap(int arr[], int left, int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public void reverseArray(int arr[], int startIndex, int endIndex){
		int left = startIndex;
		int right = endIndex;
		while(left < right){
			swap(arr, left++, right--);
		}
	}

	public static void main(String[] args) {
		
		ReverseArray_ConstantExtraSpace reverse = new ReverseArray_ConstantExtraSpace();
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		reverse.display(arr);
		
		reverse.reverseArray(arr, 0, arr.length-1);
		
		reverse.display(arr);
	}

}
