package programmers.level3;

import java.util.*;

public class N42895 { // N으로 표현
    public static void main(String[] args) {
        int N = 5;
        int number = 12;

        System.out.println(new Solution().solution(N, number));
    }

    static class Solution {
        public int solution(int N, int number) {
            List<Set<Integer>> list = getList(N);

            if (list.get(1).contains(number)) {
                return 1;
            }

            for (int i = 2; i <= 8; i++) {
                list.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
                for (int j = 1; j <= i / 2; j++) {
                    calc(list.get(i), list.get(i - j), list.get(j));
                    calc(list.get(i), list.get(j), list.get(i - j));
                }

                if (list.get(i).contains(number)) {
                    return i;
                }
            }


            return -1;
        }

        private void calc(Set<Integer> base, Set<Integer> firstSet, Set<Integer> secondSet) {
            for (int first : firstSet) {
                for (int second : secondSet) {
                    base.add(first + second);
                    base.add(first - second);
                    base.add(first * second);

                    if (second == 0) {
                        continue;
                    }

                    base.add(first / second);
                }
            }
        }

        private List<Set<Integer>> getList(int N) {
            List<Set<Integer>> list = new ArrayList<>();
            for (int i = 0; i <= 8; i++) {
                list.add(new HashSet<Integer>());
            }

            list.get(1).add(N);

            return list;
        }
    }
}
