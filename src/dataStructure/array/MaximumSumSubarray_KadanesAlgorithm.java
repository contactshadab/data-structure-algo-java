package dataStructure.array;

public class MaximumSumSubarray_KadanesAlgorithm {
	
	/*Brute force method
	Time Complexity: O(n2)
	Space Complexity: O(1)*/
	public int getMaxSumBruteForce(int[] arr) {
		if(arr.length == 0)
			return Integer.MIN_VALUE;
		
		int maxSum = arr[0];
		
		for(int i=0; i<arr.length; i++){
			int sum = arr[i];
			for(int j = i+1; j<arr.length; j++){
				sum = sum + arr[j];
				
				if(sum > maxSum)
					maxSum = sum;
			}
		}
		return maxSum;
	}
	
	/*Kadane's algorithm variation - Get index as well with max sum
	Time Complexity: O(n)
	Space Complexity: O(1)*/
	public int getMaxSum(int[] arr){
		if(arr.length == 0)
			return Integer.MIN_VALUE;
		
		int globalMax = arr[0];
		int localMax = arr[0];
		int globalStart = 0;
		int globalEnd = 0;
		int localStart = 0;
		
		for(int i = 1; i<arr.length; i++){
			int localEnd = i;
			//At every index checking the local max
			if(arr[i] > arr[i] + localMax){
				//If localSum is the current element, set start to i
				localStart = i;
				localMax = arr[i];
			}
			else
				localMax = arr[i] + localMax;
			
			//Changing globalMax if it is lesser than localMax
			if(globalMax < localMax) {
				globalMax = localMax;
				globalStart = localStart;
				globalEnd = localEnd;
			}
		}
		System.out.println("Start: " + globalStart + ", End: " + globalEnd);
		return globalMax;
	}
	
	public static void main(String[] args) {
		int arr[] = {4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2};
		
		MaximumSumSubarray_KadanesAlgorithm maxSum = new MaximumSumSubarray_KadanesAlgorithm();
		System.out.println(maxSum.getMaxSumBruteForce(arr));
		System.out.println(maxSum.getMaxSum(arr));

	}

}
