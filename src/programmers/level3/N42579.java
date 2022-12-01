package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class N42579 { // 베스트 앨범
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        for (int answer : new Solution().solution(genres, plays)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            HashMap<String, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < genres.length; i++) {
                hashMap.put(genres[i], hashMap.getOrDefault(genres[i], 0) + plays[i]);
            }

            ArrayList<String> keyList = new ArrayList<>(hashMap.keySet());
            Collections.sort(keyList, (o1, o2) -> hashMap.get(o2) - hashMap.get(o1));

            ArrayList<Integer> answer = new ArrayList<>();
            for (String key : keyList) {
                int maxVal1 = -1;
                int maxVal2 = -1;
                int selectIdx1 = -1;
                int selectIdx2 = -1;
                for (int i = 0; i < genres.length; i++) {
                    if (genres[i].equals(key) && plays[i] > maxVal1) {
                        selectIdx1 = i;
                        maxVal1 = plays[i];
                    }
                }
                answer.add(selectIdx1);

                for (int i = 0; i < genres.length; i++) {
                    if (genres[i].equals(key) && plays[i] > maxVal2 && i != selectIdx1) {
                        selectIdx2 = i;
                        maxVal2 = plays[i];
                    }
                }
                if (selectIdx2 != -1) {
                    answer.add(selectIdx2);
                }
            }

            return answer.stream().mapToInt(i -> i).toArray();
        }
    }
}
