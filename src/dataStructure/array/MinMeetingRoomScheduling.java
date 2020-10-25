package dataStructure.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MinMeetingRoomScheduling {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        //Sort the arrays by interval start time
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        //A min heap priority queue to store meeting rooms
        PriorityQueue<Integer> scheduler = new PriorityQueue<>();
        scheduler.add(intervals[0][1]); //Add first meeting room

        for (int i=1; i < intervals.length; i++) {
            if (scheduler.peek() <= intervals[i][0]) {
                scheduler.remove();
            }

            scheduler.add(intervals[i][1]);
        }

        return scheduler.size();
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{0,30},{5,10},{15,20}};
        int result = new MinMeetingRoomScheduling().minMeetingRooms(intervals);
        System.out.println(result);
    }
}
