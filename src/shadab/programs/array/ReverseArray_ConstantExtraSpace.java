package shadab.programs.array;

public class ReverseArray_ConstantExtraSpace {
	
	public static void display(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.print('\n');
	}
	
	public static void swap(int arr[], int left, int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		display(arr);
		
		int left = 0;
		int right = arr.length -1;
		while(left < right){
			swap(arr, left++, right--);
		}
		
		display(arr);
	}

}
