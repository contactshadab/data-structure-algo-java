package com.shadab.algorithms;

public class QuickSort {
	
	public void swap(int[] array, int firstIndex, int secondIndex){
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
		array[secondIndex] = temp;
	}
	
	public int partitionAsc(int[] array, int p, int r){
		int q = p;
		for(int i=p; i<r; i++){
			if(array[i] <= array[r]){
				swap(array, i, q);
				q++;
			}
		}
		swap(array, r, q);
		return q;
	}
	
	public int partitionDesc(int[] array, int p, int r){
		int q = r;
		for(int j=r; j>p; j--){
			if(array[j] <= array[p]){
				swap(array, j, q);
				q--;
			}
		}
		swap(array, p, q);
		return q;
	}
	
	public void quickSortAsc(int[] array, int p, int r){
		if(p < r){
			int pivot = partitionAsc(array, p, r);
			quickSortAsc(array, p, pivot-1);
			quickSortAsc(array, pivot+1, r);
		}
		
	}
	
	public void quickSortDesc(int[] array, int p, int r){
		if(p < r){
			int pivot = partitionDesc(array, p, r);
			quickSortDesc(array, p, pivot-1);
			quickSortDesc(array, pivot+1, r);
		}
		
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
		QuickSort sort = new QuickSort();
		System.out.println("Original array:");
		sort.displayArray(array);
		sort.quickSortAsc(array, 0, array.length-1);
		System.out.println("Sorted array in ascending order:");
		sort.displayArray(array);
		sort.quickSortDesc(array, 0, array.length-1);
		System.out.println("Sorted array in descending order:");
		sort.displayArray(array);
	}

}
