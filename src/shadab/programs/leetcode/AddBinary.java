package shadab.programs.leetcode;

/*
    Given two binary strings, return their sum (also a binary string).
    The input strings are both non-empty and contains only characters 1 or 0.

    Example 1:

    Input: a = "11", b = "1"
    Output: "100"
    Example 2:

    Input: a = "1010", b = "1011"
    Output: "10101"

    Constraints:

    Each string consists only of '0' or '1' characters.
    1 <= a.length, b.length <= 10^4
    Each string is either "0" or doesn't contain any leading zero.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        /*
        a =  1010
        b =  1011
        */
        String result = "";
        int carry = 0;
        int count = a.length() > b.length()? a.length(): b.length();
        for (int i = 0; i<count; i++) {
            int currentA = a.length()-i-1 >= 0? a.charAt(a.length()-i-1) == '0'? 0: 1: 0;
            int currentB = b.length()-i-1 >= 0? b.charAt(b.length()-i-1) == '0'? 0: 1: 0;
            int sum = currentA + currentB + carry;
            if (sum == 2) {
                sum = 0;
                carry = 1;
            } else if (sum ==3) {
                sum = 1;
                carry = 1;
            } else {
                carry = 0;
            }
            result = sum + result;
        }

        if (carry > 0) {
            result = carry + result;
        }

        return result;
    }
}
