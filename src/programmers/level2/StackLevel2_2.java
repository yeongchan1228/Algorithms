package programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

public class StackLevel2_2 { // 프린터
    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        int location = 2;

        int answer = 1;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < priorities.length; i++){
            priorityQueue.offer(priorities[i]);
        }

        boolean flag = false;
        while (!priorityQueue.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(priorityQueue.peek() == priorities[i]){
                    if(i == location){
                        flag = true;
                        break;
                    }
                    else {
                        answer++;
                        priorityQueue.poll();
                    }
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(answer);
    }
}
