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

	public static void main(String[] args) {
		int a[] = {2, 2,2,2,2,5,5,2,3,3};
		
		FindMajorityElementInArray finder = new FindMajorityElementInArray();
		System.out.println(finder.findByHashTableMethod(a));

	}

}
