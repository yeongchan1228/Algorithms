package programmers.level1;

public class N133499 { // 옹알이 (2)
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa"};
        System.out.println(new Solution().solution(babbling));
    }

    static class Solution {
        private static final String[] WORDS = {"aya", "ye", "woo", "ma"};

        public int solution(String[] babbling) {
            int answer = 0;
            for (String bab : babbling) {
                for (int i=0; i<WORDS.length; i++) {
                    bab = bab.replaceAll(WORDS[i], String.valueOf(i));
                }

                Character prev = null;
                boolean isSuccess = true;

                for (int i=0; i<bab.length(); i++) {
                    if ((prev != null && prev == bab.charAt(i)) || (Character.isAlphabetic(bab.charAt(i)))) {
                        isSuccess = false;
                        break;
                    }
                    prev = bab.charAt(i);
                }

                if (isSuccess) {
                    answer++;
                }
            }
            return answer;
        }
    }
}
