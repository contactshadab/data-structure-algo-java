package com.shadab.algorithms;

public class InsertionSort {
	
	public void swap(int[] arr, int left, int right){
		int temp = arr[left];
		arr[left] = arr[right];
		arr[right] = temp;
	}
	
	public void displayArray(int[] array){
		for(int i: array){
			System.out.print(i + ", ");
		}
		System.out.print("\n");
	}
	
	public void doInsertionSort(int[] arr){
		for(int i=0; i<arr.length; i++){
			int currentElement = i;
			for(int j=i-1; j>=0; j--){
				if(arr[currentElement] < arr[j]){
					swap(arr, j, currentElement);
					currentElement = j;
				}else
					break;
			}
		}
	}

	public static void main(String[] args) {
		int[] arr = {10, 92, 0, -2, 733, -8383, 8391, 0, 2, 87};
		InsertionSort sort = new InsertionSort();
		sort.displayArray(arr);
		sort.doInsertionSort(arr);
		sort.displayArray(arr);
	}

}
