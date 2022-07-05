package programmers.level1;

import java.util.HashSet;

public class N1845 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2};
        int answer = 0;
        HashSet<Integer> myMonster = new HashSet<>();
        for (int num : nums) {
            myMonster.add(num);
        }

        answer = myMonster.size() >= nums.length / 2 ? nums.length / 2 : myMonster.size();
        System.out.println(answer);
    }
}
