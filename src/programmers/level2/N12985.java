package programmers.level2;

public class N12985 { // 예상 대진표
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(new Solution().solution(n, a, b));
    }

    static class Solution {
        public int solution(int n, int a, int b) {
            int answer = 0;
            while (true) {
                answer++;
                a = a / 2 + a % 2;
                b = b / 2 + b % 2;
                if (a == b) {
                    return answer;
                }
            }
        }
    }

}