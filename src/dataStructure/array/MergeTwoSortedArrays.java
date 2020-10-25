/*Given two sorted arrays, merge them into a single sorted array

1. Scan both arrays with respective counters i and j. Start counter at 0 for mergedArr
2. IF arr1[i] < arr2[j], copy arr1[i] into mergedArr[counter]
		i++, counter++
3 ELSE copy arr2[j] into mergedArr[counter]
		j++, counter++
4. If reached end of the array, copy all remaining elements of the other array into mergedArr

Time Complexity: O(n)
Space Complexity: O(n)	
*/

package dataStructure.array;

public class MergeTwoSortedArrays {

	public int[] mergeSortedArrays(int[] arr1, int[] arr2) {
		int length = arr1.length + arr2.length;
		int arr[] = new int[length];
		int i=0, j=0, counter=0;
		while(i<arr1.length && j<arr2.length) {
			if(arr1[i] < arr2[j]) {
				arr[counter++] = arr1[i++];
			}else{
				arr[counter++] = arr2[j++];
			}
		}
		
		if(i < arr1.length){
			//Copy remaining elements of array1 into array
			System.arraycopy(arr1, i, arr, counter, arr1.length-i);
		}
		
		if(j < arr2.length){
			//Copy remaining elements of array2 into array
			System.arraycopy(arr2, j, arr, counter, arr2.length-j);
		}
		
		return arr;
	}
	
	public void display(int[] arr){
		for(int i=0; i<arr.length; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1, 3, 5, 7, 9};
		int[] arr2 = {2, 4, 8, 10, 11, 12, 16};
		MergeTwoSortedArrays merge = new MergeTwoSortedArrays();
		int[] arr = merge.mergeSortedArrays(arr1, arr2);
		merge.display(arr);
	}

}
