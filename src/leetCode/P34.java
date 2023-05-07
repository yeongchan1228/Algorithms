package leetCode;

public class P34 { // Find First and Last Position of Element in Sorted Array
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;

        for (int answer : searchRange(nums, target)) {
            System.out.println(answer);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        for (int start = 0, end = nums.length - 1; start <= end; start++, end--) {
            if (nums[start] == target && nums[end] == target) {
                return new int[]{start, end};
            }

            if (nums[start] == target) {
                int[] answer = new int[2];
                answer[0] = start;

                int idx = start;
                for (int i = start + 1; i < end; i++) {
                    if (nums[i] != target) {
                        break;
                    }
                    idx++;
                }

                answer[1] = idx;
                return answer;
            }

            if (nums[end] == target) {
                int[] answer = new int[2];
                answer[1] = end;

                int idx = end;
                for (int i = end - 1; i > start; i--) {
                    if (nums[i] != target) {
                        break;
                    }
                    idx--;
                }
                answer[0] = idx;
                return answer;
            }
        }

        return new int[]{-1, -1};
    }
}
