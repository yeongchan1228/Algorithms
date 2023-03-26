package others.leetCode;

import java.util.*;

public class P15 { // 3Sum
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        for (List<Integer> answer : threeSum(nums)) {
            System.out.println(answer);
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> answer = new HashSet<>();
        for(int i = 0; i < nums.length-2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    answer.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                }
                else if(sum < 0){
                    left++;
                }
                else{
                    right--;
                }
            }
        }

        return new ArrayList<>(answer);
    }
}
