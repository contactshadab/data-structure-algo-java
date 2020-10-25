package dataStructure.hashtable;

import java.util.*;

public class MostRepeatedItemInArray {

    /*
      Input: [1, 2, 2, 3, 3, 3, 4]
      Output: 3
      Constraint: First maximum occurance number will be returned, if multiple found

      HashTable: int(item), int(count)
      1=1
      2=2
      3=3
      4=1
     */

    //Run time Complexity: O(n)
    public int getMostRepeated(int[] items) {
        if (items.length == 0) {
            throw new IllegalArgumentException();
        }

        //Populate the map with all items and their occurance count
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item: items) {
            int value = map.containsKey(item)? map.get(item): 0;
            map.put(item, value+1);
        }

        int count = 0;
        int item = items[0];
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() > count) {
                item = entry.getKey();
                count = entry.getValue();
            }
        }

        return item;
    }

    public static void main(String[] args) {
        MostRepeatedItemInArray finder = new MostRepeatedItemInArray();
        System.out.println(finder.getMostRepeated(new int[]{1, 2, 2, 3, 3, 3, 4, 1}));
    }

}
