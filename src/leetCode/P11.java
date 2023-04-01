package leetCode;

public class P11 { // Container With Most Water
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int answer = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = h * (right - left);
            answer = Math.max(answer, w);

            if (height[left] > height[right]) {
                right--;
            } else if (height[left] < height[right]) {
                left++;
            } else {
                left++;
                right--;
            }
        }

        return answer;
    }
}
