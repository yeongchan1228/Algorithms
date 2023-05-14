package leetCode;

import java.util.List;
import java.util.Stack;

public class P636 { // Exclusive Time of Functions
    public static void main(String[] args) {
        int n = 2;
        List<String> logs = List.of("0:start:0","1:start:2","1:end:5","0:end:6");
        for (int answer : exclusiveTime(n, logs)) {
            System.out.println(answer);
        }
    }

    public static int[] exclusiveTime(int n, List<String> logs) {
        Stack<Info> stack = new Stack<>();

        int prevTime = 0;
        int[] answer = new int[n];
        for (String log : logs) {
            String[] splits = log.split(":");
            int idx = Integer.parseInt(splits[0]);
            String action = splits[1];
            int time = Integer.parseInt(splits[2]);

            Info info = new Info(idx, time);
            if (!stack.isEmpty()) {
                answer[stack.peek().idx] += time - prevTime;
            }
            prevTime = time;
            if (action.equals("start")) {
                stack.push(info);
            } else {
                answer[stack.pop().idx]++;
                prevTime++;
            }
        }

        return answer;
    }

    private static class Info {
        int idx;
        int time;

        public Info(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }
}
