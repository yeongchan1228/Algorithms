package leetCode;

public class P31 { // Next Permutation
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void nextPermutation(int[] nums) {
        int len = nums.length;

        int saveI = -1;
        int saveJ = -1;
        for (int i = len - 1; i > 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i] && j > saveJ) {
                    saveI = i;
                    saveJ = j;
                }
            }
        }

        if (saveJ == -1) {
            reverse(nums, 0, len - 1);
            return;
        }

        swap(nums, saveI, saveJ++);

        while (true) {
            int count = 0;
            for (int i = saveJ; i < len - 1; i++) {
                if (nums[i] > nums[i + 1]) {
                    swap(nums, i, i + 1);
                    count++;
                }
            }

            if (count == 0) {
                break;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
