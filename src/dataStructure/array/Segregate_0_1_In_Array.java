package dataStructure.array;

public class Segregate_0_1_In_Array {
	
	/* Method 1:
	Count no of 0s in array and fill the array accordingly
	Time Complexity: O(n)
	Space Complexity: O(1)*/
	public void segregateByCountMethod(int[] arr) {
		int count = 0;
		for(int i=0; i<arr.length; i++){
			if(arr[i] == 0)
				count++;
		}
		for(int i=0; i<arr.length; i++){
			if(i < count)
				arr[i] = 0;
			else
				arr[i] = 1;
		}
	}
	
	/* Method: 2
	Start from left and swap with right if 1 encountered
	Time Complexity: O(n)
	Space Complexity: O(1)*/
	public void segregateBySwapping(int arr[]) {
		int left = 0;
		int right = arr.length -1;
		while (left <= right){
			if(arr[left] == 0)
				left++;
			else{
				swap(arr, left, right);
				right--;
			}	
		}
	}
	
	private void swap(int[] arr, int left, int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public void display(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}


	public static void main(String[] args) {
		int[] arr = {0,1,1,1,1,0,0,1,0,1,0,0,1,0};
		Segregate_0_1_In_Array segregator = new Segregate_0_1_In_Array();
		segregator.display(arr);
		//segregator.segregateByCountMethod(arr);
		segregator.segregateBySwapping(arr);
		segregator.display(arr);

	}

}
