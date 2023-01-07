package programmers.level2;

public class N84512 { // 모음사전
    public static void main(String[] args) {
        String word = "AAAAE";
        System.out.println(new Solution().solution(word));
    }

    static class Solution {
        static int answer = 0;
        static int count = 0;
        static boolean isFinish = false;
        static String[] words = {"A", "E", "I", "O", "U"};

        public int solution(String word) {
            dfs(0, new StringBuilder(), word);
            return answer;
        }

        private void dfs(int depth, StringBuilder selected, String word) {
            if (selected.toString().equals(word)) {
                answer = count;
                return;
            }

            if (isFinish || depth == 5) {
                return;
            }

            for (int i = 0; i < words.length; i++) {
                count++;
                selected.append(words[i]);
                dfs(depth + 1, selected, word);
                selected.deleteCharAt(selected.length() - 1);
            }
        }
    }
}
