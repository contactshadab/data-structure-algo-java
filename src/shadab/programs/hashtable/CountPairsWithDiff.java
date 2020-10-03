package shadab.programs.hashtable;

import java.util.HashSet;
import java.util.Set;

public class CountPairsWithDiff {
    /*
        Given an array of integers, count the number of unique pairs of integers that have difference k.
        Input: [1, 7, 5, 9, 2, 12, 3] K=2
        Output: 4
        [(1, 3), (3, 5), (5, 7), (7, 9)]
     */

    // Run time Complexity: O(n)
    public int countPairsWithDiff(int[] items, int diff) {
        Set<Integer> set = new HashSet<>();
        for (int item: items) {
            set.add(item);
        }

        int count = 0;
        for (int item: items) {
            if (set.contains(item+diff)) {
                count++;

            }

            if (set.contains(item-diff)) {
                count++;
            }

            set.remove(item);
        }

        return count;
    }

    public static void main(String[] args) {
        CountPairsWithDiff counter = new CountPairsWithDiff();
        int result = counter.countPairsWithDiff(new int[]{1, 7, 5, 9, 2, 12, 3}, 2);
        System.out.println(result);
    }
}
