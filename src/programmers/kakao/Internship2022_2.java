package programmers.kakao;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Internship2022_2 {
    public static void main(String[] args) {
        int[][] queue1 = {{3, 2, 7, 2}, {1, 2, 1, 2}, {1, 1}};
        int[][] queue2 = {{4, 6, 5, 1}, {1, 10, 1, 2}, {1, 5}};

        Solution solution = new Solution();
        for (int i = 0; i < 3; i++) {
            System.out.println(solution.solution(queue1[i], queue2[i]));
        }
    }

    static class Solution {
        public int solution(int[] queue1, int[] queue2) {
            Deque<Integer> a = new ArrayDeque<>();
            Deque<Integer> b = new ArrayDeque<>();
            long totalSumA = initQueue(a, queue1);
            long totalSumB = initQueue(b, queue2);

            long sum = totalSumA + totalSumB;
            if (sum % 2 == 1) {
                return -1;
            }

            sum /= 2;
            int answer = 0;
            int limitCnt = queue1.length * 3;
            while (answer <= limitCnt) {
                if (totalSumA == sum) {
                    break;
                }

                if (totalSumA > sum) {
                    int val = a.poll();
                    b.offer(val);
                    totalSumA -= val;
                    totalSumB += val;
                } else if (totalSumB > sum) {
                    int val = b.poll();
                    a.offer(val);
                    totalSumA += val;
                    totalSumB -= val;
                }

                answer++;
            }

            if (answer > limitCnt) {
                answer = -1;
            }
            return answer;
        }

        private int initQueue(Queue queue, int[] arr) {
            int sum = 0;
            for (int num : arr) {
                queue.offer(num);
                sum += num;
            }

            return sum;
        }
    }
}
