package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class N131701 { // 연속 부분 수열 합의 개수
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};

        System.out.println(new Solution().solution(elements));
    }

    static class Solution {
        private static Set<Integer> set = new HashSet<>();

        public int solution(int[] elements) {
            calc(1, elements.length, elements);
            return set.size();
        }

        private void calc(int depth, int size, int[] elements) {
            if (depth == size + 1) {
                return;
            }

            int sum = 0;
            for (int i = 0; i < depth; i++) {
                sum += elements[i];
            }
            set.add(sum);

            for (int i = depth; i < size + depth - 1; i++) {
                sum -= elements[(i - depth) % size];
                sum += elements[i % size];

                set.add(sum);
            }

            calc(depth + 1, size, elements);
        }
    }
}
