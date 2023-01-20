package programmers.level2;

import java.util.*;

public class N64065 { // 튜플
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";

        for (int answer : new Solution().solution(s)) {
            System.out.println(answer);
        }
    }

    static class Solution {
        private static Map<String, ArrayList<Integer>> hashMap = new HashMap<>();

        public int[] solution(String s) {
            s = s.substring(2);
            s = s.substring(0, s.length() - 2).replace("},{", "-");
            String[] splits = s.split("-");

            Arrays.sort(splits, (o1, o2) -> o1.length() - o2.length());

            Set<Integer> set = new LinkedHashSet<>();
            for (String str : splits) {
                String[] vals = str.split(",");
                for (String val : vals) {
                    set.add(Integer.parseInt(val));
                }
            }

            return set.stream().mapToInt(i -> i).toArray();
        }
    }
}
