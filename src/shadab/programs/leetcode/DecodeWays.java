package shadab.programs.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
    A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given a non-empty string containing only digits, determine the total number of ways to decode it.

    The answer is guaranteed to fit in a 32-bit integer.



    Example 1:

    Input: s = "12"
    Output: 2
    Explanation: It could be decoded as "AB" (1 2) or "L" (12).
    Example 2:

    Input: s = "226"
    Output: 3
    Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
    Example 3:

    Input: s = "0"
    Output: 0
    Explanation: There is no character that is mapped to a number starting with '0'. We cannot ignore a zero when we face it while decoding. So, each '0' should be part of "10" --> 'J' or "20" --> 'T'.
    Example 4:

    Input: s = "1"
    Output: 1


    Constraints:

    1 <= s.length <= 100
    s contains only digits and may contain leading zero(s).
 */

public class DecodeWays {
    Map<Integer, Integer> memo = new HashMap<>();

    private boolean isValid(String s, int start) {
        return Integer.parseInt(s.substring(start, start+2)) <= 26;
    }

    private int decode(String sub, int start) {
        int count = 0;

        //If reached end of string count it 1
        if (start == sub.length()) {
            return 1;
        }

        //If starts with 0, break the chain
        if (sub.charAt(start) == '0') {
            return 0;
        }

        //If there is only one digit go back
        if (start == sub.length()-1) {
            return 1;
        }

        //If we already know the answer dont search further
        if (memo.containsKey(start)) {
            return memo.get(start);
        }

        count = decode(sub, start+1);
        if (isValid(sub, start)) {
            count = count + decode(sub, start+2);
        }

        //Save for memoization
        memo.put(start, count);

        return count;
    }

    //Run time complexity O(n)
    //Space complexity O(n)
    public int numDecodings(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        return decode(s, 0);
    }

    public static void main(String[] args) {
        int result = new DecodeWays().numDecodings("226");
        System.out.println(result);
    }
}
