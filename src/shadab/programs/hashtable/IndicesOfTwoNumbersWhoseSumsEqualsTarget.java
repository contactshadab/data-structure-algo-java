package shadab.programs.hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IndicesOfTwoNumbersWhoseSumsEqualsTarget {
    /*
    Given an array of integers, return indices of the two numbers such that they add up to a specific target.
    Each input has exactly one solution, and you may not use the same element twice
    Input: [2, 7, 11, 15] - target = 9
    Output: [0, 1] (because 2 + 7 = 9)
     */

    //Complexity: O(n)
    public int[] findIndicesWhoseSumIsEqualTo(int sum, int[] numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i=0; i<numbers.length; i++) {
            int target = sum-numbers[i];
            if (map.containsKey(target)) {
                result[0] = i;
                result[1] = map.get(target);
                return result;
            }
            map.put(numbers[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        IndicesOfTwoNumbersWhoseSumsEqualsTarget finder = new IndicesOfTwoNumbersWhoseSumsEqualsTarget();
        int[] input =  {2, 7, 11, 15};
        System.out.println(Arrays.toString(finder.findIndicesWhoseSumIsEqualTo(7, input)));
        System.out.println(Arrays.toString(finder.findIndicesWhoseSumIsEqualTo(9, input)));
        int[] input2 =  {-10, 20, 30, -40};
        System.out.println(Arrays.toString(finder.findIndicesWhoseSumIsEqualTo(20, input2)));
    }
}
