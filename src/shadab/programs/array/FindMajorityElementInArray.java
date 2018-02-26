package shadab.programs.array;

import java.util.HashMap;
import java.util.Map;

public class FindMajorityElementInArray {
	
	/*Using HashTable to store elements and its occurance
	Time Complexity: O(n)
	Space Complexity: O(n)*/
	public int findByHashTableMethod(int[] arr) {
		int maxLimitStart = arr.length/2;
		Map<Integer,Integer> map = new HashMap<>();
		for(int i = 0; i<arr.length; i++){
			if(map.containsKey(arr[i])){
				map.put(arr[i], map.get(arr[i])+1);
				
				if(map.get(arr[i]) > maxLimitStart)
					return arr[i];
			}else{
				map.put(arr[i], 1);
			}
		}
		return Integer.MIN_VALUE;
	}
	
	/*Using Moor Voting algorith
	Time Complexity: O(n)
	Space Complexity: O(1)*/
	public int findByMoorAlgorithm(int[] arr){
		int majorityElement = arr[0];
		int count = 1;
		for(int i=1; i<arr.length; i++){
			if(arr[i] == majorityElement){
				count++;
			}else{
				count--;
				if(count == 0){
					majorityElement = arr[i];
				}
			}
		}
		count = 0;
		//Verify if the majority element candidate is actually majority element
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == majorityElement)
				count++;
		}
		if(count > arr.length/2)
			return majorityElement;
		else
			return Integer.MIN_VALUE;
	}

	public static void main(String[] args) {
		int a[] = {2,2,2,5,5,2,3,3,2};
		
		FindMajorityElementInArray finder = new FindMajorityElementInArray();
		System.out.println(finder.findByHashTableMethod(a));
		
		System.out.println(finder.findByMoorAlgorithm(a));

	}

}
