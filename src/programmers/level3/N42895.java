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
            List<Set<Integer>> setList = new ArrayList<>();
            for (int i = 0; i < 9; i++) {
                setList.add(new HashSet<>());
            }
            setList.get(1).add(N);

            if (N == number) {
                return 1;
            }

            for (int i = 2; i < 9; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    addSet(setList.get(i), setList.get(i - j), setList.get(j));
                    addSet(setList.get(i), setList.get(j), setList.get(i - j));
                }

                setList.get(i).add(Integer.parseInt(String.valueOf(N).repeat(i)));
                for (int val : setList.get(i)) {
                    if (val == number) {
                        return i;
                    }
                }
            }

            return -1;
        }

        private void addSet(Set<Integer> base, Set<Integer> first, Set<Integer> second) {
            for (int f : first) {
                for (int p : second) {
                    base.add(f + p);
                    base.add(f - p);
                    base.add(f * p);
                    if (p == 0) {
                        continue;
                    }
                    base.add(f / p);
                }
            }
        }
    }
}
