package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class N131701 { // 연속 부분 수열 합의 개수
    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};

        System.out.println(new Solution().solution(elements));
    }

    static class Solution {
        public int solution(int[] elements) {
            int size = elements.length;
            Set<Integer> answer = new HashSet<>();
            for(int i = 0; i < size; i++) {
                int idx = i;
                int sum = 0;
                for (int j = 0; j < size; j++) {
                    sum += elements[idx++ % size];
                    answer.add(sum);
                }
            }

            return answer.size();
        }
    }
}
