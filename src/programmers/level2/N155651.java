package programmers.level2;

import java.util.StringTokenizer;

public class N155651 { // 호텔 대실
    public static void main(String[] args) {
        String[][] book_time = {{"09:10", "10:10"}, {"10:20", "12:20"}};
        System.out.println(new Solution().solution(book_time));
    }

    static class Solution {
        static final int MAX_MINUTES = 1450;

        public int solution(String[][] book_time) {
            int[] useRooms = new int[MAX_MINUTES];

            int[][] bookTimes = new int[book_time.length][2];
            for (int i = 0; i < book_time.length; i++) {
                String[] bookTimeStrs = book_time[i];
                bookTimes[i][0] = calcMinutes(bookTimeStrs[0]);
                bookTimes[i][1] = calcMinutes(bookTimeStrs[1]);
            }

            for (int i = 0; i < bookTimes.length; i++) {
                int[] bookTime = bookTimes[i];
                useRooms[bookTime[0]]++;
                useRooms[bookTime[1] + 10]--;
            }

            int answer = 0;
            for (int i = 1; i < MAX_MINUTES; i++) {
                useRooms[i] += useRooms[i - 1];

                if (useRooms[i] > answer) {
                    answer = useRooms[i];
                }
            }

            return answer;
        }

        private int calcMinutes(String timeStr) {
            StringTokenizer st = new StringTokenizer(timeStr, ":");
            return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        }
    }

}