package programmers.level2;

import java.util.Arrays;

public class N42885 { // 구명보트
    public static void main(String[] args) {
        int[] people = {70, 50, 80, 50};
        int limit = 100;

        System.out.println(new Solution().solution(people, limit));
    }

    static class Solution {
        public int solution(int[] people, int limit) {
            Arrays.sort(people);

            int answer = 0;
            int left = 0;
            int right = people.length - 1;
            while (right >= left) {
                if (people[left++] + people[right--] > limit) {
                    left--;
                }

                answer++;
            }

            return answer;
        }
    }
}
