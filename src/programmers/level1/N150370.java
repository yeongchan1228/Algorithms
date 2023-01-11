package programmers.level1;

import java.util.*;

public class N150370 { // 개인정보 수집 유효기간
    public static void main(String[] args) {
        String today = "2022.05.19";
        String[] terms = {"A 6", "B 12", "C 3"};
        String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        for (int answer : new Solution().solution(today, terms, privacies)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        static int MONTHS = 12;
        static int DAYS = 28;

        public int[] solution(String today, String[] terms, String[] privacies) {
            Map<String, Integer> map = setMap(terms);

            int nowDays = getDays(today);
            List<Integer> answer = new ArrayList<>();
            for (int i = 0; i < privacies.length; i++) {
                StringTokenizer st = new StringTokenizer(privacies[i]);
                int days = getDays(st.nextToken()) + map.get(st.nextToken());

                if (nowDays >= days) {
                    answer.add(i + 1);
                }
            }

            return answer.stream().mapToInt(i -> i).toArray();
        }

        private Map setMap(String[] terms) {
            Map<String, Integer> map = new HashMap<>();
            for (String term : terms) {
                StringTokenizer st = new StringTokenizer(term);
                map.put(st.nextToken(), Integer.parseInt(st.nextToken()) * DAYS);
            }
            return map;
        }

        private int getDays(String date) {
            StringTokenizer st = new StringTokenizer(date, ".");
            return Integer.parseInt(st.nextToken()) * MONTHS * DAYS + Integer.parseInt(st.nextToken()) * DAYS + Integer.parseInt(st.nextToken());
        }
    }
}
