package leetCode;

public class P26 { // Remove Duplicates from Sorted Array
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }

    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;

        while (right < nums.length) {
            if (nums[left] == nums[right]) {
                while (right < nums.length && nums[left] == nums[right]) {
                    right++;
                }

                if (right == nums.length) {
                    break;
                }

                nums[++left] = nums[right];
                continue;
            }

            left++;
            right++;
        }

        return left + 1;
    }
}
