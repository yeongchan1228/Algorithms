package programmers.level3;

import java.util.*;

public class N81303 { // 표 편집
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"};

        System.out.println(new Solution().solution(n, k ,cmd));
    }

    static class Solution {
        public String solution(int n, int k, String[] cmd) {
            Stack<Integer> removeIdx = new Stack<>();

            int size = n;
            for (String cmdStr : cmd) {
                String[] splits = cmdStr.split(" ");

                switch (splits[0]) {
                    case "D":
                        k += Integer.parseInt(splits[1]);
                        break;
                    case "U":
                        k -= Integer.parseInt(splits[1]);
                        break;
                    case "C":
                        removeIdx.push(k);
                        size--;
                        if (k == size) {
                            k--;
                        }
                        break;
                    case "Z":
                        if (removeIdx.pop() <= k) {
                            k++;
                        }
                        size++;
                        break;
                }
            }

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < n; i++) {
                answer.append("O");
            }

            for (int idx : removeIdx) {
                answer.setCharAt(idx, 'X');
            }

            return answer.toString();
        }
    }
}
