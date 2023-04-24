package leetCode;

public class P45 { // Jump Game II
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int jump = 0;
        int endJump = 0;
        int possibleJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            possibleJump = Math.max(possibleJump, nums[i] + i);

            if (endJump == i) {
                jump++;
                endJump = Math.max(endJump, possibleJump);
            }
        }
        return jump;
    }
}
