package programmers.level2;

import java.util.HashMap;
import java.util.Map;

public class N49993 { // 스킬트리

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        System.out.println(new Solution().solution(skill, skill_trees));
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            Map<Character, Integer> map = getMap(skill);

            int answer = 0;
            for (String skillTree : skill_trees) {
                boolean isFinish = true;
                char[] chars = skillTree.toCharArray();
                boolean[] visited = new boolean[skill.length()];
                for (int i = 0; i < chars.length; i++) {
                    if (map.containsKey(chars[i])) {
                        int idx = map.get(chars[i]);
                        if (!checkMap(idx, visited)) {
                            isFinish = false;
                            break;
                        }
                        visited[idx] = true;
                    }
                }

                if (isFinish) {
                    answer++;
                }
            }

            return answer;
        }

        private Map<Character, Integer> getMap(String skill) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < skill.length(); i++) {
                map.put(skill.charAt(i), i);
            }
            return map;
        }

        private boolean checkMap(int idx, boolean[] visited) {
            for (int i = 0; i < idx; i++) {
                if (!visited[i]) {
                    return false;
                }
            }

            return true;
        }
    }
}
