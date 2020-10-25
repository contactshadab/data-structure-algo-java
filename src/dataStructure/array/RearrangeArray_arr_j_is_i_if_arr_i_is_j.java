/*Given an array, rearrachge it such as arr[j] = i if arr[i] = j
Input: 1 4 0 3 2
Output: 2 0 4 3 1*/ 

package dataStructure.array;

public class RearrangeArray_arr_j_is_i_if_arr_i_is_j {
	
	public static void display(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}

	public static void main(String[] args) {
		int[] arr = {1,4,0,3,2};
		int[] temp = new int[arr.length];
		for(int i = 0; i<arr.length; i++){
			int j = arr[i];
			temp[j] = i;
		}
		System.arraycopy(temp, 0, arr, 0, arr.length);
		display(arr);
	}

}
