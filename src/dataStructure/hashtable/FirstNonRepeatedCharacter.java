package dataStructure.hashtable;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {

    /*
        Input: this is the first non repeated character
        Output: f

        Algorithm:
        Use HashTable and store all characters and their occurance
        t = how many times it is repeated
        h =
        i =
        s =

        Final lookup - Iterate the characters from the input once again and find first character that is also present in map with count 1
     */

    //O(n)
    public Character find(String str) {
        if (str.length() == 0) {
            throw new IllegalArgumentException();
        }

        Map<Character, Integer> map = new HashMap<>();

        //Store each character and their occurance count in a Hash Table
        char[] chars = str.toCharArray();
        for (char ch: chars) {
            int count = map.containsKey(ch)? map.get(ch): 0;
            map.put(ch,count+1);
        }

        //Lookup the map again to find the first character
        for (char ch: chars) {
            if (map.get(ch) == 1) {
                return ch;
            }
        }

        //If we are hear means there is no character repeated only once
        return null;
    }

    public static void main(String[] args) {
        FirstNonRepeatedCharacter finder = new FirstNonRepeatedCharacter();
        System.out.println(finder.find("this is the first non repeated character"));
        System.out.println(finder.find(""));    //IllegalArgumentException
    }
}
