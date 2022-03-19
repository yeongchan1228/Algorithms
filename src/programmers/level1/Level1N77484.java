package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;

public class Level1N77484 { // 로또의 최고 순위와 최저 순위
    public static void main(String[] args) {
        int[] lottos = {45, 4, 35, 20, 3, 9};
        int[] win_nums ={20, 9, 3, 45, 4, 35};

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        int zero = 0;
        for (int i = 0; i < 6; i++) {
            if(lottos[i] != 0) {
                hashMap.put(lottos[i], 1);
            }
            else
                zero++;
        }

        int count = 0;
        for (int i = 0; i < 6; i++) {
            boolean contains = hashMap.containsKey(win_nums[i]);

            if (contains) {
                count++;
            }
        }

        int min = count;
        int max = count;
        for (int i = 0; i < zero; i++) {
            max++;
        }

        int[] answer = new int[2];
        answer[0] = calc(max);
        answer[1] = calc(min);

        System.out.println(Arrays.toString(answer));

    }

    static int calc(int num) {
        switch (num) {
            case 0:
                num = 6;
                return num;

            case 1:
                num = 6;
                return num;

            case 2:
                num = 5;
                return num;

            case 3:
                num = 4;
                return num;

            case 4:
                num = 3;
                return num;

            case 5:
                num = 2;
                return num;

            case 6:
                num = 1;
                return num;
        }
        return 6;
    }
}
