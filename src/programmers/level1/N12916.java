package programmers.level1;

public class N12916 { // 문자열 내 p와 y의 개수
    public static void main(String[] args) {
        String s = "pPoooyY";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        boolean solution(String s) {
            int pCnt = 0;
            int yCnt = 0;

            for (char ch : s.toCharArray()) {
                if (ch == 'p' || ch == 'P') {
                    pCnt++;
                    continue;
                }

                if (ch == 'y' || ch == 'Y') {
                    yCnt++;
                }
            }

            return pCnt == yCnt ? true : false;
        }
    }
}
