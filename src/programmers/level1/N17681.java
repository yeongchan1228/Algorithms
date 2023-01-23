package programmers.level1;

public class N17681 { // 비밀지도
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};

        for (String answer : new Solution().solution(n, arr1, arr2)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public String[] solution(int n, int[] arr1, int[] arr2) {
            String[] answer = new String[n];
            for (int i = 0; i < n; i++) {
                String binary = Integer.toBinaryString(arr1[i] | arr2[i]);

                while (binary.length() != n) {
                    binary = "0" + binary;
                }

                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < binary.length(); j++) {
                    if (binary.charAt(j) == '0') {
                        sb.append(" ");
                        continue;
                    }

                    sb.append("#");
                }

                answer[i] = sb.toString();
            }

            return answer;
        }
    }
}
