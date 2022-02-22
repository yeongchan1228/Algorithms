package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class StackLevel2 { // 기능 개발
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] answer = {};

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < progresses.length; i++){
            int finishDay = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] == 0)
                queue.offer(finishDay);
            else
                queue.offer(finishDay + 1);
        }


        int[] result = new int[progresses.length];
        int cnt = 0;
        while (!queue.isEmpty()){
            int fin = queue.poll();
            result[cnt]++;

            while (!queue.isEmpty() && queue.peek() <= fin){
                queue.poll();
                result[cnt]++;
            }
            cnt++;
        }

        answer = new int[cnt];
        for(int i = 0; i < cnt; i++)
            answer[i] = result[i];


        System.out.println(Arrays.toString(answer));
    }
}
