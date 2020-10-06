package shadab.programs.leetcode;

/*
    Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.

    Example 1:
    Input: "aba"
    Output: True
    Example 2:
    Input: "abca"
    Output: True
    Explanation: You could delete the character 'c'.
    Note:
    The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class IsPalindromWithAtMostOneCharacterRemoval {

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left+1, right) || isPalindrome(s, left, right-1);
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        boolean result = new IsPalindromWithAtMostOneCharacterRemoval().validPalindrome("abca");
        System.out.println(result);
    }

}
