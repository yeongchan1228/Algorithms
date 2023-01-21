package programmers.level2;

import java.util.*;

public class N17680 { // 캐시
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(new Solution().solution(cacheSize, cities));
    }

    static class Solution {
        public int solution(int cacheSize, String[] cities) {
            if (cacheSize == 0) {
                return cities.length * 5;
            }

            List<String> list = new LinkedList<>();

            int answer = 0;
            for (String city : cities) {
                city = city.toUpperCase();
                if (list.remove(city)) {
                    answer++;
                    list.add(city);
                } else {
                    answer += 5;
                    if (list.size() == cacheSize) {
                        list.remove(0);
                    }
                    list.add(city);
                }
            }
            return answer;
        }
    }
}
