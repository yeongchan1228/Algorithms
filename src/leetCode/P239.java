package leetCode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P239 { // Sliding Window Maximum
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        for (int answer : maxSlidingWindow(nums, k)) {
            System.out.println(answer);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        int idx = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);
            if (i >= k - 1) {
                answer[idx++] = nums[deque.peek()];
            }
        }
        return answer;
    }
}
