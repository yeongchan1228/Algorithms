package programmers.level3;

public class N150367 { // 표현 가능한 이진트리
    public static void main(String[] args) {
        long[] numbers = {7, 42, 5};

        for (int answer : new Solution().solution(numbers)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public int[] solution(long[] numbers) {
            int[] answer = new int[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                String binary = getBinary(numbers[i]);

                int idx = 0;
                while ((int) Math.pow(2, idx) - 1 < binary.length()) {
                    idx++;
                }
                while ((int) Math.pow(2, idx) - 1 != binary.length()) {
                    binary = "0" + binary;
                }

                if(dfs(binary)) {
                    answer[i] = 1;
                }
            }

            return answer;
        }

        private boolean dfs(String binary) {
            int mid = binary.length() / 2;
            String left = binary.substring(0, mid);
            String right = binary.substring(mid + 1);

            char root = binary.charAt(mid);
            if (root == '0'  && (left.charAt(left.length() / 2) == '1' || right.charAt(left.length() / 2) == '1')) {
                return false;
            }

            if (left.length() >= 3) {
                if (dfs(left)) {
                    return dfs(right);
                }

                return false;
            }

            return true;
        }

        private String getBinary(long number) {
            StringBuilder sb = new StringBuilder();
            while (number != 1) {
                sb.append(number % 2);
                number /= 2;
            }

            return sb.append(1).reverse().toString();
        }
    }
}

