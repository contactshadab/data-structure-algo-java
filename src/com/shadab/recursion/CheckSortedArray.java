package com.shadab.recursion;

public class CheckSortedArray {

	boolean isArraySorted(int[] a, int left){
		if(left >= a.length-1)
			return true;
		else
			return a[left] > a[left+1] ? false : isArraySorted(a, left+1);
	}
	
	public static void main(String[] args) {
		CheckSortedArray check = new CheckSortedArray();
		//int arr[] = {10,1,5,100,-99,0};
		int arr[] = {-100,0,20,99};
		System.out.print("Array is sorted - ");
		System.out.print(check.isArraySorted(arr, 0));
	}

}
