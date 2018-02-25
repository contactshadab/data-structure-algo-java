/*
 * Given an array of consecutive natural numbers from 1 to n, find the missing number
 * */

package shadab.programs.array;

public class FindMissingNumberInArray_ConsecutiveSequence {
	
	/*Method: 1
	Get the sum of n natural numbers and substract it with the sum of all elements present in Array*/
	public int findBySumMethod(int[] arr, int n) {
		int sumOfnNumbers = n * (n+1) / 2;
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sumOfnNumbers - sum;
	}
	
	public int findByXorMethod(int[] arr, int n){
		int xorOfnNumbers = 0;
		int xor = 0;
		for(int i=1; i<=n; i++) {
			xorOfnNumbers ^= i;
		}
		for(int i = 0; i < arr.length; i++) {
			xor ^= arr[i];
		}
		return xorOfnNumbers ^ xor;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 7, 8, 9};
		
		FindMissingNumberInArray_ConsecutiveSequence finder = new FindMissingNumberInArray_ConsecutiveSequence();
		int num = finder.findBySumMethod(arr, 9);
		System.out.println(num);
		
		System.out.println(finder.findByXorMethod(arr, 9));

	}

}
