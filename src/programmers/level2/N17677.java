package programmers.level2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N17677 { // 뉴스 클러스터링

    public static void main(String[] args) {
        String str1 = "aa1+aa2";
        String str2 = "AAAA12";
        System.out.println(new Solution().solution(str1, str2));
    }

    static class Solution {
        static final int VALUE = 65536;
        public int solution(String str1, String str2) {
            int intersection = 0;
            int union = 0;
            Set<String> keys = new HashSet<>();
            Map<String, Integer> map1 = new HashMap<>();
            Map<String, Integer> map2 = new HashMap<>();

            setInfo(str1.toUpperCase(), map1, keys);
            setInfo(str2.toUpperCase(), map2, keys);

            for (String key : map1.keySet()) {
                if (map1.containsKey(key) && map2.containsKey(key)) {
                    intersection += Math.min(map1.get(key), map2.get(key));
                    union += Math.max(map1.get(key), map2.get(key));
                    keys.remove(key);
                }
            }

            for (String key : keys) {
                if (map1.containsKey(key)) {
                    union += map1.get(key);
                }

                if (map2.containsKey(key)) {
                    union += map2.get(key);
                }
            }

            return union == 0 ? VALUE : (int) Math.floor((intersection / (double) union) * VALUE);
        }

        private void setInfo(String str, Map<String, Integer> map, Set<String> keys) {
            for (int i = 0; i < str.length() - 1; i++) {
                char ch1 = str.charAt(i);
                char ch2 = str.charAt(i + 1);

                if ((ch1 < 'A' || ch1 > 'Z') || (ch2 < 'A' || ch2 > 'Z')) {
                    continue;
                }

                String key = str.substring(i, i + 2);
                keys.add(key);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
        }
    }

}