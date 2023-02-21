package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N42586 { // 기능개발
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        for (int answer : new Solution().solution(progresses, speeds)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public int[] solution(int[] progresses, int[] speeds) {
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < progresses.length; i++) {
                queue.offer((int) Math.ceil((100 - progresses[i]) / (double) speeds[i]));
            }

            List<Integer> answer = new ArrayList<>();
            while (!queue.isEmpty()) {
                int finishCnt = 1;
                int nowDay = queue.poll();

                while (!queue.isEmpty() && queue.peek() <= nowDay) {
                    queue.poll();
                    finishCnt++;
                }

                answer.add(finishCnt);
            }

            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}
