package programmers.level2;

import java.util.Queue;
import java.util.LinkedList;

public class N154538 { // 숫자 변환하기
    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;

        System.out.println(new Solution().solution(x, y, n));
    }

     static class Solution {
        public int solution(int x, int y, int n) {
            return bfs(x, y, n);
        }

        private int bfs(int x, int y, int n) {
            Queue<Info> queue = new LinkedList<>();
            queue.offer(new Info(y, 0));

            while (!queue.isEmpty()) {
                Info info = queue.poll();

                if (info.val == x) {
                    return info.depth;
                }

                if (info.val - n >= x) {
                    queue.offer(new Info(info.val - n, info.depth + 1));
                }

                if (info.val % 2 == 0 && info.val / 2 >= x) {
                    queue.offer(new Info(info.val / 2, info.depth + 1));
                }

                if (info.val % 3 == 0 && info.val / 3 >= x) {
                    queue.offer(new Info(info.val / 3, info.depth + 1));
                }
            }

            return -1;
        }

        public static class Info {
            int val;
            int depth;

            public Info(int val, int depth) {
                this.val = val;
                this.depth = depth;
            }
        }
    }
}
