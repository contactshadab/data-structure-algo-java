package dataStructure.array;

import java.util.*;

public class SortedSquareArray {
    /*
        Write a program that takes an array of sorted integers ands returns a sorted array of which each item is the square of each item in the input array
        Input: -100, -2, 0, 10, 50 (-10000 < arr[i] < 10000)
        Output: 0, 4, 100, 2500, 10000
     */

    public int[] getSortedSquareArray(int[] items) {
        if (items.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[items.length];
        int left = 0;
        int right = items.length-1;

        for (int i=items.length-1; i>=0; i--) {
            if (items[left]>=0 || Math.abs(items[left]) < items[right]) {
                result[i] = items[right] * items[right];
                right--;
            } else {
                result[i] = items[left] * items[left];
                left++;
            }
        }

        return result;
    }

    public int[] getSortedSquareArrayUsingStackAndQueue(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException();
        }

        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue = new ArrayDeque<>();

        //Traverse the list and add negative numbers in the stack and positive ones in queue
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < 0) {
                stack.push(arr[i] * arr[i]);
            } else {
                queue.add(arr[i] * arr[i]);
            }
        }

        for (int i=0; i<result.length; i++) {
            if (stack.isEmpty()) {
                result[i] = queue.remove();
            } else if (queue.isEmpty()) {
                result[i] = stack.pop();
            } else if (stack.peek() < queue.peek()) {
                result[i] = stack.pop();
            } else {
                result[i] = queue.remove();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SortedSquareArray array = new SortedSquareArray();
        int[] arr = { -20, -10, -2, 1, 5, 20, 20 };

        int[] result = array.getSortedSquareArray(arr);
        System.out.println(Arrays.toString(result));

        int[] result2 = array.getSortedSquareArrayUsingStackAndQueue(arr);
        System.out.println(Arrays.toString(result2));
    }
}
