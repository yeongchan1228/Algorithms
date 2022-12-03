package programmers.level1;

public class N86491 { // 최소직사각형
    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        System.out.println(new Solution().solution(sizes));
    }

    static class Solution {
        public int solution(int[][] sizes) {
            int maxW = 0;
            int maxV = 0;
            for (int[] size : sizes) {
                int lenW = Math.max(size[0], size[1]);
                int lenV = Math.min(size[0], size[1]);

                maxW = Math.max(maxW, lenW);
                maxV = Math.max(maxV, lenV);
            }
            return maxW * maxV;
        }
    }
}
