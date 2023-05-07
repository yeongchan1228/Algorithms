package leetCode;

public class P1964 { // Find the Longest Valid Obstacle Course at Each Position
    public static void main(String[] args) {
        int[] obstacles = {1, 2, 3, 2};

        for (int answer : longestObstacleCourseAtEachPosition(obstacles)) {
            System.out.println(answer);
        }
    }

    public static int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] dp = new int[obstacles.length];
        int[] answer = new int[obstacles.length];

        int len = 0;
        int cur = 0;
        for (int obstacle : obstacles) {
            int idx = search(len - 1, obstacle, dp);
            if (dp[idx] != obstacle) {
                dp[idx] = obstacle;
            }

            if (idx == len) {
                len++;
            }

            answer[cur++] = idx + 1;
        }

        return answer;
    }

    private static int search(int right, int target, int[] dp) {
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (dp[mid] <= target) {
                left = mid + 1;
                continue;
            }

            right = mid - 1;
        }

        return left;
    }
}
