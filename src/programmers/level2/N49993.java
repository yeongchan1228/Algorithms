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
        private static final Map<Character, Character> skillInfo = new HashMap<>();

        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (int i=0; i<skill.length(); i++) {
                if (i == 0) {
                    skillInfo.put(skill.charAt(0), null);
                    continue;
                }
                skillInfo.put(skill.charAt(i), skill.charAt(i-1));
            }


            for (String skillName : skill_trees) {
                if(checkSkillOrder(skillName)) {
                    answer++;
                }
            }
            return answer;
        }

        private boolean checkSkillOrder(String skillName) {
            for (int i=0; i<skillName.length(); i++) {
                Character partSkill = skillName.charAt(i);
                if (!skillInfo.containsKey(partSkill)) {
                    continue;
                }

                Character prevSkill = skillInfo.get(partSkill);
                if (i == 0) {
                    if (prevSkill != null) {
                        return false;
                    }
                    continue;
                }

                String subSkill = skillName.substring(0, i);
                if (prevSkill != null && !subSkill.contains(String.valueOf(prevSkill))) {
                    return false;
                }
            }
            return true;
        }
    }
}
