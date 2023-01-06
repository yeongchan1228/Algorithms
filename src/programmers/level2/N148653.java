package programmers.level2;

public class N148653 { // 마법의 엘리베이터

    public static void main(String[] args) {
        int storey = 16;
        System.out.println(new Solution().solution(storey));
    }

    static class Solution {
        public int solution(int storey) {
            int save = 0;
            int answer = 0;
            char[] storeyChs = String.valueOf(storey).toCharArray();
            for (int i = storeyChs.length - 1; i >= 0; i--) {
                int val = (storeyChs[i] - '0') + save;

                save = 0;
                if (val > 5) {
                    save = 1;
                    answer += 10 - val;
                    continue;
                } else if (val == 5 && i > 0 && (storeyChs[i - 1] - '0') >= 5) {
                    storeyChs[i - 1]++;
                }

                answer += val;
            }

            return save == 1 ? answer + 1 : answer;
        }
    }
}
