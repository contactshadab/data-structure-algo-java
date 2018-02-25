package shadab.programs.array;

import java.util.Arrays;

public class FindPairsWithGivenSum {
	
	/*Method: 1
	Sort the array first, add elements at both ends and compare with desired sum
	Assumption: No duplicate array
	Time Complexity: O(nlogn)/O(n2) depending on sort
	Space Complexity: O(1)*/
	public int findBySorting(int arr[], int desiredSum) {
		int count = 0;
		//Sort the array
		Arrays.sort(arr);
		
		int left = 0;
		int right = arr.length-1;
		while(left < right) {
			int sum = arr[left] + arr[right];
			if(sum == desiredSum){
				System.out.println(arr[left] + " - " + arr[right]);
				count++;
				left++;
			}else if(sum < desiredSum){
				left++;
			}else{
				right--;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{1, 9, 2, 3, 7, 10};
		FindPairsWithGivenSum finder = new FindPairsWithGivenSum();
		System.out.println(finder.findBySorting(arr, 11));
	}

}
