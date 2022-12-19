package programmers.level3;

import java.util.StringTokenizer;

public class N72414 { // 광고 삽입(누적합)
    public static void main(String[] args) {
        String play_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        System.out.println(new Solution().solution(play_time, adv_time, logs));
    }

    static class Solution {
        public String solution(String play_time, String adv_time, String[] logs) {
            StringTokenizer st = new StringTokenizer(play_time, ":");
            int playTimeSeconds = strToSeconds(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(adv_time, ":");
            int advTimeSeconds = strToSeconds(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            int[] maxSum = new int[playTimeSeconds + 1];
            for (int i = 0; i < logs.length; i++) {
                st = new StringTokenizer(logs[i], "-");
                String startTimeStr = st.nextToken();
                String endTimeStr = st.nextToken();

                st = new StringTokenizer(startTimeStr, ":");
                int startTimeSeconds = strToSeconds(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
                st = new StringTokenizer(endTimeStr, ":");
                int endTimeSeconds = strToSeconds(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

                maxSum[startTimeSeconds]++;
                maxSum[endTimeSeconds]--;
            }

            for (int i = 0; i < playTimeSeconds; i++) {
                maxSum[i + 1] += maxSum[i];
            }

            long max = 0;
            for (int i = 0; i < advTimeSeconds; i++) {
                max += maxSum[i];
            }

            int time = 0;
            long now = max;
            for(int start = 0, end = advTimeSeconds; end < playTimeSeconds; start++, end++){
                now = now - maxSum[start] + maxSum[end];
                if(now > max){
                    time = start + 1;
                    max = now;
                }
            }

            return secondsToStr(time);
        }

        private int strToSeconds(int hours, int minutes, int seconds) {
            return hours * 3600 + minutes * 60 + seconds;
        }

        private String secondsToStr(int seconds) {
            int hours = seconds / 3600;
            seconds %= 3600;
            int minutes = seconds / 60;
            seconds %= 60;
            return String.format("%s" + ":" + "%s" + ":" + "%s", hours < 10 ? "0" + hours : hours,  minutes < 10 ? "0" + minutes : minutes, seconds < 10 ? "0" + seconds : seconds);
        }
    }
}
