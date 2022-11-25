package programmers.level3;

public class N43163 { // 단어 변환
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(new Solution().solution(begin, target, words));
    }

    static class Solution {
        static int answer = Integer.MAX_VALUE;
        static boolean[] visited;

        public int solution(String begin, String target, String[] words) {
            if (!isValid(words, target)) {
                return 0;
            }

            visited = new boolean[words.length];
            dfs(0, begin, target, words);

            return answer;
        }

        private void dfs(int depth, String startStr, String target, String[] words) {
            if (startStr.equals(target)) {
                answer = Math.min(answer, depth);
                return;
            }

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (checkChange(word, startStr) && !visited[i]) {
                    visited[i] = true;
                    dfs(depth + 1, word, target, words);
                    visited[i] = false;
                }
            }
        }

        private boolean checkChange(String word, String target) {
            int cnt = 0;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) != target.charAt(i)) {
                    cnt++;
                }
            }

            if (cnt == 1) {
                return true;
            }
            return false;
        }

        private boolean isValid(String[] words, String target) {
            for (String word : words) {
                if (word.equals(target)) {
                    return true;
                }
            }
            return false;
        }
    }
}
