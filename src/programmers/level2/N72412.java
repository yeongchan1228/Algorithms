package programmers.level2;

import java.util.*;

public class N72412 { // 순위 검색
    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        for (int answer : new Solution().solution(info, query)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        private static Map<String, ArrayList<Integer>> hashMap = new HashMap<>();

        public int[] solution(String[] info, String[] query) {

            for (String infoStr : info) {
                makeInfo(infoStr.split(" "), "", 0);
            }

            for (String key : hashMap.keySet()) {
                Collections.sort(hashMap.get(key));
            }

            int[] answer = new int[query.length];
            for (int i = 0; i < query.length; i++) {
                 String[] completedQuery = query[i].replaceAll(" and ", "").split(" ");

                 if (hashMap.containsKey(completedQuery[0])) {
                     ArrayList<Integer> scoreByInfo = hashMap.get(completedQuery[0]);

                     int start = 0;
                     int end = scoreByInfo.size() - 1;
                     int score = Integer.parseInt(completedQuery[1]);
                     while (start <= end) {
                         int mid = (start + end) / 2;
                         if (scoreByInfo.get(mid) < score) {
                             start = mid + 1;
                         } else {
                             end = mid - 1;
                         }
                     }

                     answer[i] = scoreByInfo.size() - start;
                 }
            }

            return answer;
        }

        private void makeInfo(String[] infos, String info, int depth) {
            if (depth == 4) {
                ArrayList<Integer> scoreList = hashMap.getOrDefault(info, new ArrayList<>());
                scoreList.add(Integer.parseInt(infos[4]));
                hashMap.put(info, scoreList);
                return;
            }

            makeInfo(infos, info + infos[depth], depth + 1);
            makeInfo(infos, info + "-", depth + 1);
        }
    }

}
