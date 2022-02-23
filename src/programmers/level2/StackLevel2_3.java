package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class StackLevel2_3 { // 다리를 지나는 트럭
    public static void main(String[] args) {
        int bridge_length = 100;
        int weight = 100;
        int[] truck_weights = {10};

        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();

        int weightSize = 0;

        for(int i = 0; i < truck_weights.length; i++){
            int check = truck_weights[i];
            while(true){
                if(queue.isEmpty()){ // 비어있을 때
                    queue.offer(check);
                    weightSize += check;
                    answer++;
                    break;
                }
                else if(queue.size() == bridge_length){
                    weightSize -= queue.poll();
                }
                else{    // 또 들어올 때
                    if(check + weightSize <= weight){
                        queue.offer(check);
                        weightSize += check;
                        answer++;
                        break;
                    }else {
                        queue.offer(0);
                        answer++;
                    }
                }
            }
        }
        answer += bridge_length;
        System.out.println("answer = " + answer);
    }

}
