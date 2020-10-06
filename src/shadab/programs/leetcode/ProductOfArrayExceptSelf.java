package shadab.programs.leetcode;

import java.util.Arrays;

/*
    Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

    Example:

    Input:  [1,2,3,4]
    Output: [24,12,8,6]
    Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.

    Note: Please solve it without division and in O(n).

    Follow up:
    Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        /*
        2 6 5 7 3
        (2) => 1* product of all numbers to its right
        (6) => product of all nos to its left * product of all nos to its right
        ...
        (3) => product of all nos to its left * 1

        Traverse the array twice - left to right and right to left
        In first traversal store the product of all elements to its left somewhere (array? with same index)

        Run time Complexity: O(n)
        Space complexity: O(n)
        */
        int results[] = new int[nums.length];
        int productsOfLeft[] = new int[nums.length];
        //Traverse the array left to right
        //and keep updating product of all items in its left
        productsOfLeft[0] = 1;
        for (int i=1; i < nums.length; i++) {
            productsOfLeft[i] = nums[i-1] * productsOfLeft[i-1];
        }

        int productsOfRight = 1;
        results[nums.length-1] = productsOfLeft[nums.length-1];
        //Traverse the array right to left
        for (int i=nums.length-2; i >= 0; i--) {
            productsOfRight = productsOfRight * nums[i+1];
            results[i] = productsOfLeft[i] * productsOfRight;
        }

        return results;
    }

    private int getLeftProduct(int[] nums, int index) {
        if (index == 0) {
            return 1;
        }

        return getLeftProduct(nums, index-1) * nums[index-1];
    }

    private int getRightProduct(int[] nums, int index) {
        if (index == nums.length-1) {
            return 1;
        }

        return getRightProduct(nums, index+1) * nums[index+1];
    }

    public int[] productExceptSelfInConstantSpaceComplexity(int[] nums) {
        /*
            2 6 5 7 3

         */

        int results[] = new int[nums.length];

        for (int i=0; i<nums.length; i++) {
            results[i] = getLeftProduct(nums, i) * getRightProduct(nums, i);
        }

        return results;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();
        int[] input = {1,2,3,4};
        int[] output1 = product.productExceptSelf(input);
        System.out.println(Arrays.toString(output1));
        int[] output2 = product.productExceptSelfInConstantSpaceComplexity(input);
        System.out.println(Arrays.toString(output2));
    }

}
