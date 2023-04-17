package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N43164 { // 여행경로
    public static void main(String[] args) {
        String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        for (String answer : new Solution().solution(tickets)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        static List<String> answer = new ArrayList<>();
        static boolean[] visited;
        public String[] solution(String[][] tickets) {
            visited = new boolean[tickets.length];

            dfs(0, "ICN", "ICN", tickets);

            Collections.sort(answer);

            return answer.get(0).split(" ");
        }

        private void dfs(int depth, String start, String route, String[][] tickets) {
            if (depth == tickets.length) {
                answer.add(route);
                return;
            }

            for (int i = 0; i < tickets.length; i++) {
                if (!visited[i] && start.equals(tickets[i][0])) {
                    visited[i] = true;
                    dfs(depth + 1, tickets[i][1], route + " " + tickets[i][1], tickets);
                    visited[i] = false;
                }
            }
        }
    }
}
