/*Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements
Input: 1 2 3 4 5 6 7 8 9
Output: 3 4 5 6 7 8 9 1 2*/

package shadab.programs.array;

public class RotateArray_n_Size_by_d_elements {
	
	/*Brute force method
	Time Complexity: O(n)
	Space Complexity: O(d)*/
	public void rotateByUsingExtraSpace(int[] arr, int d) {
		//Create a temperary aray of d size
		int tempArr[] = new int[d];
		
		//Copy d elements from original array to temp array
		for(int i=0; i<d; i++)
			tempArr[i] = arr[i];
		
		//Shift all ements by d place
		shiftLeft(arr, d);
		
		//Copy from tempArr to origin array's last d places
		System.arraycopy(tempArr, 0, arr, arr.length-d, d);
	}
	
	//Helper method for shifting array by d positions
	private void shiftLeft(int[] arr, int d){
		for(int i = d; i < arr.length; i++){
			arr[i-d] = arr[i];
		}
	}
	
	
	/*Rotate one by one
	Time Complexity: O(n*d) ~~ O(n)
	Space Complexity: O(1)*/
	public void rotateOneByOne(int[] arr, int d){
		int n = arr.length -1;
		for(int i=0; i<d; i++){
			//Store the first element to be copied to last
			int temp = arr[0];
			//iterate n-1 times as last element will be copied to the previous one
			int j;
			for(j=0; j <= n-1; j++){
				arr[j] = arr[j+1];
			}
			//Copy the first item to the last element
			arr[j] = temp;
		}
	}
	
	/*Rotate array of n elements by d elements
	Reverse three parts of the array 0-d, d+1-n and finally 0-n
	Time Complexity: O(n)
	Space Complexity: O(1)*/
	public void rotateByReversing(int[] arr, int d){
		ReverseArray_ConstantExtraSpace reverse = new ReverseArray_ConstantExtraSpace();
		reverse.reverseArray(arr, 0, d-1);
		reverse.reverseArray(arr, d, arr.length -1);
		reverse.reverseArray(arr, 0, arr.length -1);
	}
	
	public void display(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.print('\n');
	}
	
	//Driver code
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		int d = 2;
		
		RotateArray_n_Size_by_d_elements rotateArray = new RotateArray_n_Size_by_d_elements();
		
		rotateArray.display(arr);
		rotateArray.rotateByUsingExtraSpace(arr, d);
		rotateArray.display(arr);
		
		int[] arr2 = {1, 2, 3, 4, 5, 6, 7, 8};
		rotateArray.display(arr2);
		rotateArray.rotateOneByOne(arr2, d);
		rotateArray.display(arr2);
		
		int[] arr3 = {1, 2, 3, 4, 5, 6, 7, 8};
		rotateArray.display(arr3);
		rotateArray.rotateByReversing(arr3, d);
		rotateArray.display(arr3);
	}

}
