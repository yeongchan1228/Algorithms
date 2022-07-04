package programmers.level2;

public class N12899 { // 124 나라의 숫자
    public static void main(String[] args) {
        int n = 10;

        String ans = "";
        String[] nums = {"4", "1", "2"};

        while (n > 0) {
            int r = n % 3;

            n /= 3;
            if(r == 0) n--;

            ans = nums[r] + ans;
        }

        System.out.println(ans);
    }
}
