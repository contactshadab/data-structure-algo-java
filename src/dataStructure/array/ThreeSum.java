package dataStructure.array;

import java.util.*;

public class ThreeSum {

    private List<Integer> checkTwoSum(int[] nums, int index, int target) {
        Set<Integer> set = new HashSet<>();
        set.add(nums[index]);
        for (int i = index+1; i < nums.length-1; i++) {
            int complement = target - nums[i];
            if (set.contains(complement)) {
                List<Integer> result = new ArrayList<>();
                result.add(nums[i]);
                result.add(complement);
                return result;
            } else {
                set.add(nums[i]);
            }
        }

        return null;
    }

    //Run time complexity: O(n2)
    //Space complexity: O(n)
    public List<List<Integer>> threeSumNoSortApproach(int[] nums) {
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        for (int i = 0; i < nums.length-2; i++) {

            //Skip duplicates
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }

            List<Integer> result = checkTwoSum(nums, i+1, 0-nums[i]);
            if (result != null) {
                result.add(nums[i]);
                if (!set.contains(result)) {
                    set.add(result);
                }

            }
        }

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        list.addAll(set);
        return list;
    }

    //Run time complexity: O(n2)
    //Space complexity: O(log n) to O(n) depending on sort algorithm
    private List<List<Integer>> threeSumSortApproach(int[] nums) {
        //Sort the array so that we can use two pointer solution
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i] > 0) {
                //If I have passed all negatives and zeros I am not going to find any number that sums to 0
                break;
            }

            //Skip the duplicates
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int sumNeeded = -1 * nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == sumNeeded) {
                    //Add triplet to result
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    //Increase left untill we find a different number
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left-1]);

                    right--;
                } else if (sum > sumNeeded) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = threeSumNoSortApproach(nums);
        return result;
    }

    public static void main(String[] args) {
        int[] input = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> result = new ThreeSum().threeSum(input);
        System.out.println(result);
    }
}
