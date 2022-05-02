package programmers.level2;

import java.util.Arrays;

public class N43165 { // 타켓 넘버(DFS/BFS)

    static int answer, target = 0;
    static String[] sel = new String[5];

    public static void main(String[] args) {
       int[] numbers = {1, 1, 1, 1, 1};
        target = 3;

        dfs(0, numbers, 0);

        System.out.println("answer = " + answer);
    }

    static void dfs(int depth, int[] numbers, int addValue){
        if(numbers.length == depth){
            System.out.println("Arrays.toString(sel) = " + Arrays.toString(sel) + " addV = " + addValue);
            if(addValue == target){
                answer++;
            }
            return;
        }

        sel[depth] = "+" + String.valueOf(numbers[depth]);
        dfs(depth + 1, numbers, addValue + numbers[depth]);
        sel[depth] = "-" + String.valueOf(numbers[depth]);
        dfs(depth + 1, numbers, addValue - numbers[depth]);
    }
}
