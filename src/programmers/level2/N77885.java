package programmers.level2;

public class N77885 { // 2개 이하로 다른 비트
    public static void main(String[] args) {
        long[] numbers = {2, 7};
        for (long answer : new Solution().solution(numbers)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public long[] solution(long[] numbers) {
            long[] answer = new long[numbers.length];

            int idx = 0;
            for (long number : numbers) {
                String n = Long.toBinaryString(number);
                if (n.charAt(n.length() - 1) == '0') {
                    answer[idx++] = number + 1;
                    continue;
                }

                StringBuilder sb = new StringBuilder();
                int zeroIdx = n.lastIndexOf("0");
                if (zeroIdx == -1) {
                    sb.append("10").append(n.substring(1));
                } else {
                    sb.append(n, 0, zeroIdx).append("10").append(n.substring(zeroIdx + 2));
                }

                answer[idx++] = Long.parseLong(sb.toString(), 2);
            }

            return answer;
        }
    }
}
