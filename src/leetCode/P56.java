package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P56 { // Merge Intervals
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        for (int[] answer : merge(intervals)) {
            System.out.println(Arrays.toString(answer));
        }
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            while (i + 1 < intervals.length && intervals[i + 1][0] <= end) {
                i++;
                end = Math.max(end, intervals[i][1]);
            }

            list.add(new int[]{start, end});
        }

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
