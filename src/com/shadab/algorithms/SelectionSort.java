package com.shadab.algorithms;

public class SelectionSort {

	public void swap(int[] array, int firstIndex, int secondIndex){
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}
	
	public int lowestNumber(int[] array, int p, int r){
		int lowestIndex = p;
		for(int i=p; i<=r; i++){
			if(array[i] < array[lowestIndex])
				lowestIndex = i;
		}
		return lowestIndex;
	}
	
	public void selectionSort(int[] array, int i, int j){
		if(i > j)
			return;
		int lowestIndex = lowestNumber(array, i, j);
		swap(array, i, lowestIndex);
		selectionSort(array, i+1, j);
	}
	
	public void displayArray(int[] array){
		for(int i: array){
			System.out.print(i + ", ");
		}
		System.out.print("\n");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {10, 92, 0, -2, 733, -8383, 8391, 0, 2, 87};
		SelectionSort sort = new SelectionSort();
		System.out.println("Original array:");
		sort.displayArray(array);
		sort.selectionSort(array, 0, array.length-1);
		System.out.println("Sorted array in ascending order:");
		sort.displayArray(array);
	}

}
