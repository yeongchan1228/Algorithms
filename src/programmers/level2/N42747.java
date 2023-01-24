package programmers.level2;

import java.util.*;

public class N42747 { // H-Index
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};

        System.out.println(new Solution().solution(citations));
    }

    static class Solution {
        private static Map<String, ArrayList<Integer>> hashMap = new HashMap<>();

        public int solution(int[] citations) {
            Arrays.sort(citations);

            for (int i = 0; i < citations.length; i++) {
                int count = citations.length - i;
                if (citations[i] >= count) {
                    return count;
                }
            }

            return 0;
        }
    }
}
