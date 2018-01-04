package com.geeksforgeeks.ds.array;

public class ArrayRotation {
	
	public void shiftLeft(int[] arr, int n){
		int temp = arr[0];
		for(int i=1; i<n; i++){
			arr[i-1] = arr[i];
		}
		arr[n-1] = temp;
	}
	
	//Time complexity = O(n*d)
	//Space complexity = O(1)
	public int[] rotate2(int[] arr, int d, int n){
		for(int i=0; i<d; i++){
			shiftLeft(arr, n);
		}
		return arr;
	}
	
	//Time complexity = O(n)
	//Space complexity = O(d)
	public int[] rotate1(int[] arr, int d, int n){
		//Create a temporary array of length d and fill it with first d values of arr
		int[] temp = new int[d];
		for(int i=0; i<d; i++){
			temp[i] = arr[i];
		}
		display(temp);
		
		//Copy the array values from d to n-1 positions into first n-d length of the array 
		for(int i=0; i<n-d; i++){
			arr[i] = arr[i+d];
		}
		display(arr);
		
		//Copy the temp array into last d positions of the array
		for(int i=0; i<d; i++){
			arr[n-d+i] = temp[i];
		}
		return arr;
	}
	
	public void display(int[] arr){
		for(int i: arr){
			System.out.print(i + " ");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6, 7};
		int d = 2, n = 7;
		ArrayRotation rotation = new ArrayRotation();
		rotation.display(arr);
		rotation.rotate1(arr, d, n);
		rotation.display(arr);
	}

}
