package dataStructure.array;

import java.util.Arrays;

/*
    We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

    (Here, the distance between two points on a plane is the Euclidean distance.)

    You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

    Example 1:

    Input: points = [[1,3],[-2,2]], K = 1
    Output: [[-2,2]]
    Explanation:
    The distance between (1, 3) and the origin is sqrt(10).
    The distance between (-2, 2) and the origin is sqrt(8).
    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
    We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 */
public class KClosestPointsToOrigin {
    private int getDistance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }

    //This uses Arrays.sort hence O(n log n) run time complexity on average and O(n) space complexity
    //The better approach is kClosest() method implemented at the end
    private int[][] kClosestWithSort(int[][] points, int K) {

        int[] distances = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            distances[i] = getDistance(points[i]);
        }

        Arrays.sort(distances);
        int kthDistance = distances[K-1];

        int[][] result = new int[K][2];
        int index=0;
        for (int i = 0; i < points.length; i++) {
            if (getDistance(points[i]) <= kthDistance) {
                result[index++] = points[i];
            }
        }

        return result;
    }

    private void swap(int[][] points, int i, int j) {
        int temp[] = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private int partition(int[][] points, int start, int end) {
        int pivot = end;
        int boundry = start - 1;

        for (int i = start; i <= end; i++) {
            if (getDistance(points[i]) <= getDistance(points[pivot])) {
                boundry++;
                swap(points, i, boundry);
            }
        }

        return boundry;
    }

    private void sort(int[][] points, int start, int end, int K) {
        if (start >= end) {
            return;
        }

        int boundry = partition(points, start, end);
        int noOfItemsInLeft = boundry - start + 1;
        if (K < noOfItemsInLeft) {
            sort(points, start, boundry-1, K);
        } else if (K > noOfItemsInLeft) {
            sort(points, boundry+1, end, K - noOfItemsInLeft);
        }
    }

    //Time Complexity: O(n) average and O(n2) worst
    //Space Complexity: O(logn) accounting for recursion
    public int[][] kClosest(int[][] points, int K) {
        sort(points, 0, points.length-1, K);
        return Arrays.copyOfRange(points, 0, K);
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{-5,4},{-6,-5},{4,6}};
        int k = 2;
        int[][] result = new KClosestPointsToOrigin().kClosest(input, k);
        
    }
}
