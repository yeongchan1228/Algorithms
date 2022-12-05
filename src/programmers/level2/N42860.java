package programmers.level2;

public class N42860 { // 조이스틱
    public static void main(String[] args) {
        System.out.println(new Solution().solution("JEROEN"));
    }

    static class Solution {
        public int solution(String name) {
            int answer = 0;
            int len = name.length();
            int moveCnt = len - 1;
            char[] names = name.toCharArray();
            for (int i = 0; i < len; i++) {
                char nowChar = names[i];
                if (nowChar < 'N') {
                    answer += nowChar - 'A';
                } else {
                    answer += 'Z' - nowChar + 1;
                }

                int idxA = i + 1;
                while (idxA < len && names[idxA] == 'A') {
                    idxA++;
                }

                moveCnt = Math.min(moveCnt, i * 2 + (len - idxA));
                moveCnt = Math.min(moveCnt, (len - idxA) * 2 + i);
            }

            return answer + moveCnt;
        }
    }
}
