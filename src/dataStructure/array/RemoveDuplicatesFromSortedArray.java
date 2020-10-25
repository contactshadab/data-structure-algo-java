/*Given a sorted array, remove duplicate elements from it

Algo:
1. Keep two pointers i and j, both at beginning of the array
2. Scan the array from first element till the end, keep moving j
3. If arr[i] == arr[j] Then increase j
   Else increase i and then arr[i] = arr[j]
Time Complexity: O(n)
Space Complexity: O(1)*/

package dataStructure.array;

public class RemoveDuplicatesFromSortedArray {
	
	public int removeDuplicate(int[] arr){
		int i, j;
		for(i=0, j=0; j < arr.length; j++){
			if(arr[i] != arr[j]){
				i++;
				arr[i] = arr[j];
			}
		}
		return i;
	}
	
	public void display(int[] arr, int index){
		for(int i=0; i<=index; i++)
			System.out.print(arr[i] + " ");
		
		System.out.println();
	}

	public static void main(String[] args) {
		int arr[] = new int[]{1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 5};
		RemoveDuplicatesFromSortedArray remove = new RemoveDuplicatesFromSortedArray();
		remove.display(arr, arr.length-1);
		int index = remove.removeDuplicate(arr);
		remove.display(arr, index);
	}

}
