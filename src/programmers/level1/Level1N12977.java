package programmers.level1;

import java.util.Arrays;

public class Level1N12977 { // 소수 만들기

    static int answer = 0;

    public static void main(String[] args) {
        int[] nums = {1,2,7,6,4};

        boolean[] visited = new boolean[nums.length];
        int[] selected = new int[3];

        dfsCalc(nums, visited, selected, 0, 0);

        System.out.println(answer);
    }

    static void dfsCalc(int[] nums, boolean[] visited, int[] selected, int start ,int depth){
        if(depth == 3){
            int sum = 0;
            boolean check = false;
            sum += selected[0] + selected[1] + selected[2];
//            for (int i = 2; i < sum; i++) {
//                if(sum % i == 0){
//                    check = true;
//                    break;
//                }
//            }
            boolean[] calc = new boolean[sum + 1];
            calc[0] = calc[1] = true;
            for (int i = 2; i * i <= sum; i++) {
                if(!calc[i]){
                    calc[i] = true;
                    for (int j = i * i; j <= sum; j += i) {
                        calc[j] = true;
                    }
                }
            }

            if(!calc[sum])
                answer++;
//            if(!check){
//                answer++;
//            }

            return;
        }

        for (int i = start; i < nums.length; i++) {

            if(!visited[i]){
                visited[i] = true;
                selected[depth] = nums[i];

                dfsCalc(nums, visited, selected,i + 1, depth + 1);

                visited[i] = false;
            }

        }


    }
}
