package leetCode;

import java.util.*;
import java.util.stream.Collectors;

public class P18 { // 4Sum
    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        for (List<Integer> answer : fourSum(nums, target)) {
            System.out.println(answer);
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> answer = new HashSet<>();
        if (nums.length < 4) {
            return new ArrayList(answer);
        }

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                long sum = nums[i] + nums[j];
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long totalSum = sum + nums[left] + nums[right];
                    if (totalSum == target) {
                        answer.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]).stream().collect(Collectors.toList()));
                        left++;
                        right--;
                    } else if (totalSum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }

        return new ArrayList(answer);
    }
}
