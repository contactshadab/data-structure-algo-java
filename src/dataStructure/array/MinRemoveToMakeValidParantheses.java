package dataStructure.array;

public class MinRemoveToMakeValidParantheses {

    /*
        Given a string s of '(' , ')' and lowercase English characters.
        Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid string.

        Formally, a parentheses string is valid if and only if:

        It is the empty string, contains only lowercase characters, or
        It can be written as AB (A concatenated with B), where A and B are valid strings, or
        It can be written as (A), where A is a valid string.


        Example 1:

        Input: s = "lee(t(c)o)de)"
        Output: "lee(t(c)o)de"
        Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
     */
    public String minRemoveToMakeValid(String s) {
        /*
         s = "lee(t(c())o)de)"
        */
        StringBuffer sb = new StringBuffer();
        int countOpening = 0;
        for (char ch: s.toCharArray()) {
            if (ch == '(') {
                countOpening++;
            } else if (ch == ')') {
                if (countOpening <= 0) {
                    continue;
                }

                countOpening--;
            }
            sb.append(ch);
        }

        int count = 0;
        for (int i = sb.length()-1; i >= 0 && count < countOpening; i--) {
            if (sb.charAt(i) == '(') {
                sb.deleteCharAt(i);
                count++;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String result = new MinRemoveToMakeValidParantheses().minRemoveToMakeValid("lee(t(c)o)de)");
        System.out.println(result);
    }
}
