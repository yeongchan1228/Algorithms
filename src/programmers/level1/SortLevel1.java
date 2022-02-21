package programmers.level1;

import java.util.Arrays;

public class SortLevel1 { // K번째 수
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] answer = new int[commands.length];

        for (int cnt = 0; cnt < commands.length; cnt++) {
            int[] saveArr = Arrays.copyOfRange(array, commands[cnt][0]-1, commands[cnt][1]);
            Arrays.sort(saveArr);
            answer[cnt] = saveArr[commands[cnt][2] - 1];
        }

        System.out.println(Arrays.toString(answer));
    }

}
