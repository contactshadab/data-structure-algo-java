/*Given an array, find the leaders
A leader is the element that doesn't have any element greater than itself to its right
*/
package dataStructure.array;

import java.util.ArrayList;
import java.util.List;

public class FindLeadersInArray {
	
	/*Start from the right and compare with the max from right
	Time Complexity: O(n)
	Space Complexity: O(1)*/
	public List<Integer> findLeaders(int[] arr){
		List<Integer> leaders = new ArrayList<>();
		int n = arr.length-1;
		int maxFromRight = arr[n];
		leaders.add(arr[n]);
		
		for(int i=n-1; i>=0; i--) {
			if(arr[i] > maxFromRight){
				leaders.add(arr[i]);
				maxFromRight = arr[i];
			}
		}
		return leaders;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{15, 16, 3, 2, 6, 1, 4};
		
		FindLeadersInArray finder = new FindLeadersInArray();
		System.out.println(finder.findLeaders(arr));

	}

}
