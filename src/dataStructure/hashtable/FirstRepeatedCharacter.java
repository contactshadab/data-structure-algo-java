package dataStructure.hashtable;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedCharacter {

    /*

    input: Can you find this

    Algo:
    Map - t = 2
        - h = 1
        - i = 2
     */

    // Run time Complexity: O(n)
    public Character find(String input) {
        if (input.length() == 0) {
            throw new IllegalArgumentException();
        }

        Set<Character> set = new HashSet<>();
        for (char ch: input.toCharArray()) {

            //Ignore space
            if (ch == ' ') {
                continue;
            }

            if (set.contains(ch)) {
                return ch;
            }

            set.add(ch);
        }

        return null;
    }

    public static void main(String[] args) {
        FirstRepeatedCharacter finder = new FirstRepeatedCharacter();
        System.out.println(finder.find("Can you find this"));
        System.out.println(finder.find("c"));
        System.out.println(finder.find("cc"));
//        System.out.println(finder.find(""));    //  IllegalArgumentException

    }

}
