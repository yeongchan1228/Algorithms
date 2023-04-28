package programmers.level1;

public class N160586 { // 대충 만든 자판
    public static void main(String[] args) {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD","AABB"};
        for (int answer : new Solution().solution(keymap, targets)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public int[] solution(String[] keymap, String[] targets) {
            int[] alpha = new int[26];

            for (String key : keymap) {
                for (int i = 0; i < key.length(); i++) {
                    int idx = key.charAt(i) - 'A';
                    if (alpha[idx] == 0) {
                        alpha[idx] = i + 1;
                    } else {
                        alpha[idx] = Math.min(alpha[idx], i + 1);
                    }
                }
            }

            int pos = 0;
            int[] answer = new int[targets.length];
            for (String target : targets) {
                int sum = 0;
                for (int i = 0; i < target.length(); i++) {
                    int idx = target.charAt(i) - 'A';

                    if (alpha[idx] == 0) {
                        sum = -1;
                        break;
                    }

                    sum += alpha[idx];
                }

                answer[pos++] = sum;
            }

            return answer;
        }
    }
}
