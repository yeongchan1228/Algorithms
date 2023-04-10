package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P179 { // Largest Number
    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(String.valueOf(nums[i]));
        }

        Collections.sort(list, (o1, o2) -> {
            return (o2 + o1).compareTo(o1 + o2);
        });

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(0).startsWith("0")) {
                return "0";
            }
            answer.append(list.get(i));
        }

        return answer.toString();
    }
}
