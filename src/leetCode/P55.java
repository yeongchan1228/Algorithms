package leetCode;

public class P55 { // Jump Game
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int possibleFinish = 0;
        for (int i = 0; i < nums.length; i++) {
            int finish = i + nums[i];
            if (i > possibleFinish) {
                return false;
            }
            possibleFinish = Math.max(possibleFinish, finish);
        }
        return true;
    }
}
