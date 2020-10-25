package dataStructure.array;

public class ConvertArrayToZigZag {
	//a < b > c < d > e < f.
	public void convertToZigZag(int[] arr) {
		for(int i=1; i<arr.length-1; i++){
			if(isEven(i)){
				if(arr[i] > arr[i-1])
					swap(arr, i, i-1);
			}else {
				if(arr[i] < arr[i-1])
					swap(arr, i, i-1);
			}
		}
	}
	
	public void display(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}
	
	private boolean isEven(int num){
		return (num % 2) == 0;
	}
	
	private void swap(int[] arr, int left, int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}

	public static void main(String[] args) {
		int arr[] = {4, 3, 7, 8, 6, 2, 1};
		ConvertArrayToZigZag zigZag = new ConvertArrayToZigZag();
		zigZag.display(arr);
		zigZag.convertToZigZag(arr);
		zigZag.display(arr);
	}

}
