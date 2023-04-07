package programmers.level2;

import java.io.IOException;
import java.util.*;

public class N176962 { // 과제 진행하기
    public static void main(String[] args) throws IOException {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        for (String answer : new Solution().solution(plans)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public String[] solution(String[][] plans) {
            Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));

            int[][] times = new int[plans.length][plans[0].length];
            for (int i = 0; i < plans.length; i++) {
                times[i][0] = timeToInt(plans[i][1]);
                times[i][1] = Integer.parseInt(plans[i][2]);
            }

            List<String> answer = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < plans.length - 1; i++) {
                int totalTime = times[i][0] + times[i][1];
                int nextStartTime = times[i + 1][0];

                if (totalTime <= nextStartTime) {
                    answer.add(plans[i][0]);

                    int restTime = nextStartTime - totalTime;
                    while (restTime > 0 && !stack.isEmpty()) {
                        int prevTime = times[stack.peek()][1];
                        int diff = restTime - prevTime;
                        if (diff >= 0) {
                            restTime = diff;
                            answer.add(plans[stack.pop()][0]);
                        } else {
                            times[stack.peek()][1] -= restTime;
                            break;
                        }
                    }
                } else {
                    times[i][1] = totalTime - nextStartTime;
                    stack.push(i);
                }
            }
            answer.add(plans[plans.length - 1][0]);

            while (!stack.isEmpty()) {
                answer.add(plans[stack.pop()][0]);
            }

            return answer.toArray(String[]::new);
        }

        private int timeToInt(String time) {
            StringTokenizer st = new StringTokenizer(time, ":");
            return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
        }
    }

}
