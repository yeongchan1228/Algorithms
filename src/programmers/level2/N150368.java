package programmers.level2;

public class N150368 { // 이모티콘 할인행사

    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};
        for (int answer : new Solution().solution(users, emoticons)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        static int[] answer = new int[2];
        static int[] discountRates = {40, 30, 20, 10};

        public int[] solution(int[][] users, int[] emoticons) {
            dfs(0, users, emoticons, new int[emoticons.length]);
            return answer;
        }

        private void dfs(int depth, int[][] users, int[] emoticons, int[] discounts) {
            if (depth == discounts.length) {
                int[] checkAnswer = new int[2];
                for (int[] user : users) {
                    int sum = 0;
                    for (int i = 0; i < discounts.length; i++) {
                        if (discounts[i] >= user[0]) {
                            sum += getDiscountPrice(emoticons[i], discounts[i]);
                        }
                    }

                    if (sum >= user[1]) {
                        checkAnswer[0]++;
                        continue;
                    }

                    checkAnswer[1] += sum;
                }


                if (checkAnswer[0] > answer[0] || (checkAnswer[0] == answer[0] && checkAnswer[1] > answer[1])) {
                    answer = checkAnswer;
                }

                return;
            }

            for (int discountRate : discountRates) {
                discounts[depth] = discountRate;
                dfs(depth + 1, users, emoticons, discounts);
            }
        }

        private int getDiscountPrice(int price, int discountRate) {
            return (int) (price * 0.01 * (100 - discountRate));
        }
    }
}
